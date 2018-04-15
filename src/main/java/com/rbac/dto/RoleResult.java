package com.rbac.dto;

import com.rbac.entity.Admin;
import com.rbac.entity.Role;
import com.rbac.enums.RoleStatEnum;

/**
 * Created by Ng on 2017/4/3.
 */
public class RoleResult {

    private int state;

    private String stateInfo;

    private Role role;




    public RoleResult(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
        this.role = role;
    }
    public RoleResult(Role role,RoleStatEnum statEnum) {
        this.state = statEnum.getState();
        this.stateInfo =statEnum.getStateInfo();
        this.role = role;
    }
    public RoleResult(RoleStatEnum statEnum) {
        this.state = statEnum.getState();
        this.stateInfo =statEnum.getStateInfo();
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
