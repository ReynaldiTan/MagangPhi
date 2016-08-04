//package com.phiintegration.ws.test;
//
//import static org.junit.Assert.assertEquals;
//
//import java.sql.SQLException;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import org.junit.Test;
//
//import com.phiintegration.ws.controller.ProductRegistration;
//import com.phiintegration.ws.model.DBCon;
//import com.phiintegration.ws.model.msProduct;
//
//public class ProductTest {
//	DBCon db;
//	@Test
//	public void test1() throws SQLException {
//		msProduct p = new msProduct();
//		p.setPartner_seller_id(1);
//		p.setProduct_external_id("KR-001");
//		p.setProduct_name("Coca-cola");
//		p.setProduct_description("Minuman segar berkarbonisasi");
//		p.setProduct_price(5000);
//		p.setProduct_unit("2");
//		p.setActive(1);
//		p.setHow_to_order("Pesan ke bapak Dana");
//		
//		ProductRegistration o = new ProductRegistration();
//		int id = o.addProduct(p);
//		Pattern pa = Pattern.compile("[0-9]+");//. represents single character.
//		Matcher m = pa.matcher(Integer.toString(id));
//		boolean b = m.matches();
//		assertEquals(b, true);			
//		
//	}
//	
//	@Test
//	public void test2() throws SQLException {
//		msProduct p = new msProduct();
//		p.setPartner_seller_id(3);
//		p.setProduct_external_id("KR-001");
//		p.setProduct_name("Coca-cola");
//		p.setProduct_description("Minuman segar berkarbonisasi");
//		p.setProduct_price(5000);
//		p.setProduct_unit("2");
//		p.setActive(1);
//		p.setHow_to_order("Pesan ke bapak Dana");
//		
//		ProductRegistration o = new ProductRegistration();
//		int id = o.addProduct(p);
//		assertEquals(id, -1);			
//		
//	}
//	@Test
//	public void test3() throws SQLException {
//		
//		ProductRegistration o = new ProductRegistration();
//		msProduct p = o.getProduct(1);
//		boolean b = o.inactivateProduct(p);
//		assertEquals(b, true);	
//	}
//
//	@Test
//	public void test4() throws SQLException {
//		
//		ProductRegistration o = new ProductRegistration();
//		msProduct p = o.getProduct(1);
//		boolean b = o.activateProduct(p);
//		assertEquals(b, true);	
//	}
//	@Test
//	public void test5() throws SQLException {
//		
//		ProductRegistration o = new ProductRegistration();
//		msProduct p = o.getProduct(1);
//		p.setProduct_name("Fanta");
//		boolean b = o.updateProduct(p);
//		assertEquals(b, true);	
//	}
//}
