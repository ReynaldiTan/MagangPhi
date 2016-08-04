package com.phiintegration.ws.model;

public class msProductImages {
	private int image_id;
	private String image_external_id;
	private String product_id;
	private String image_path;
	private int dimension_width;
	private int dimension_height;
	int getImage_id() {
		return image_id;
	}
	void setImage_id(int image_id) {
		this.image_id = image_id;
	}
	String getImage_external_id() {
		return image_external_id;
	}
	void setImage_external_id(String image_external_id) {
		this.image_external_id = image_external_id;
	}
	String getProduct_id() {
		return product_id;
	}
	void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	String getImage_path() {
		return image_path;
	}
	void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	int getDimension_width() {
		return dimension_width;
	}
	void setDimension_width(int dimension_width) {
		this.dimension_width = dimension_width;
	}
	int getDimension_height() {
		return dimension_height;
	}
	void setDimension_height(int dimension_height) {
		this.dimension_height = dimension_height;
	}
}
