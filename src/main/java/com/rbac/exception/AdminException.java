package com.rbac.exception;

/**
 * Created by Ng on 2017/4/2.
 */
public class AdminException extends Exception{

    public AdminException(String message){
        super(message);
    }
    public AdminException(String message,Throwable cause){
        super(message,cause);
    }
}
