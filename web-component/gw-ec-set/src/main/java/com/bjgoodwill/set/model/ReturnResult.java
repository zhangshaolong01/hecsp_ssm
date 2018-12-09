package com.bjgoodwill.set.model;
/**
 * 返回结果封装
 * 
 * @author chronos
 * @date 2017年5月18日 上午10:50:15
 */
public class ReturnResult {
	public static String STATUS_SUCCESS = "success";
	public static String STATUS_ERROR = "error";
	
	private String message;		//返回信息
	
	private String status = "success";		//返回状态，success,error
	
	private Object object;		//返回对象

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
	
}
