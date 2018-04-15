package com.rbac.entity;

import com.rbac.model.UserModel;

/**
 * Created by Ng on 2017/3/30.
 */
public class Admin {
    //用户id UUID
    private String adminId;
    //用户名
    private String adminName;
    //用户昵称
    private String adminNickname;

    private String adminPassword;

    private long adminCreatetime;

    private long adminModifytime;

    private String adminEmail;

    private String adminTel;

    private byte adminState;

    private int adminRoleId;

    private Role role;

    public Admin(){
        super();
    }

    public Admin(String adminId, String adminName, String adminNickname, String adminPassword, long adminCreatetime, long adminModifytime, String adminEmail, String adminTel, byte adminState) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminNickname = adminNickname;
        this.adminPassword = adminPassword;
        this.adminCreatetime = adminCreatetime;
        this.adminModifytime = adminModifytime;
        this.adminEmail = adminEmail;
        this.adminTel = adminTel;
        this.adminState = adminState;
    }

    public Admin(UserModel userModel){
        this.adminId=userModel.getId();
        this.adminPassword=userModel.getPassword();
        this.adminName=userModel.getName();
        this.adminNickname=userModel.getNickname();
        this.adminEmail=userModel.getEmail();
        this.adminTel=userModel.getTel();
        this.adminRoleId=Integer.parseInt(userModel.getRoleId());
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminNickname() {
        return adminNickname;
    }

    public void setAdminNickname(String adminNickname) {
        this.adminNickname = adminNickname;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public long getAdminCreatetime() {
        return adminCreatetime;
    }

    public void setAdminCreatetime(long adminCreatetime) {
        this.adminCreatetime = adminCreatetime;
    }

    public long getAdminModifytime() {
        return adminModifytime;
    }

    public void setAdminModifytime(long adminModifytime) {
        this.adminModifytime = adminModifytime;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminTel() {
        return adminTel;
    }

    public void setAdminTel(String adminTel) {
        this.adminTel = adminTel;
    }

    public byte getAdminState() {
        return adminState;
    }

    public void setAdminState(byte adminState) {
        this.adminState = adminState;
    }

    public int getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(int adminRoleId) {
        this.adminRoleId = adminRoleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminNickname='" + adminNickname + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminCreatetime=" + adminCreatetime +
                ", adminModifytime=" + adminModifytime +
                ", adminEmail='" + adminEmail + '\'' +
                ", adminTel='" + adminTel + '\'' +
                ", adminState=" + adminState +
                ", role=" + role +
                '}';
    }
}
