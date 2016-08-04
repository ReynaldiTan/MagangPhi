package com.phiintegration.ws.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.junit.Test;

import com.phiintegration.ws.controller.InputCheck;
import com.phiintegration.ws.controller.RegistrationInterface;
import com.phiintegration.ws.controller.RegistrationSQLServer;

public class OrderFlowTest {

	String inputStart = "{\"id\":\"13\","
			+ "\"text\":\"order\","
			+ "\"username\":\"rey\""
			+ "}";
	String inputHeader = "{\"id\":\"13\","
			+ "\"text\":\"rey\","
			+ "\"username\":\"rey\""
			+ "}";
	String inputName = "{\"id\":\"13\","
			+ "\"text\":\"cing cong fan Goreng\","
			+ "\"username\":\"rey\""
			+ "}";
	String inputQuantity = "{\"id\":\"13\","
			+ "\"text\":\"1\","
			+ "\"username\":\"rey\""
			+ "}";
	String inputYa = "{\"id\":\"13\","
			+ "\"text\":\"no\","
			+ "\"username\":\"rey\""
			+ "}";
	String inputConfirm = "{\"id\":\"13\","
			+ "\"text\":\"confirm\","
			+ "\"username\":\"rey\""
			+ "}";
	
	@Test
	public void testOrderFlow1() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputStart);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Silahkan pilih toko dari list berikut:((.|\n)*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOrderFlow2() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputHeader);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)List produk:((.|\n)*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testOrderFlow3() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputName);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Berapa jumlah yang diinginkan?(.*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOrderFlow4() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputQuantity);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Ada pesanan yang lain?(.*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOrderFlow5() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputYa);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Apakah pesanan anda sudah betul(.*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOrderFlow6() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputConfirm);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Anda telah berhasil memesan(.*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
