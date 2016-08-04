package com.phiintegration.ws.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.json.JSONException;
import org.json.JSONObject;

public class trOrderHeader {
	private int order_id;
	private String order_number;
	private String order_date;
	private int partner_id_seller;
	private int partner_id_customer;
	private String seller_name;
	private String customer_name;
	private String session_id;
	private String total_discount;
	private String total_value;
	private int confirmed;
	
	public trOrderHeader() {
		// TODO Auto-generated constructor stub
	}

	public trOrderHeader(int order_id, String order_number, String order_date, int partner_id_seller,
			int partner_id_customer, String seller_name, String customer_name, String session_id, String total_discount,
			String total_value, int confirmed) {
		this.order_id = order_id;
		this.order_number = order_number;
		this.order_date = order_date;
		this.partner_id_seller = partner_id_seller;
		this.partner_id_customer = partner_id_customer;
		this.seller_name = seller_name;
		this.customer_name = customer_name;
		this.session_id = session_id;
		this.total_discount = total_discount;
		this.total_value = total_value;
		this.confirmed = confirmed;
	}
	
	/**
	 * @return the order_id
	 */
	public int getOrder_id() {
		return order_id;
	}
	/**
	 * @param order_id the order_id to set
	 */
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	/**
	 * @return the order_number
	 */
	public String getOrder_number() {
		return order_number;
	}
	/**
	 * @param order_number the order_number to set
	 */
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	/**
	 * @return the order_date
	 */
	public String getOrder_date() {
		return order_date;
	}
	/**
	 * @param order_date the order_date to set
	 */
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	/**
	 * @return the partner_id_seller
	 */
	public int getPartner_id_seller() {
		return partner_id_seller;
	}
	/**
	 * @param partner_id_seller the partner_id_seller to set
	 */
	public void setPartner_id_seller(int partner_id_seller) {
		this.partner_id_seller = partner_id_seller;
	}
	/**
	 * @return the partner_id_customer
	 */
	public int getPartner_id_customer() {
		return partner_id_customer;
	}
	/**
	 * @param partner_id_customer the partner_id_customer to set
	 */
	public void setPartner_id_customer(int partner_id_customer) {
		this.partner_id_customer = partner_id_customer;
	}
	/**
	 * @return the seller_name
	 */
	public String getSeller_name() {
		return seller_name;
	}
	/**
	 * @param seller_name the seller_name to set
	 */
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	/**
	 * @return the customer_name
	 */
	public String getCustomer_name() {
		return customer_name;
	}
	/**
	 * @param customer_name the customer_name to set
	 */
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	/**
	 * @return the session_id
	 */
	public String getSession_id() {
		return session_id;
	}
	/**
	 * @param session_id the session_id to set
	 */
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}
	/**
	 * @return the total_discount
	 */
	public String getTotal_discount() {
		return total_discount;
	}
	/**
	 * @param total_discount the total_discount to set
	 */
	public void setTotal_discount(String total_discount) {
		this.total_discount = total_discount;
	}
	/**
	 * @return the total_value
	 */
	public String getTotal_value() {
		return total_value;
	}
	/**
	 * @param total_value the total_value to set
	 */
	public void setTotal_value(String total_value) {
		this.total_value = total_value;
	}
	/**
	 * @return the is_confirmed
	 */
	public int isConfirmed() {
		return confirmed;
	}
	/**
	 * @param is_confirmed the is_confirmed to set
	 */
	public void setConfirmed(int is_confirmed) {
		this.confirmed = is_confirmed;
	}
	
	public void jsonParse(String json) throws JSONException{		
		JSONObject jsonObj;
		try {
			json = URLDecoder.decode(json,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		jsonObj = new JSONObject(json);
		if(jsonObj.has("order_id"))this.order_id = jsonObj.getInt("order_id");		
		if(jsonObj.has("order_number"))this.order_number = jsonObj.getString("order_number");
		if(jsonObj.has("order_date"))this.order_date = jsonObj.getString("order_date");
		if(jsonObj.has("partner_id_seller"))this.partner_id_seller = jsonObj.getInt("partner_id_seller");
		if(jsonObj.has("partner_id_customer"))this.partner_id_customer = jsonObj.getInt("partner_id_customer");
		if(jsonObj.has("seller_name"))this.seller_name = jsonObj.getString("seller_name");
		if(jsonObj.has("customer_name"))this.customer_name = jsonObj.getString("customer_name");
		if(jsonObj.has("session_id"))this.session_id = jsonObj.getString("session_id");
		if(jsonObj.has("total_discount"))this.total_discount = jsonObj.getString("total_discount");
		if(jsonObj.has("total_value"))this.total_value = jsonObj.getString("total_value");
		if(jsonObj.has("confirmed"))this.confirmed = jsonObj.getInt("confirmed");
	}
}
