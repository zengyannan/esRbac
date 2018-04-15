package com.rbac.enums;

/**
 * Created by Ng on 2017/4/2.
 */
public enum LoginStatEnum {
    LOGIN_SUCCESS(1,"登录成功"),
    LOGIN_FAIL(0,"登录失败"),
    PASSWORD_ERROR(-3,"密码错误"),
    REPEAT_LOGIN(-1,"重复登录"),
    INNER_ERROR(-2,"系统异常"),
    ADMIN_NO_USED(-6,"用户处于关闭状态,不可用"),
    ADMIN_ROLE_NO_USED(-7,"用户所属角色处于关闭状态,不可用"),
    USERNAME_OR_PASSWORD_IS_EMPTY(-4,"用户名或密码不能为空"),
    USERNAME_OR_PASSWORD_NO_MATCH(-5,"用户名或密码格式错误");


    private int state;
    private String stateInfo;

    LoginStatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static LoginStatEnum stateOf(int index){
        for (LoginStatEnum state:values()){
            if(state.getState()==index){
                return state;
            }
        }
        return null;
    }
}
