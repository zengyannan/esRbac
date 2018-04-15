package com.rbac.entity;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ng on 2017/3/30.
 */
public class Auth {

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

    private  long authCreatetime;


    private List<Auth> children;

    public  Auth(){

    }

    public Auth(String authName, int authPid, String authC, String authA,  String authPath, byte authLevel, byte authState, long authCreatetime) {
        this.authName = authName;
        this.authPid = authPid;
        this.authC = authC;
        this.authA = authA;
        this.authPath = authPath;
        this.authLevel = authLevel;
        this.authState = authState;
        this.authCreatetime = authCreatetime;
    }


    public Auth(int authId, String authName, int authPid, String authC, String authA, String authPath, String authUrl, byte authLevel, byte authState, long authCreatetime) {
        this.authId = authId;
        this.authName = authName;
        this.authPid = authPid;
        this.authC = authC;
        this.authA = authA;
        this.authPath = authPath;
        this.authUrl = authUrl;
        this.authLevel = authLevel;
        this.authState = authState;
        this.authCreatetime = authCreatetime;
    }

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

    public long getAuthCreatetime() {
        return authCreatetime;
    }

    public void setAuthCreatetime(long authCreatetime) {
        this.authCreatetime = authCreatetime;
    }

    public List<Auth> getChildren() {
        return children;
    }

    public void setChildren(List<Auth> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "authId=" + authId +
                ", authName='" + authName + '\'' +
                ", authPid=" + authPid +
                ", authC='" + authC + '\'' +
                ", authA='" + authA + '\'' +
                ", authPath='" + authPath + '\'' +
                ", authUrl='" + authUrl + '\'' +
                ", authLevel=" + authLevel +
                ", authState=" + authState +
                ", authCreatetime=" + authCreatetime +
                ", children=" + children +
                '}';
    }
}
