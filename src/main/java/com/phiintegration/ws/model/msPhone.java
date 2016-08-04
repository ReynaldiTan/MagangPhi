package com.phiintegration.ws.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.json.JSONException;
import org.json.JSONObject;

public class msPhone {
	public msPhone() {
		// TODO Auto-generated constructor stub
	}
	
	private int partner_id;
	private int phone_id;
	private String phone_type;
	private String phone_number;
	private String phone_extension;
	private String phone_country_code;
	private String phone_area_code;
	private String phone_description;
	private int is_primary_phone;
	
	public int getPartner_id() {
		return partner_id;
	}
	public void setPartner_id(int partner_id) {
		this.partner_id = partner_id;
	}
	public int getPhone_id() {
		return phone_id;
	}
	public void setPhone_id(int phone_id) {
		this.phone_id = phone_id;
	}
	public String getPhone_type() {
		return phone_type;
	}
	public void setPhone_type(String phone_type) {
		this.phone_type = phone_type;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getPhone_extension() {
		return phone_extension;
	}
	public void setPhone_extension(String phone_extension) {
		this.phone_extension = phone_extension;
	}
	public String getPhone_country_code() {
		return phone_country_code;
	}
	public void setPhone_country_code(String phone_country_code) {
		this.phone_country_code = phone_country_code;
	}
	public String getPhone_area_code() {
		return phone_area_code;
	}
	public void setPhone_area_code(String phone_area_code) {
		this.phone_area_code = phone_area_code;
	}
	public String getPhone_description() {
		return phone_description;
	}
	public void setPhone_description(String phone_description) {
		this.phone_description = phone_description;
	}
	public int isIs_primary_phone() {
		return is_primary_phone;
	}
	public void setIs_primary_phone(int is_primary_phone) {
		this.is_primary_phone = is_primary_phone;
	}

	public void jsonParse(String Json) throws JSONException{
		try {
			Json = URLDecoder.decode(Json,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		JSONObject obj = new JSONObject(Json);
		if(obj.has("partner_id")) this.setPartner_id(obj.getInt("partner_id"));
		if(obj.has("phone_id")) this.setPhone_id(obj.getInt("phone_id"));
		if(obj.has("phone_type")) this.setPhone_type(obj.getString("phone_type"));
		if(obj.has("phone_number")) this.setPhone_number(obj.getString("phone_number"));
		if(obj.has("phone_extension")) this.setPhone_extension(obj.getString("phone_extension"));
		if(obj.has("phone_country_code")) this.setPhone_country_code(obj.getString("phone_country_code"));
		if(obj.has("phone_area_code")) this.setPhone_area_code(obj.getString("phone_area_code"));
		if(obj.has("phone_description")) this.setPhone_description(obj.getString("phone_description"));
		if(obj.has("is_primary_phone")) this.setIs_primary_phone(obj.getInt("is_primary_phone"));
		
	}
}
