package com.josephocallaghan.taskmanager.config;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class AjaxResponse {
	
	private Boolean success;
	private Integer statusCode; 
	private String header;
	private String message;
	private String errTrace;
	private Map<String, Object> data = new HashMap<String, Object>();
	private Object view = "error";
	 
	public AjaxResponse() {
		header = "info";
		message = "success";
		success = true;
		statusCode = 200;
	}
	
	public AjaxResponse(String msg) {
		header = "info";
		message = msg;
		success = true;
		statusCode = 200;
	}
	 
	public Boolean getSuccess() {
		return success;
	}
	 
	public void setSuccess(Boolean success) {
		this.success = success;
		if(success)
			this.statusCode = 200;
	}
	 
	 
	public void setSuccess(Boolean success, Integer statusCode) {
		this.success = success;
		this.statusCode = statusCode;
	}
	
}