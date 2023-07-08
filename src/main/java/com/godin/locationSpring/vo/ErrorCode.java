package com.godin.locationSpring.vo;

public enum ErrorCode {
    PARAMS_ERROR(10001, "PARAMS_ERROR"),
    ACCOUNT_PWD_NOT_EXIST(10002, "ACCOUNT_PWD_NOT_EXIST"),
    TOKEN_ERROR(10003, "TOKEN_ERROR"),
    NO_PERMISSION(70001, "NO_PERMISSION"),
    SESSION_TIME_OUT(90001, "SESSION_TIME_OUT"),
    NO_LOGIN(90002, "NO_LOGIN"),
    ;

    private int code;
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
