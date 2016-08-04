package com.phiintegration.ws.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.json.JSONException;
import org.json.JSONObject;

public class stagingInput {
	
	private int staging_id , state_num;
	
	private String state, message, username,chat_id;

	
	public String getChat_id() {
		return chat_id;
	}
	public void setChat_id(String chat_id) {
		this.chat_id = chat_id;
	}
	public int getStaging_id() {
		return staging_id;
	}
	public void setStaging_id(int staging_id) {
		this.staging_id = staging_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void jsonParse(String json) throws JSONException{		
		JSONObject jsonObj;
		try {
			json = URLDecoder.decode(json,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		jsonObj = new JSONObject(json);
		if(jsonObj.has("username"))this.username = jsonObj.getString("username");		
		if(jsonObj.has("text"))this.message = jsonObj.getString("text");
		if(jsonObj.has("id"))this.chat_id = jsonObj.getString("id");
	}
	

}
