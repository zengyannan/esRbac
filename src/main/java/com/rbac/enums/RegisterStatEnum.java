package com.rbac.enums;

/**
 * Created by Ng on 2017/4/2.
 */
public enum RegisterStatEnum {

    REGISTER_SUCCESS(1,"注册成功"),
    REGISTER_FAIL(0,"注册失败"),
    REPEAT_REGISTER(-1,"重复注册"),
    INNER_ERROR(-2,"系统异常");



    private int state;
    private String stateInfo;

    RegisterStatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static RegisterStatEnum stateOf(int index){
        for (RegisterStatEnum state:values()){
            if(state.getState()==index){
                return state;
            }
        }
        return null;
    }


}
