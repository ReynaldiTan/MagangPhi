package com.phiintegration.ws.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.json.JSONException;
import org.json.JSONObject;

public class trOrderDetail {
	private int row_id;
	private int order_id;
	private int line_id;
	private int product_id;
	private String product_name;
	private int quantity;
	private String units;
	private int discount_value;
	private int discount_percentage;
	private int price;
	private int total_price;
	
	
	public trOrderDetail(){
		
	}
	
	public trOrderDetail(int row_id, int order_id, int line_id, int product_id, String product_name, int quantity, String units,
			int discount_value, int discount_percentage, int price, int total_price) {
		this.row_id = row_id;
		this.order_id = order_id;
		this.line_id = line_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.quantity = quantity;
		this.units = units;
		this.discount_value = discount_value;
		this.discount_percentage = discount_percentage;
		this.price = price;
		this.total_price = total_price;
	}
	/**
	 * @return the row_id
	 */
	public int getRow_id() {
		return row_id;
	}
	/**
	 * @param row_id the row_id to set
	 */
	public void setRow_id(int row_id) {
		this.row_id = row_id;
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
	 * @return the line_id
	 */
	public int getLine_id() {
		return line_id;
	}
	/**
	 * @param line_id the lin_id to set
	 */
	public void setLine_id(int line_id) {
		this.line_id = line_id;
	}
	
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
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the units
	 */
	public String getUnits() {
		return units;
	}
	/**
	 * @param units the units to set
	 */
	public void setUnits(String units) {
		this.units = units;
	}
	/**
	 * @return the discount_value
	 */
	public int getDiscount_value() {
		return discount_value;
	}
	/**
	 * @param discount_value the discount_value to set
	 */
	public void setDiscount_value(int discount_value) {
		this.discount_value = discount_value;
	}
	/**
	 * @return the discount_percentage
	 */
	public int getDiscount_percentage() {
		return discount_percentage;
	}
	/**
	 * @param discount_percentage the discount_percentage to set
	 */
	public void setDiscount_percentage(int discount_percentage) {
		this.discount_percentage = discount_percentage;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the total_price
	 */
	public int getTotal_price() {
		return total_price;
	}
	/**
	 * @param total_price the total_price to set
	 */
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	
	public void jsonParse(String json) throws JSONException{		
		JSONObject jsonObj;
		try {
			json = URLDecoder.decode(json,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		jsonObj = new JSONObject(json);
		if(jsonObj.has("row_id"))this.row_id = jsonObj.getInt("row_id");
		if(jsonObj.has("order_id"))this.order_id = jsonObj.getInt("order_id");
		if(jsonObj.has("line_id"))this.line_id = jsonObj.getInt("line_id");	
		if(jsonObj.has("product_id"))this.product_id = jsonObj.getInt("product_id");
		if(jsonObj.has("product_name"))this.product_name = jsonObj.getString("product_name");	
		if(jsonObj.has("quantity"))this.quantity = jsonObj.getInt("quantity");	
		if(jsonObj.has("units"))this.units = jsonObj.getString("units");	
		if(jsonObj.has("discount_value"))this.discount_value = jsonObj.getInt("discount_value");
		if(jsonObj.has("discount_percentage"))this.discount_percentage = jsonObj.getInt("discount_percentage");
		if(jsonObj.has("price"))this.price = jsonObj.getInt("price");
		if(jsonObj.has("total_price"))this.total_price = jsonObj.getInt("total_price");

	}
}
