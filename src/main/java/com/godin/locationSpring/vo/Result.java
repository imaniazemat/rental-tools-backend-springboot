package com.godin.locationSpring.vo;

//import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class Result {

    private boolean success;

    private int code;

    private String msg;

    private Object data;

    public Result(boolean b, int i, String string, Object data2) {
		this.success=b;
		this.code=i;
		this.msg=string;
		this.data=data2;
	}

	public static Result success(Object data) {
        return new Result(true, 200, "success", data);
    }

    public static Result fail(int code, String msg) {
        return new Result(false, code, msg, null);
    }

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
    
}
