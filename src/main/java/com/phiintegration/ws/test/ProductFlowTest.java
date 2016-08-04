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

public class ProductFlowTest {

	String inputStart = "{\"id\":\"13\","
			+ "\"text\":\"registrasi produk\","
			+ "\"username\":\"rey\""
			+ "}";
	String inputExID = "{\"id\":\"13\","
			+ "\"text\":\"PPG456\","
			+ "\"username\":\"rey\""
			+ "}";
	String inputName = "{\"id\":\"13\","
			+ "\"text\":\"Papeda Goreng\","
			+ "\"username\":\"rey\""
			+ "}";
	String inputDescription = "{\"id\":\"13\","
			+ "\"text\":\"makanan daerah papua\","
			+ "\"username\":\"rey\""
			+ "}";
	String inputPrice = "{\"id\":\"13\","
			+ "\"text\":\"5000\","
			+ "\"username\":\"rey\""
			+ "}";
	String inputUnit = "{\"id\":\"13\","
			+ "\"text\":\"Tusuk\","
			+ "\"username\":\"rey\""
			+ "}";
	String inputHow = "{\"id\":\"13\","
			+ "\"text\":\"silahkan beli disini!\","
			+ "\"username\":\"rey\""
			+ "}";
	String inputConfirm = "{\"id\":\"13\","
			+ "\"text\":\"OK\","
			+ "\"username\":\"rey\""
			+ "}";
	
	@Test
	public void testProdukFlow1() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputStart);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Silahkan masukkan external id produk:(.*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testProdukFlow2() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputExID);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Silahkan masukkan Nama Produk:(.*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testProdukFlow3() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputName);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Silahkan masukkan Deskripsi Produk(.*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testProdukFlow4() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputDescription);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Silahkan masukkan Harga Produk(.*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testProdukFlow5() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputPrice);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Silahkan masukkan Satuan Produk(.*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testProdukFlow6() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputUnit);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Silahkan masukkan Cara Memesan Produk(.*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testProdukFlow7() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputHow);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Apakah produk sudah benar(.*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testProdukFlow8() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputConfirm);
			System.out.println(response);
			Pattern p = Pattern.compile("(.*)Produk Telah Berhasil Diregistrasi(.*)");
			Matcher m = p.matcher(response);
			boolean b = m.matches();
			assertEquals(true,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
