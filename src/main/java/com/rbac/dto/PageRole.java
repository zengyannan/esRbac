package com.rbac.dto;

import java.util.Date;

/**
 * Created by Ng on 2017/4/26.
 */
public class PageRole {
    private int roleId;

    private  String roleName;
    //所拥有的权限的id集合 用,分割
    private  String roleAuthIds;

    //所拥有的模块路径集合
    private  String roleAuthAc;

    private Date roleCreatetime;

    private byte roleState;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleAuthIds() {
        return roleAuthIds;
    }

    public void setRoleAuthIds(String roleAuthIds) {
        this.roleAuthIds = roleAuthIds;
    }

    public String getRoleAuthAc() {
        return roleAuthAc;
    }

    public void setRoleAuthAc(String roleAuthAc) {
        this.roleAuthAc = roleAuthAc;
    }

    public Date getRoleCreatetime() {
        return roleCreatetime;
    }

    public void setRoleCreatetime(Date roleCreatetime) {
        this.roleCreatetime = roleCreatetime;
    }

    public byte getRoleState() {
        return roleState;
    }

    public void setRoleState(byte roleState) {
        this.roleState = roleState;
    }
}
