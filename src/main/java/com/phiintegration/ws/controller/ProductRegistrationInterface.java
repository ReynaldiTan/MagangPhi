package com.phiintegration.ws.controller;

import java.util.ArrayList;

import com.phiintegration.ws.model.msProduct;

public interface ProductRegistrationInterface {

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.model.OrderingInterface#addProduct(com.phiintegration.ws.model.ms_product)
	 */
	int addProduct(msProduct p);

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.model.OrderingInterface#updateProduct(com.phiintegration.ws.model.ms_product)
	 */
	boolean updateProduct(msProduct p);

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.model.OrderingInterface#inactivateProduct(com.phiintegration.ws.model.ms_product)
	 */
	boolean inactivateProduct(msProduct p);

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.model.OrderingInterface#activateProduct(com.phiintegration.ws.model.ms_product)
	 */
	boolean activateProduct(msProduct p);

	msProduct getProduct(int id, int partnerID);
	
	msProduct getProductInactived(int id, int partnerID);
	
	ArrayList<String> getProducts(int i);
	
	ArrayList<String> getProductsInactivate(int i);
	
	ArrayList<String> getProductsActive(int i);
	
	msProduct getProductByName(String name, int partnerID);
	
	msProduct getProductByNameIncativate(String name, int partnerID);

}