package com.pinyougou.vo;

/**
 * Result class
 *
 * @Author: lonelywind
 * @Date: 2018/12/13 9:00
 */
public class Result {
    private Boolean success;
    private String message;

    public Result(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static Result ok(String message) {
        return new Result(true,message);
    }

    public static Result fail(String message) {
        return new Result(false,message);
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
