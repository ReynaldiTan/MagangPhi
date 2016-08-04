package com.phiintegration.ws.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;


public class msPartner {
	public msEmail email = new msEmail();
	public msPhone phone = new msPhone();
	public msGeographicLocation location = new msGeographicLocation();

	public Map<String, msEmail> listEmail = new HashMap<String, msEmail>();
	 
	private int partner_id;
	private String partner_external_id;
	private String partner_alias;
	private String partner_name;
	private String partner_location_id;
	private String partner_logo;
	private int is_active;

	public msPartner() {
		// TODO Auto-generated constructor stub
	}

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
	 * @return the partner_external_id
	 */
	public String getPartner_external_id() {
		return partner_external_id;
	}



	/**
	 * @param partner_external_id the partner_external_id to set
	 */
	public void setPartner_external_id(String partner_external_id) {
		this.partner_external_id = partner_external_id;
	}



	/**
	 * @return the partner_alias
	 */
	public String getPartner_alias() {
		return partner_alias;
	}



	/**
	 * @param partner_alias the partner_alias to set
	 */
	public void setPartner_alias(String partner_alias) {
		this.partner_alias = partner_alias;
	}



	/**
	 * @return the partner_name
	 */
	public String getPartner_name() {
		return partner_name;
	}

	/**
	 * @param partner_name the partner_name to set
	 */
	public void setPartner_name(String partner_name) {
		this.partner_name = partner_name;
	}

	/**
	 * @return the partner_location_id
	 */
	public String getPartner_location_id() {
		return partner_location_id;
	}



	/**
	 * @param partner_location_id the partner_location_id to set
	 */
	public void setPartner_location_id(String partner_location_id) {
		this.partner_location_id = partner_location_id;
	}



	/**
	 * @return the partner_logo
	 */
	public String getPartner_logo() {
		return partner_logo;
	}



	/**
	 * @param partner_logo the partner_logo to set
	 */
	public void setPartner_logo(String partner_logo) {
		this.partner_logo = partner_logo;
	}



	/**
	 * @return the is_active
	 */
	public int getIs_active() {
		return is_active;
	}


	/**
	 * @param is_active the is_active to set
	 */
	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}
	
	public boolean addEmail(String email)
	{
		msEmail tmpEmail = new msEmail();
		tmpEmail.setEmail_address(email);
		
		if(!listEmail.containsKey(email))
		{
			listEmail.put(email, tmpEmail);
			return true;
		}
		return false;
	}
	
	public boolean removeEmail(String email)
	{
		listEmail.remove(email);
		return true;
	}

	public boolean printEmailList()
	{
		for (Entry<String, msEmail> entry : listEmail.entrySet())
	    {
	      System.out.println(entry.getValue().getEmail_address());
	    }
		return true;
	}	
	
	public void jsonParse(String input) throws JSONException{
		try {
			input = URLDecoder.decode(input,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		JSONObject jsonObj = new JSONObject(input);
		if(jsonObj.has("partner_name"))this.setPartner_name(jsonObj.getString("partner_name"));		
		if(jsonObj.has("partner_logo"))this.setPartner_logo(jsonObj.getString("partner_logo"));
		if(jsonObj.has("partner_alias"))this.setPartner_alias(jsonObj.getString("partner_alias"));
		if(jsonObj.has("partner_external_id"))this.setPartner_external_id(jsonObj.getString("partner_external_id"));
		if(jsonObj.has("is_active"))this.setIs_active(jsonObj.getInt("is_active"));
		
	}
}
