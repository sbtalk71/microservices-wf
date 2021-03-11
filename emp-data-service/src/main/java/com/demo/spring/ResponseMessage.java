package com.demo.spring;

public class ResponseMessage {

	private String message;
	private String statusCode;
	
	public ResponseMessage() {
		
	}

	
	public ResponseMessage(String message, String statusCode) {
		this.message = message;
		this.statusCode = statusCode;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	
}
