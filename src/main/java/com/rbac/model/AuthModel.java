package com.rbac.model;

/**
 * Created by Ng on 2017/4/30.
 */
public class AuthModel {
    private String id;
    private String name;
    private String authC;
    private String authA;
    private String pid;
    private String state;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
