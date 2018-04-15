package com.rbac.exception;

/**
 * Created by Ng on 2017/4/5.
 */
public class RoleException extends  Exception {
    public RoleException(String message){
        super(message);
    }
    public RoleException(String message,Throwable cause){
        super(message,cause);
    }
}
