package com.rbac.dto;


import com.rbac.entity.Auth;
import com.rbac.enums.AdminStatEnum;
import com.rbac.enums.AuthStatEnum;


/**
 * Created by Ng on 2017/4/7.
 */
public class AuthResult {
    private int state;

    private String stateInfo;

    private Auth auth;


    public AuthResult(){}
    public AuthResult(Auth auth, AuthStatEnum statEnum){
        this.auth=auth;
        this.state=statEnum.getState();
        this.stateInfo=statEnum.getStateInfo();
    }
    public AuthResult(AdminStatEnum statEnum){
        this.state=statEnum.getState();
        this.stateInfo=statEnum.getStateInfo();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }
}
