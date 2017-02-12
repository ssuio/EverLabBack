package com.everlab.response;

import javax.persistence.Entity;
import javax.persistence.Table;


public class Response {
	
	private String status;
	private String msg = ""; 
	
	public static final String RESPONSE_SUCCESS = "success";
	public static final String RESPONSE_ERROR = "error";
	
	public Response(){}
	
	public Response(String status, String msg){
		this.status = status;
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Response(String status){
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "{\"status\":\"" + status + "\",\"msg\":\"" + msg + "\"}";
	}
	
	
	
}
