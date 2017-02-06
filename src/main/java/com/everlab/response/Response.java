package com.everlab.response;

import javax.persistence.Entity;
import javax.persistence.Table;


public class Response {
	
	private String status;
	private String msg; 
	
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
	
	
}
