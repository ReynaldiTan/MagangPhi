package com.phiintegration.ws.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.phiintegration.ws.controller.RestockingInterface;
import com.phiintegration.ws.controller.RestockingSQLServer;
import com.phiintegration.ws.model.msProduct;
import com.phiintegration.ws.model.msStock;

public class StockTest {
 int stock_id=0;
	@Test
	public void testAdd() {
		RestockingInterface stock;
		try {
			stock = new RestockingSQLServer();
		
			msStock objStock = new msStock();
			
			objStock.setProduct_id(1);
			objStock.setProduct_name("coca-cola");
			objStock.setDistributor_partner_id(1);
			objStock.setProduct_unit("buah");
			objStock.setProduct_quantity(100);
			objStock.setDistributor_name("Dana");
			objStock.setIs_active(0);
			
			
			int hasil = stock.addStock(objStock);
			Pattern pa = Pattern.compile("[0-9]+");//. represents single character.
			Matcher m = pa.matcher(Integer.toString(hasil));
			boolean b = m.matches();
			assertEquals(b, true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() throws SQLException {
		RestockingInterface stock = new RestockingSQLServer();
		msStock objStock = new msStock();
		
		objStock.setStock_id(1);
		objStock.setDistributor_name("Dana Pratama");
		objStock.setIs_active(1);
		
		boolean hasil=stock.updateStock(objStock);
		assertEquals(hasil, true);
		

	}
	public static void main(String[] args) throws ParseException, SQLException {
		RestockingInterface stock = new RestockingSQLServer();
		msProduct objproduct = new msProduct();
		DateFormat formater;
		formater=new SimpleDateFormat("yyyy-MM-dd");
		Date dateCheck= formater.parse("2016-06-28");
		objproduct.setPartner_seller_id(1);
		objproduct.setProduct_id(1);		
		
		System.out.println(stock.checkStock(objproduct, dateCheck));
		
	}
	@Test
	public void testDelete() throws SQLException {
		RestockingInterface stock = new RestockingSQLServer();
		msStock objStock = new msStock();
		
		objStock.setStock_id(1);
				
		boolean hasil=stock.deleteStock(objStock);
		assertEquals(hasil, true);

	}
}
