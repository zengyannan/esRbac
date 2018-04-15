package com.rbac.dto;

import com.rbac.entity.Role;

import java.util.Date;

/**
 * Created by Ng on 2017/4/13.
 */
public class PageAdmin {
    //用户id UUID
    private String adminId;
    //用户名
    private String adminName;
    //用户昵称
    private String adminNickname;

    private String adminPassword;

    private Date adminCreatetime;

    private Date adminModifytime;

    private String adminEmail;

    private String adminTel;

    private byte adminState;

    private int adminRoleId;

    private Role role;

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

    public Date getAdminCreatetime() {
        return adminCreatetime;
    }

    public void setAdminCreatetime(Date adminCreatetime) {
        this.adminCreatetime = adminCreatetime;
    }

    public Date getAdminModifytime() {
        return adminModifytime;
    }

    public void setAdminModifytime(Date adminModifytime) {
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
        return "PageAdmin{" +
                "adminId='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminNickname='" + adminNickname + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminCreatetime=" + adminCreatetime +
                ", adminModifytime=" + adminModifytime +
                ", adminEmail='" + adminEmail + '\'' +
                ", adminTel='" + adminTel + '\'' +
                ", adminState=" + adminState +
                ", adminRoleId=" + adminRoleId +
                ", role=" + role +
                '}';
    }
}
