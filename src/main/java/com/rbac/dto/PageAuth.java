package com.rbac.dto;

import java.util.Date;

/**
 * Created by Ng on 2017/4/30.
 */
public class PageAuth {

    private int authId;

    private String authName;

    private int authPid;
    //模块
    private  String authC;
    //操作
    private  String authA;

    //id路径
    private String authPath;
    //模块操作URL
    private  String authUrl;

    private  byte authLevel;

    private  byte authState;

    private Date authCreatetime;





    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public int getAuthPid() {
        return authPid;
    }

    public void setAuthPid(int authPid) {
        this.authPid = authPid;
    }

    public String getAuthC() {
        return authC;
    }

    public void setAuthC(String authC) {
        this.authC = authC;
    }

    public String getAuthA() {
        return authA;
    }

    public void setAuthA(String authA) {
        this.authA = authA;
    }

    public String getAuthPath() {
        return authPath;
    }

    public void setAuthPath(String authPath) {
        this.authPath = authPath;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    public byte getAuthLevel() {
        return authLevel;
    }

    public void setAuthLevel(byte authLevel) {
        this.authLevel = authLevel;
    }

    public byte getAuthState() {
        return authState;
    }

    public void setAuthState(byte authState) {
        this.authState = authState;
    }

    public Date getAuthCreatetime() {
        return authCreatetime;
    }

    public void setAuthCreatetime(Date authCreatetime) {
        this.authCreatetime = authCreatetime;
    }
}
