package com.phiintegration.ws.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.junit.Test;

import com.phiintegration.ws.controller.InputCheck;

public class RestockFlowTest {
	String inputStart = "{\"id\":\"13\","
			+ "\"text\":\"restock\","
			+ "\"username\":\"rey\""
			+ "}";
	String inputDistributionFlow = "{\"id\":\"13\","
			+ "\"text\":\"Coke\","
			+ "\"username\":\"rey\""
			+ "}";
	String inputQuantitiyFlow = "{\"id\":\"13\","
			+ "\"text\":\"20\","
			+ "\"username\":\"rey\""
			+ "}";
	String inputDoneFlow = "{\"id\":\"13\","
			+ "\"text\":\"yes\","
			+ "\"username\":\"rey\""
			+ "}";
	@Test
	public void testRestockFlow1() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputStart);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)List((.|\n)*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testRestockFlow2() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputDistributionFlow);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Masukan jumlah yang diinginkan(.*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testRestockFlow3() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputQuantitiyFlow);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Apakah sudah benar?(.*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Test
	public void testRestockFlow4() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputDoneFlow);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)confirm(.*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
