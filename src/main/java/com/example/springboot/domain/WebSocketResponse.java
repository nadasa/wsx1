package com.example.springboot.domain;

public class WebSocketResponse {
	private String response;
	

	public WebSocketResponse(String response) {
		super();
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
}
