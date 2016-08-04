package com.phiintegration.ws.model;

public class ms_response {

	private int response_id;
	private int state_num;
	private String state;
	private String response;
	
	public int getResponse_id() {
		return response_id;
	}
	public void setResponse_id(int response_id) {
		this.response_id = response_id;
	}
	public int getState_num() {
		return state_num;
	}
	public void setState_num(int state_num) {
		this.state_num = state_num;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
}
