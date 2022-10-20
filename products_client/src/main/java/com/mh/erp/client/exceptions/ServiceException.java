package com.mh.erp.client.exceptions;

public class ServiceException extends Exception {
	private String error;
	private String message;
	private Integer code;
    public ServiceException(String message) {
        super(message);
    }
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
}
