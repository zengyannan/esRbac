package com.rbac.enums;

/**
 * Created by Ng on 2017/4/5.
 */
public enum RoleStatEnum {
    UPDATE_SUCCESS(1,"修改成功"),
    UPDATE_FAIL(0,"登录失败"),
    INNER_ERROR(-2,"系统异常"),
    ROLE_IS_EXIST(-3,"角色已存在"),
    ROLE_NO_EXIST(-4,"角色不存在");



    private int state;
    private String stateInfo;

    RoleStatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static RoleStatEnum stateOf(int index){
        for (RoleStatEnum state:values()){
            if(state.getState()==index){
                return state;
            }
        }
        return null;
    }
}
