package com.rbac.exception;

/**
 * Created by Ng on 2017/4/7.
 */
public class AuthException extends Exception {
    public AuthException(String message){
        super(message);
    }
    public AuthException(String message,Throwable cause){

        super(message,cause);
    }
}
