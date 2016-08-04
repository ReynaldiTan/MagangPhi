package com.phiintegration.ws.model;

public class ms_input_model {
	private int inputID;
	private String state;
	private int state_num;
	private String input;
	private String nextstate;
	private int nextstatenum;
	
	
	public int getInputID() {
		return inputID;
	}
	public void setInputID(int inputID) {
		this.inputID = inputID;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getState_num() {
		return state_num;
	}
	public void setState_num(int state_num) {
		this.state_num = state_num;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getNextstate() {
		return nextstate;
	}
	public void setNextstate(String nextstate) {
		this.nextstate = nextstate;
	}
	public int getNextstatenum() {
		return nextstatenum;
	}
	public void setNextstatenum(int nextstatenum) {
		this.nextstatenum = nextstatenum;
	}
}
