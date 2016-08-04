package com.phiintegration.ws.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.json.JSONException;
import org.json.JSONObject;

public class msGeographicLocation {

	DBCon db;
//	public msGeographicLocation() {
//		// TODO Auto-generated constructor stub
//	}

	private int partner_id;
	private int location_id;
	private String location_address1;
	private String location_address2;
	private String location_geographic_lat;
	private String location_geographic_long;
	private int is_validated;
	private int is_primary;
	


	public int getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(int partner_id) {
		this.partner_id = partner_id;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getLocation_address1() {
		return location_address1;
	}

	public void setLocation_address1(String location_address1) {
		this.location_address1 = location_address1;
	}

	public String getLocation_address2() {
		return location_address2;
	}

	public void setLocation_address2(String location_address2) {
		this.location_address2 = location_address2;
	}

	public String getLocation_geographic_lat() {
		return location_geographic_lat;
	}

	public void setLocation_geographic_lat(String location_geographic_lat) {
		this.location_geographic_lat = location_geographic_lat;
	}

	public String getLocation_geographic_long() {
		return location_geographic_long;
	}

	public void setLocation_geographic_long(String location_geographic_long) {
		this.location_geographic_long = location_geographic_long;
	}

	public int getIs_validated() {
		return is_validated;
	}

	public void setIs_validated(int is_validated) {
		this.is_validated = is_validated;
	}

	public int getIs_primary() {
		return is_primary;
	}

	public void setIs_primary(int is_primary) {
		this.is_primary = is_primary;
	}
	
	public void jsonParse(String Json) throws JSONException{
		try {
			Json = URLDecoder.decode(Json,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		JSONObject obj = new JSONObject(Json);
		if(obj.has("partner_id")) this.setPartner_id(obj.getInt("partner_id"));
		if(obj.has("location_id")) this.setLocation_id(obj.getInt("location_id"));
		if(obj.has("location_address1")) this.setLocation_address1(obj.getString("location_address1"));
		if(obj.has("location_address2")) this.setLocation_address2(obj.getString("location_address2"));
		if(obj.has("location_geographic_lat")) this.setLocation_geographic_lat(obj.getString("location_geographic_lat"));
		if(obj.has("location_geographic_long")) this.setLocation_geographic_long(obj.getString("location_geographic_long"));
		if(obj.has("is_validated")) this.setIs_validated(obj.getInt("is_validated"));
		if(obj.has("is_primary")) this.setIs_primary(obj.getInt("is_primary"));
		
	}
}
