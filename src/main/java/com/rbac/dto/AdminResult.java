package com.rbac.dto;

import com.rbac.entity.Admin;
import com.rbac.enums.AdminStatEnum;
import com.rbac.enums.LoginStatEnum;
import com.rbac.enums.RegisterStatEnum;

/**
 * Created by Ng on 2017/4/2.
 */
public class AdminResult {

    private int state;

    private String stateInfo;

    private Admin admin;



    public AdminResult(Admin admin, LoginStatEnum statEnum){
        this.admin=admin;
        this.state=statEnum.getState();
        this.stateInfo=statEnum.getStateInfo();
    }
    public AdminResult(Admin admin, RegisterStatEnum statEnum){
        this.admin=admin;
        this.state=statEnum.getState();
        this.stateInfo=statEnum.getStateInfo();
    }

    public AdminResult(Admin admin, AdminStatEnum statEnum){
        this.admin=admin;
        this.state=statEnum.getState();
        this.stateInfo=statEnum.getStateInfo();
    }
    public AdminResult(AdminStatEnum statEnum){
        this.state=statEnum.getState();
        this.stateInfo=statEnum.getStateInfo();
    }
    public AdminResult(RegisterStatEnum statEnum){
        this.state=statEnum.getState();
        this.stateInfo=statEnum.getStateInfo();
    }
    public AdminResult(LoginStatEnum statEnum){
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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
