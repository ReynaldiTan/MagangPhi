package com.phiintegration.ws.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.phiintegration.ws.controller.OrderingInterface;
import com.phiintegration.ws.controller.OrderingSQLServer;

import com.phiintegration.ws.model.*;


public class OrderingTest {
	trOrderHeader oh = new trOrderHeader(0, "o3o", "2015-12-31", 1, 2,"o3o" ,"o3o", "o3o", "o3o","o3o", 0);
	trOrderHeader oh2 = new trOrderHeader(2, "o3o2", "2014-12-31", 1, 2,"o3o1" ,"o3o", "o3o", "o3o1","o3o", 0);
	trOrderDetail od = new trOrderDetail(1, 1, 1, 1, "o3o", 0, "o3o", 0, 0, 0, 0);
	trOrderDetail od2 = new trOrderDetail(1, 2, 1, 1, "o32o2", 0, "o3o", 0, 0, 0, 0);
	
//	@Test
//	public void testOrder0()
//	{
//		OrderingInterface obj;
//		try {
//			obj = new Ordering();
//			boolean kembalian = obj.closeOrder(oh2);
//			assertEquals(kembalian, true);	
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void testOrder1()
	{
		OrderingInterface obj;
		try {
			obj = new OrderingSQLServer();
			int kembalian = obj.newOrderHeader(oh);
			Pattern p = Pattern.compile("[0-9]+");
			Matcher m = p.matcher(""+kembalian);
			boolean b = m.matches();
			assertEquals(b, true);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOrder2()
	{
		OrderingInterface obj;
		try {
			obj = new OrderingSQLServer();
			boolean kembalian = obj.updateOrderHeader(oh2);
			assertEquals(kembalian, true);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOrder3()
	{
		OrderingInterface obj;
		try {
			obj = new OrderingSQLServer();
			int kembalian = obj.addOrderDetail(od);
			Pattern p = Pattern.compile("[0-9]+");
			Matcher m = p.matcher(""+kembalian);
			boolean b = m.matches();
			assertEquals(b, true);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOrder4()
	{
		OrderingInterface obj;
		try {
			obj = new OrderingSQLServer();
			boolean kembalian = obj.updateOrderDetail(od2);
			assertEquals(kembalian, true);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
