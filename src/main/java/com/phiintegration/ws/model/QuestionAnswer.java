package com.phiintegration.ws.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.json.JSONException;
import org.json.JSONObject;

public class QuestionAnswer {
	private int question_id;
	private int partner_id;
	private String question_description;
	private int line_order;
	
	public QuestionAnswer(){
		
	}
	
	public QuestionAnswer(int question_id, int partner_id, String question_description, int line_order) {
		this.question_id = question_id;
		this.partner_id = partner_id;
		this.question_description = question_description;
		this.line_order = line_order;
	}
	
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public int getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(int partner_id) {
		this.partner_id = partner_id;
	}
	public String getQuestion_description() {
		return question_description;
	}
	public void setQuestion_description(String question_description) {
		this.question_description = question_description;
	}
	public int getLine_order() {
		return line_order;
	}
	public void setLine_order(int line_order) {
		this.line_order = line_order;
	}
	
	public void jsonParse(String json) throws JSONException{		
		JSONObject jsonObj;
		try {
			json = URLDecoder.decode(json,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		jsonObj = new JSONObject(json);
		if(jsonObj.has("question_id"))this.question_id = jsonObj.getInt("question_id");		
		if(jsonObj.has("partner_id"))this.partner_id = jsonObj.getInt("partner_id");
		if(jsonObj.has("question_description"))this.question_description = jsonObj.getString("question_description");
		if(jsonObj.has("line_order"))this.line_order = jsonObj.getInt("line_order");
	}
}
