package com.tcs.webapp.dto;

public class BaseResponse {
	
	private String status;
	private String errorCode;
	private String errorMesage;
	private Object data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMesage() {
		return errorMesage;
	}
	public void setErrorMesage(String errorMesage) {
		this.errorMesage = errorMesage;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	

}
