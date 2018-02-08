package com.app.common;

public class BaseResult {

	private int code;
	private String message;
	private Object data;

	public BaseResult() {

	}

	public BaseResult(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public BaseResult(int code) {
		super();
		this.code = code;
	}

	public BaseResult(int code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	public static BaseResult ok() {
		return new BaseResult(200, "操作成功");
	}

	public static BaseResult ok(Object data) {
		return new BaseResult(200, "操作成功", data);
	}

	public static BaseResult ok(String message, Object data) {
		return new BaseResult(200, message, data);
	}

	public BaseResult(int code, Object data) {
		super();
		this.code = code;
		this.data = data;
	}

	public static BaseResult build(int code, String message) {
		return new BaseResult(code, message);
	}

	public static BaseResult build(int code, String message, Object data) {
		return new BaseResult(code, message, data);
	}
}
