package com.rbac.entity;

/**
 * Created by Ng on 2017/3/30.
 */
public class Role {
    private int roleId;

    private  String roleName;
    //所拥有的权限的id集合 用,分割
    private  String roleAuthIds;

    //所拥有的模块路径集合
    private  String roleAuthAc;

    private long roleCreatetime;

    private byte roleState;


    public Role(){}

    public Role(String roleName, long roleCreatetime, byte roleState) {
        this.roleName = roleName;
        this.roleCreatetime = roleCreatetime;
        this.roleState = roleState;
    }

    public Role(int roleId, String roleName, String roleAuthIds, String roleAuthAc, long roleCreatetime, byte roleState) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleAuthIds = roleAuthIds;
        this.roleAuthAc = roleAuthAc;
        this.roleCreatetime = roleCreatetime;
        this.roleState = roleState;
    }

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

    public long getRoleCreatetime() {
        return roleCreatetime;
    }

    public void setRoleCreatetime(long roleCreatetime) {
        this.roleCreatetime = roleCreatetime;
    }

    public byte getRoleState() {
        return roleState;
    }

    public void setRoleState(byte roleState) {
        this.roleState = roleState;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleAuthIds='" + roleAuthIds + '\'' +
                ", roleAuthAc='" + roleAuthAc + '\'' +
                ", roleCreatetime=" + roleCreatetime +
                ", roleState=" + roleState +
                '}';
    }
}
