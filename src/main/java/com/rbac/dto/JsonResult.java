package com.rbac.dto;

/**
 * Created by Ng on 2017/4/2.
 */
public class JsonResult<T> {
    private boolean success;
    private T data;
    private String error;


    public JsonResult() {
    }

    public JsonResult(boolean success, T data, String error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public JsonResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public JsonResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
