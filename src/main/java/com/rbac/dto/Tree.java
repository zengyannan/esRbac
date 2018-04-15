package com.rbac.dto;

import com.rbac.entity.Auth;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ng on 2017/4/10.
 */
public class Tree {

    private int authId;

    private String Text;

    private int authPid;

    private  String href;

    private List<Tree> nodes;


    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public int getAuthPid() {
        return authPid;
    }

    public void setAuthPid(int authPid) {
        this.authPid = authPid;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Tree> getNodes() {
        return nodes;
    }

    public void setNodes(List<Tree> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "authId=" + authId +
                ", Text='" + Text + '\'' +
                ", authPid=" + authPid +
                ", href='" + href + '\'' +
                ", nodes=" + nodes +
                '}';
    }
}
