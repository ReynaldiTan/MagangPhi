package com.phiintegration.ws.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.json.JSONException;
import org.json.JSONObject;

public class msStock {
	private int stock_id;
	private int distributor_partner_id;
	private	String distributor_name;
	private int product_id;
	private String product_name;
	private String product_unit;
	private int product_quantity;
	private int is_active;
	
	public int getStock_id() {
		return stock_id;
	}
	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}
	public int getDistributor_partner_id() {
		return distributor_partner_id;
	}
	public void setDistributor_partner_id(int distributor_partner_id) {
		this.distributor_partner_id = distributor_partner_id;
	}
	public String getDistributor_name() {
		return distributor_name;
	}
	public void setDistributor_name(String distributor_name) {
		this.distributor_name = distributor_name;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_unit() {
		return product_unit;
	}
	public void setProduct_unit(String product_unit) {
		this.product_unit = product_unit;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public int getIs_active() {
		return is_active;
	}
	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}
	
	public void jsonParse(String json) throws JSONException{		
		JSONObject jsonObj;
		try {
			json = URLDecoder.decode(json,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		jsonObj = new JSONObject(json);
		if(jsonObj.has("stock_id"))this.stock_id = jsonObj.getInt("stock_id");
		if(jsonObj.has("distributor_partner_id"))this.distributor_partner_id = jsonObj.getInt("distributor_partner_id");	
		if(jsonObj.has("distributor_name"))this.distributor_name = jsonObj.getString("distributor_name");
		if(jsonObj.has("product_id"))this.product_id = jsonObj.getInt("product_id");
		if(jsonObj.has("product_name"))this.product_name = jsonObj.getString("product_name");
		if(jsonObj.has("product_unit"))this.product_unit = jsonObj.getString("product_unit");
		if(jsonObj.has("product_quantity"))this.product_quantity = jsonObj.getInt("product_quantity");
		if(jsonObj.has("is_active"))this.is_active = jsonObj.getInt("is_active");
		
	}
	
}
