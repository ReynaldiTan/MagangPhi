package com.phiintegration.ws.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.junit.Test;

import com.phiintegration.ws.controller.InputCheck;

public class ActivateFlowTest {

		String inputStart = "{\"id\":\"13\","
				+ "\"text\":\"activate\","
				+ "\"username\":\"rey\""
				+ "}";
		String inputDistributionFlow = "{\"id\":\"13\","
				+ "\"text\":\"bakmi bakar\","
				+ "\"username\":\"rey\""
				+ "}";
		String inputQuantitiyFlow = "{\"id\":\"13\","
				+ "\"text\":\"OK\","
				+ "\"username\":\"rey\""
				+ "}";
		
		@Test
		public void testActivateFlow1() throws JSONException
		{
			InputCheck temp = new InputCheck();
			String response ="";
			try {
				response = temp.checkInput(inputStart);
				System.out.println(response);
				Pattern p = Pattern.compile("(.*)berikut adalah list produk yang tidak aktif((.|\n)*)");
				Matcher m = p.matcher(response);
				boolean b = m.matches();
				
				assertEquals(true,b);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Test
		public void testActivateFlow2() throws JSONException
		{
			InputCheck temp = new InputCheck();
			String response ="";
			try {
				response = temp.checkInput(inputDistributionFlow);
				System.out.println(response);
				Pattern p = Pattern.compile("(.*)Masukan nama produk yang ingin di aktifkan(.*)");
				Matcher m = p.matcher(response);
				boolean b = m.matches();
				
				assertEquals(true,b);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Test
		public void testActivateFlow3() throws JSONException
		{
			InputCheck temp = new InputCheck();
			String response ="";
			try {
				response = temp.checkInput(inputQuantitiyFlow);
				System.out.println(response);
				Pattern p = Pattern.compile("(.*)Produk Telah Berhasil di aktifasi!(.*)");
				Matcher m = p.matcher(response);
				boolean b = m.matches();
				
				assertEquals(true,b);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
