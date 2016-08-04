package com.phiintegration.ws.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.json.JSONException;
import org.json.JSONObject;

public class msEmail {

	DBCon db;
	
//	public msEmail() {
//		// TODO Auto-generated constructor stub
//		
//	}
	
	private int partner_id;
	private String email_id;
	private String email_type;
	private String email_address;
	private int is_primary_email;
	
	/**
	 * @return the partner_id
	 */
	public int getPartner_id() {
		return partner_id;
	}

	/**
	 * @param partner_id the partner_id to set
	 */
	public void setPartner_id(int partner_id) {
		this.partner_id = partner_id;
	}

	/**
	 * @return the email_id
	 */
	public String getEmail_id() {
		return email_id;
	}

	/**
	 * @param email_id the email_id to set
	 */
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	/**
	 * @return the email_type
	 */
	public String getEmail_type() {
		return email_type;
	}

	/**
	 * @param email_type the email_type to set
	 */
	public void setEmail_type(String email_type) {
		this.email_type = email_type;
	}

	/**
	 * @return the email_address
	 */
	public String getEmail_address() {
		return email_address;
	}

	/**
	 * @param email_address the email_address to set
	 */
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	/**
	 * @return the is_primary_email
	 */
	public int getIs_primary_email() {
		return is_primary_email;
	}

	/**
	 * @param is_primary_email the is_primary_email to set
	 */
	public void setIs_primary_email(int is_primary_email) {
		this.is_primary_email = is_primary_email;
	}
	
	public void jsonParse(String Json) throws JSONException{
		try {
			Json = URLDecoder.decode(Json,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		JSONObject obj = new JSONObject(Json);
		if(obj.has("partner_id")) this.setPartner_id(obj.getInt("partner_id"));
		if(obj.has("email_id")) this.setEmail_id(obj.getString("email_id"));
		if(obj.has("email_type")) this.setEmail_type(obj.getString("email_type"));
		if(obj.has("email_address")) this.setEmail_address(obj.getString("email_address"));
		if(obj.has("is_primary_email")) this.setIs_primary_email(obj.getInt("is_primary_email"));

	}
}
