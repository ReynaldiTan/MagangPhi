package com.phiintegration.ws.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.json.JSONException;
import org.json.JSONObject;

public class msProduct {
	private int product_id;
	private int partner_seller_id;
	private String  product_external_id;
	private String product_name;
	private String product_description;
	private int product_price;
	private String product_unit;
	private int active;
	private String how_to_order;
	/**
	 * @return the product_id
	 */
	public int getProduct_id() {
		return product_id;
	}
	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	/**
	 * @return the partner_seller_id
	 */
	public int getPartner_seller_id() {
		return partner_seller_id;
	}
	/**
	 * @param partner_seller_id the partner_seller_id to set
	 */
	public void setPartner_seller_id(int partner_seller_id) {
		this.partner_seller_id = partner_seller_id;
	}
	/**
	 * @return the product_external_id
	 */
	public String getProduct_external_id() {
		return product_external_id;
	}
	/**
	 * @param product_external_id the product_external_id to set
	 */
	public void setProduct_external_id(String product_external_id) {
		this.product_external_id = product_external_id;
	}
	/**
	 * @return the product_name
	 */
	public String getProduct_name() {
		return product_name;
	}
	/**
	 * @param product_name the product_name to set
	 */
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	/**
	 * @return the product_description
	 */
	public String getProduct_description() {
		return product_description;
	}
	/**
	 * @param product_description the product_description to set
	 */
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	/**
	 * @return the product_price
	 */
	public int getProduct_price() {
		return product_price;
	}
	/**
	 * @param product_price the product_price to set
	 */
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	/**
	 * @return the product_unit
	 */
	public String getProduct_unit() {
		return product_unit;
	}
	/**
	 * @param product_unit the product_unit to set
	 */
	public void setProduct_unit(String product_unit) {
		this.product_unit = product_unit;
	}
	/**
	 * @return the is_active
	 */
	public int isActive() {
		return active;
	}
	/**
	 * @param is_active the is_active to set
	 */
	public void setActive(int is_active) {
		this.active = is_active;
	}
	/**
	 * @return the how_to_order
	 */
	public String getHow_to_order() {
		return how_to_order;
	}
	/**
	 * @param how_to_order the how_to_order to set
	 */
	public void setHow_to_order(String how_to_order) {
		this.how_to_order = how_to_order;
	}
	
	
	public void jsonParse(String Json) throws JSONException{
			try {
				Json = URLDecoder.decode(Json,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}	
			JSONObject obj = new JSONObject(Json);
			if(obj.has("product_id")) this.setProduct_id(obj.getInt("product_id"));
			if(obj.has("partner_seller_id")) this.setPartner_seller_id(obj.getInt("partner_seller_id"));
			if(obj.has("product_external_id")) this.setProduct_external_id(obj.getString("product_external_id"));
			if(obj.has("product_name")) this.setProduct_name(obj.getString("product_name"));
			if(obj.has("product_description")) this.setProduct_description(obj.getString("product_description"));
			if(obj.has("product_price")) this.setProduct_price(obj.getInt("product_price"));
			if(obj.has("product_unit")) this.setProduct_unit(obj.getString("product_unit"));
			if(obj.has("active")) this.setActive(obj.getInt("active"));
			if(obj.has("how_to_order")) this.setHow_to_order(obj.getString("how_to_order"));
	}
}
