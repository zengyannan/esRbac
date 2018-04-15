package com.rbac.web;

import com.rbac.dto.*;
import com.rbac.entity.Auth;
import com.rbac.entity.Role;
import com.rbac.exception.AuthException;
import com.rbac.model.AuthModel;
import com.rbac.model.UserModel;
import com.rbac.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.standard.DateTimeContext;
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

import static javafx.scene.input.KeyCode.M;

/**
 * Created by Ng on 2017/4/26.
 */
@Controller
@RequestMapping("/auth")
public class AuthController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AuthService authService;


    @RequestMapping(value ="/getAuthTree",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public JsonResult<Auth> getAuthTree(){
        return new JsonResult(true,authService.getAuthTree());
    }

    @RequestMapping(value ="/getAllAuth",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public JsonResult getAllAuth(){
        return new JsonResult(true,authService.getAllAuth());
    }

    @RequestMapping("/list")
    public String list(Model model,
                       @RequestParam(value ="pageNow", defaultValue ="1",required = false)String pageNow,
                       @RequestParam(value = "pageSize",defaultValue = "5",required = false) String pageSize){
        int now = Integer.parseInt(pageNow);
        int size= Integer.parseInt(pageSize);
        Page<PageAuth> page =authService.getPage(now,size);
        model.addAttribute("title","权限列表");
        model.addAttribute("page",page);
        return "authList";
    }
    @RequestMapping(value ="/add",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public JsonResult add(AuthModel authModel){
        Auth auth= new Auth();
        auth.setAuthName(authModel.getName().trim());
        auth.setAuthC(authModel.getAuthC().trim());
        auth.setAuthA(authModel.getAuthA().trim());
        auth.setAuthState(new Byte(authModel.getState().trim()));
        auth.setAuthPid(Integer.parseInt(authModel.getPid()));
        auth.setAuthCreatetime(new Date().getTime());
        AuthResult authResult;
        try{
            authResult=authService.insertAuth(auth);
        }catch (AuthException e){
            return  new JsonResult(false,e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
        return new JsonResult(true,authResult);
    }
    @RequestMapping(value ="/edit",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public JsonResult edit(AuthModel authModel){
        Auth auth =new Auth();
        AuthResult authResult;
        auth.setAuthId(Integer.parseInt(authModel.getId().trim()));
        auth.setAuthName(authModel.getName().trim());
        auth.setAuthC(authModel.getAuthC().trim());
        auth.setAuthA(authModel.getAuthA().trim());
        auth.setAuthPid(Integer.parseInt(authModel.getPid().trim()));
        try {
             authResult =authService.updateAuth(auth);
        }catch (AuthException e){
            return  new JsonResult(false,e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return  new JsonResult(false,e.getMessage());
        }
        return new JsonResult(true,authResult);
    }

    @RequestMapping(value ="/delete",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public JsonResult delete(@RequestParam("authId") String authId){
        try{
            authService.deleteAuth(Integer.parseInt(authId.trim()));
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
    public JsonResult<Map> updateState(@RequestParam("authId")String authId,@RequestParam("authState")String authState){
        Map map = new HashMap();
        try {
            authService.updateState(Integer.parseInt(authId.trim()),new Byte(authState.trim()));
            Auth auth =authService.getAuthById(Integer.parseInt(authId.trim()));
            map.put("state",auth.getAuthState());
        }catch (Exception e){
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
        return new JsonResult(true,map);
    }
    public AuthService getAuthService() {
        return authService;
    }

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }
}
