package com.phiintegration.ws.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.json.JSONException;
import org.json.JSONObject;

public class msUserState {
	private int user_ID;
	private String users;
	private String state;
	private int stateNum;
	private boolean Check;
	
	public int getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getStateNum() {
		return stateNum;
	}

	public void setStateNum(int stateNum) {
		this.stateNum = stateNum;
	}

	public boolean isCheck() {
		return Check;
	}

	public void setCheck(boolean check) {
		Check = check;
	}

	public void jsonParse(String json) throws JSONException{		
		JSONObject jsonObj;
		try {
			json = URLDecoder.decode(json,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		jsonObj = new JSONObject(json);
		if(jsonObj.has("user_ID"))this.user_ID = jsonObj.getInt("user_ID");		
		if(jsonObj.has("users"))this.users = jsonObj.getString("users");
		if(jsonObj.has("state"))this.state = jsonObj.getString("state");
		if(jsonObj.has("stateNum"))this.stateNum = jsonObj.getInt("stateNum");
		if(jsonObj.has("Check"))this.Check = jsonObj.getBoolean("Check");
	}
	

}
