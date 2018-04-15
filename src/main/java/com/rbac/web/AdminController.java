package com.rbac.web;

import com.rbac.dto.AdminResult;
import com.rbac.dto.JsonResult;
import com.rbac.dto.Page;

import com.rbac.entity.Admin;
import com.rbac.entity.Auth;
import com.rbac.enums.LoginStatEnum;
import com.rbac.exception.AdminException;
import com.rbac.model.UserModel;
import com.rbac.service.AdminService;
import com.rbac.service.IndexService;
import com.rbac.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.*;


/**
 * Created by Ng on 2017/4/9.
 */
@Controller
@RequestMapping("/admin")//url:/模块/资源/{id}/细分 /seckill/list
public class AdminController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AdminService adminService;
    @Autowired
    private IndexService indexService;

    @RequestMapping(value="/list",
            method = RequestMethod.GET
    )
    public String list(Model model,
                        @RequestParam(value ="pageNow", defaultValue ="1",required = false)String pageNow,
                        @RequestParam(value = "pageSize",defaultValue = "5",required = false) String pageSize){
        int now = Integer.parseInt(pageNow);
        int size= Integer.parseInt(pageSize);
        Page page =adminService.getPage(now,size);
        model.addAttribute("title","用户列表");
        model.addAttribute("page",page);
        return "adminList";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("title","登录页");
        return "login";
    }

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public JsonResult<AdminResult> doLogin(
                                           @RequestParam(value = "userName")String userName,
                                           @RequestParam(value = "password")String password,
                                           HttpSession httpSession){
        AdminResult adminResult;
        if(userName==null || password==null){
            return new JsonResult<>(false,LoginStatEnum.USERNAME_OR_PASSWORD_IS_EMPTY.getStateInfo());
        }
        if(userName.equals("")||password.equals("")){
            return new JsonResult<>(false,LoginStatEnum.USERNAME_OR_PASSWORD_IS_EMPTY.getStateInfo());
        }
        List<Boolean> result =CommonUtils.matchUserNameAndPassword(userName,password);
        boolean flag=true;
        for (Boolean b:result) {
            if(b==false){
                flag=false;
            }
        }
        if(flag){
            try{
                adminResult=adminService.login(userName,password);
                httpSession.setAttribute("user",adminResult.getAdmin());
                httpSession.setAttribute("leftTree",indexService.getTree(adminResult.getAdmin().getAdminId()));
                return new JsonResult<AdminResult>(true,adminResult);
            }catch (AdminException e){
                return new JsonResult<>(false,e.getMessage());
            }catch (Exception e){
                return new JsonResult<>(false,e.getMessage());
            }
        }else{
            return new JsonResult<>(false,LoginStatEnum.USERNAME_OR_PASSWORD_NO_MATCH.getStateInfo());
        }
    }

    @RequestMapping(value = "/logout",method =RequestMethod.GET)
    public  String logout(HttpSession httpSession){
        Enumeration<String>sessions =httpSession.getAttributeNames();
        while(sessions.hasMoreElements()){
            String sessisonName =sessions.nextElement();
            httpSession.removeAttribute(sessisonName);
        }
        return "redirect:/admin/login";
    }

    @RequestMapping(value ="/add",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public JsonResult add(UserModel user){
        Admin admin =new Admin();
        boolean flag=true;
        List<Boolean> result =CommonUtils.validateUser(user);
        for (Boolean b:result) {
            if(b==false){
                flag=false;
            }
        }
        if(!flag){
            return new JsonResult(false,"数据格式错误");
        }
        admin.setAdminName(user.getName().trim());
        admin.setAdminNickname(user.getNickname().trim());
        admin.setAdminPassword(user.getPassword().trim());
        admin.setAdminCreatetime(new Date().getTime());
        admin.setAdminModifytime(new Date().getTime());
        admin.setAdminState(new Byte(user.getState().trim()));
        admin.setAdminTel(user.getTel().trim());
        admin.setAdminEmail(user.getEmail().trim());
        admin.setAdminRoleId(Integer.parseInt(user.getRoleId().trim()));
        AdminResult adminResult;
        try{
             adminResult =adminService.register(admin);
        }catch (AdminException e){
            return new JsonResult(false,e.getMessage());
        }catch (Exception e){
            return new JsonResult(false,e.getMessage());
        }
        return new JsonResult(true,adminResult);
    }
    @RequestMapping(value ="/edit",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public JsonResult edit(UserModel user){
        System.out.print(user);
        Admin admin =new Admin(user);
        admin.setAdminModifytime(new Date().getTime());
        AdminResult adminResult;
        try{
            adminResult=adminService.updateAdmin(admin);
        }catch (AdminException e){
            return new JsonResult(false,e.getMessage());
        }catch (Exception e){
            return new JsonResult(false,e.getMessage());
        }
        return new JsonResult(true,adminResult);
    }
    @RequestMapping(value ="/delete",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public JsonResult deltet(@RequestParam(value = "adminId") String adminId){
        try{
            adminService.deleteAdmin(adminId);
        }catch (Exception e){
            return new JsonResult(false,e.getMessage());
        }
        return new JsonResult(true,null);
    }
    @RequestMapping(value ="/updateState",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public JsonResult<Map> updateState(@RequestParam("adminId")String adminId,@RequestParam("adminState")String adminState){
        Map map = new HashMap();
        try {
            adminService.updateState(adminId.trim(),new Byte(adminState.trim()));
            Admin admin =adminService.getAdminById(adminId.trim());
            map.put("state",admin.getAdminState());
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
        return new JsonResult(true,map);
    }
}
