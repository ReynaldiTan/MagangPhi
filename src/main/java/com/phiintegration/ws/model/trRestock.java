package com.phiintegration.ws.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.json.JSONException;
import org.json.JSONObject;

public class trRestock {
	private int restock_id;
	private String restock_date;
	private String receive_date;
	private int distributor_partner_id;
	private String distributor_name;
	private int product_id;
	private String product_name;
	private String product_unit;
	private int product_quantity;
	
	public int getRestock_id() {
		return restock_id;
	}
	public void setRestock_id(int restock_id) {
		this.restock_id = restock_id;
	}
	public String getRestock_date() {
		return restock_date;
	}
	public void setRestock_date(String restock_date) {
		this.restock_date = restock_date;
	}
	public String getReceive_date() {
		return receive_date;
	}
	public void setReceive_date(String receive_date) {
		this.receive_date = receive_date;
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
	public void jsonParse(String Json) throws JSONException{
		try {
			Json = URLDecoder.decode(Json,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		JSONObject obj = new JSONObject(Json);
		if(obj.has("restock_id")) this.setRestock_id(obj.getInt("restock_id"));
		if(obj.has("restock_date")) this.setRestock_date(obj.getString("restock_date"));
		if(obj.has("receive_date")) this.setReceive_date(obj.getString("receive_date"));
		if(obj.has("distributor_partner_id")) this.setDistributor_partner_id(obj.getInt("distributor_partner_id"));
		if(obj.has("distributor_name")) this.setDistributor_name(obj.getString("distributor_name"));
		if(obj.has("product_id")) this.setProduct_id(obj.getInt("product_id"));
		if(obj.has("product_name")) this.setProduct_name(obj.getString("product_name"));
		if(obj.has("product_unit")) this.setProduct_unit(obj.getString("product_unit"));
		if(obj.has("product_quantity")) this.setProduct_quantity(obj.getInt("product_quantity"));	
	
	}
	
}
