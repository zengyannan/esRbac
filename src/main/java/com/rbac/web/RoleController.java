package com.rbac.web;

import com.rbac.dto.JsonResult;
import com.rbac.dto.Page;
import com.rbac.dto.PageRole;
import com.rbac.dto.RoleResult;
import com.rbac.entity.Role;
import com.rbac.exception.RoleException;
import com.rbac.model.RoleModel;
import com.rbac.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ng on 2017/4/21.
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RoleService roleService;

    @RequestMapping(value ="/getAllRole",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public JsonResult<List<Role>> getAllRole(){
        return new JsonResult<>(true,roleService.getAllRole());
    }
    @RequestMapping("/list")
    public String list(Model model,
                       @RequestParam(value ="pageNow", defaultValue ="1",required = false)String pageNow,
                       @RequestParam(value = "pageSize",defaultValue = "5",required = false) String pageSize){
        int now = Integer.parseInt(pageNow);
        int size= Integer.parseInt(pageSize);
        Page<PageRole> page =roleService.getPage(now,size);
        model.addAttribute("title","角色列表");
        model.addAttribute("page",page);
        return "roleList";
    }



    @RequestMapping(value ="/add",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public JsonResult add(RoleModel roleModel){
        Role role =new Role();
        RoleResult roleResult;
        role.setRoleName(roleModel.getName().trim());
        role.setRoleAuthIds(roleModel.getAuthIds().trim());
        role.setRoleState(new Byte(roleModel.getState().trim()));
        role.setRoleCreatetime(new Date().getTime());
        try{
            roleResult =roleService.insertRole(role);
        }catch (RoleException e){
            return new JsonResult(false,e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
        return  new JsonResult(true,roleResult);
    }

    @RequestMapping(value ="/edit",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public JsonResult edit(RoleModel roleModel){
        Role role =new Role();
        role.setRoleId(Integer.parseInt(roleModel.getId().trim()));
        role.setRoleName(roleModel.getName().trim());
        role.setRoleAuthIds(roleModel.getAuthIds().trim());
        RoleResult roleResult;
        try{
             roleResult =roleService.updateRole(role);
        }catch (RoleException e){
            return new JsonResult(false,e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
        return new JsonResult(true,roleResult);
    }
    @RequestMapping(value ="/delete",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public JsonResult delete(@RequestParam(value = "roleId") String roleId){
        try{
            roleService.deleteRole(Integer.parseInt(roleId.trim()));
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
        return new JsonResult(true,null);
    }
    @RequestMapping(value ="/updateState",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public JsonResult<Map> updateState(@RequestParam(value = "roleId") String roleId, @RequestParam("roleState") String roleState){
        Map map  = new HashMap<>();
        try{
            roleService.updateState(Integer.parseInt(roleId.trim()),new Byte(roleState.trim()));
            Role role = roleService.getRoleById(Integer.parseInt(roleId.trim()));
            map.put("state",role.getRoleState());
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
        return new JsonResult(true,map);
    }
}
