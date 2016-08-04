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

public class RecieveFlowTest {

	String inputStart = "{\"id\":\"13\","
			+ "\"text\":\"recieve\","
			+ "\"username\":\"rey\""
			+ "}";
	String inputID = "{\"id\":\"13\","
			+ "\"text\":\"5\","
			+ "\"username\":\"rey\""
			+ "}";
	String inputDate = "{\"id\":\"1\","
			+ "\"text\":\"2016-12-12\","
			+ "\"username\":\"rey\""
			+ "}";
	
	@Test
	public void testPartnerFlow1() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputStart);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)List Restock((.|\n)*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPartnerFlow2() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputID);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Silahkan masukkan tanggal penerimaan barang((.|\n)*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testPartnerFlow3() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputDate);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Recieve Date Updated(.*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
