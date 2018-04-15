package com.rbac.web;

import com.rbac.dto.JsonResult;
import com.rbac.dto.Tree;
import com.rbac.entity.Admin;
import com.rbac.entity.Auth;
import com.rbac.exception.AdminException;
import com.rbac.exception.RoleException;
import com.rbac.service.AdminService;
import com.rbac.service.AuthService;
import com.rbac.service.IndexService;
import com.rbac.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Ng on 2017/4/9.
 */
@Controller
@RequestMapping(value="/index")//url:/模块/资源/{id}/细分 /seckill/list
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(value="/index",
            method = RequestMethod.GET
    )
    public String index(Model model,HttpSession httpSession){
        Admin admin=(Admin)httpSession.getAttribute("user");
        model.addAttribute("admin",admin);
        model.addAttribute("title","首页");
        return "index";
    }

    @RequestMapping(value="/leftTree",
            method=RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public JsonResult<Tree> getTree(HttpSession httpSession){
        //@PathVariable("adminId") String adminId
        Tree tree=null;
        tree =(Tree) httpSession.getAttribute("leftTree");
        if(tree==null){
            try {
                Admin admin=(Admin)httpSession.getAttribute("user");
                tree = indexService.getTree(admin.getAdminId());
            }catch (AdminException e){
                System.out.print(e.getMessage());
            }catch (RoleException e){
                System.out.print(e.getMessage());
            }catch (Exception e){
                System.out.print(e.getMessage());
            }
        }
        return new JsonResult(true,tree);
    }
    @RequestMapping(value="/authTree",
            method=RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public JsonResult<Auth> getAuthNodes(){
        //@PathVariable("adminId") String adminId
        String adminId ="0";
        Auth auth=null;
        try {
            auth = indexService.getAuthTree(adminId);
        }catch (AdminException e){
            System.out.print(e.getMessage());
        }catch (RoleException e){
            System.out.print(e.getMessage());
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        return new JsonResult<Auth>(true,auth);
    }
    @RequestMapping(value = "/error")
    public  String  error(){
        return "error";
    }
}
