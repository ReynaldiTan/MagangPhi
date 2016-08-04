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

public class PartnerFlowTest {

	String inputStart = "{\"id\":\"16\","
			+ "\"text\":\"registrasi partner\","
			+ "\"username\":\"rey4\""
			+ "}";
	String inputNama = "{\"id\":\"16\","
			+ "\"text\":\"realFix\","
			+ "\"username\":\"rey4\""
			+ "}";
	String inputAlamat = "{\"id\":\"16\","
			+ "\"text\":\"jl jalan blok b no 12133\","
			+ "\"username\":\"rey4\""
			+ "}";
	String inputEmail = "{\"id\":\"16\","
			+ "\"text\":\"naldie.chen@gmail.com\","
			+ "\"username\":\"rey4\""
			+ "}";
	String inputNoHP = "{\"id\":\"16\","
			+ "\"text\":\"0899993899918\","
			+ "\"username\":\"rey4\""
			+ "}";
	
	@Test
	public void testPartnerFlow1() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputStart);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Silahkan masukkan Nama(.*)");
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
			response = temp.checkInput(inputNama);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Silahkan masukkan Alamat(.*)");
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
			response = temp.checkInput(inputAlamat);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Silahkan masukkan Email(.*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPartnerFlow4() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputEmail);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Silahkan masukkan Phone(.*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPartnerFlow5() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputNoHP);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Silahkan cek email konfirmasi(.*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
