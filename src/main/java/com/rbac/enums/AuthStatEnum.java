package com.rbac.enums;

/**
 * Created by Ng on 2017/4/7.
 */
public enum AuthStatEnum {
    UPDATE_SUCCESS(1,"修改成功"),
    UPDATE_FAIL(0,"修改失败"),
    INNER_ERROR(-2,"系统异常"),
    AUTH_NO_EXIST(-4,"用户不存在"),
    AUTH_IS_EXIST(-3,"权限已存在");



    private int state;
    private String stateInfo;

    AuthStatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static AuthStatEnum stateOf(int index){
        for (AuthStatEnum state:values()){
            if(state.getState()==index){
                return state;
            }
        }
        return null;
    }
}
