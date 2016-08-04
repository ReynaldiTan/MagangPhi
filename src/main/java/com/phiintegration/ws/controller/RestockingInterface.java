package com.phiintegration.ws.controller;

import java.util.ArrayList;
import java.util.Date;

import com.phiintegration.ws.model.NameQuantity;
import com.phiintegration.ws.model.msProduct;
import com.phiintegration.ws.model.msStock;
import com.phiintegration.ws.model.msUserState;
import com.phiintegration.ws.model.trRestock;

public interface RestockingInterface {

	int addStock(msStock objStock);

	boolean updateStock(msStock objStock);

	boolean deleteStock(msStock objStock);

	int checkStock(msProduct objProduct, Date dateCheck);

	int newRestock(trRestock objRestock);

	boolean updateRestock(trRestock objRestock);

	boolean deleteRestock(trRestock objRestock);
	
	ArrayList<NameQuantity> getRestockList(String user);

	trRestock getRestockInfo(int id);
		
	boolean updateRecieve(trRestock objRestock);
	
	boolean reciveIDValid(int id);
		
}