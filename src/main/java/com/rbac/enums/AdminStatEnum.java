package com.rbac.enums;

/**
 * Created by Ng on 2017/4/3.
 */
public enum  AdminStatEnum {
    UPDATE_SUCCESS(1,"修改成功"),
    UPDATE_FAIL(0,"登录失败"),
    INNER_ERROR(-2,"系统异常"),
    ADMIN_IS_EXIST(-3,"用户已存在"),
    ADMIN_NO_EXIST(-4,"用户不存在"),
    ADMIN_NAME_IS_EXIST(-4,"用户名已存在");


    private int state;
    private String stateInfo;

    AdminStatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static AdminStatEnum stateOf(int index){
        for (AdminStatEnum state:values()){
            if(state.getState()==index){
                return state;
            }
        }
        return null;
    }
}
