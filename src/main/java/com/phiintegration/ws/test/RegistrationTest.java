//package com.phiintegration.ws.test;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import org.json.JSONException;
//import org.junit.Test;
//
//import com.phiintegration.ws.controller.RegistrationInterface;
////import com.phiintegration.ws.controller.RegistrationMongoDB;
//import com.phiintegration.ws.controller.RegistrationSQLServer;
//
//
//public class RegistrationTest {
//	String inputAwal = "{\"name\":\"Feris\",\"email\":\"feris@phi-integration.com\",\"phone\":\"+6281296595535\",\"phone_type\":\"mobile\"}";
//	String inputBaru = "{\"name\":\"Dana\",\"email\":\"dana@phi-integration.com\",\"phone\":\"+6281296595535\",\"phone_type\":\"mobile\"}";
//
//	@Test
//	public void testRegistration1() throws JSONException
//	{
//		RegistrationInterface obj = new RegistrationSQLServer();
//		
//		String hasil = obj.registerPartner(inputAwal);
//		//System.out.println(hasil);
//		//assertEquals("\\{ id:\\d+, result: true\\}", hasil);
//		Pattern p = Pattern.compile("\\s+\\{ id\\:[0-9]+, result\\: true\\}");//. represents single character.
//		Matcher m = p.matcher(hasil);
//		boolean b = m.matches();
//		assertEquals(b, true);			
//	}
//	
//	@Test
//	public void testRegistration2() throws JSONException
//	{
//		RegistrationInterface obj = new RegistrationSQLServer();
//		
//		String hasil = obj.registerPartner(inputAwal);
//		assertEquals(hasil, " { error_code: 101, result: false, description: 'Email already registered' }");			
//	}
//	
//	@Test
//	public void testRegistration3() throws JSONException
//	{
//		RegistrationInterface obj = new RegistrationSQLServer();
//		
//		String hasil = obj.registerPartner(inputBaru);
//		//assertEquals("\\{ id:\\d+, result: true\\}", hasil);
//		Pattern p = Pattern.compile("\\s+\\{ id\\:[0-9]+, result\\: true\\}");//. represents single character.
//		Matcher m = p.matcher(hasil);
//		boolean b = m.matches();
//		assertEquals(b, true);			
//	}	
//	
//	public static void main(String[] args) throws JSONException {
//		String input1 = "{"
//				+ "\"partner_name\":\"Dana\","
//				+ "\"email_address\":\"dana@phi-integration.com\","
//				+ "\"phone_number\":\"+6281296595535\","
//				+ "\"phone_type\":\"mobile\","
//				+ "\"partner_external_id\":\"K001\","
//				+ "\"partner_alias\":\"Pratama\","
//				+ "\"partner_logo\":\"asadsasdas\","
//				+ "\"is_active\":1,"
//
//				+ "\"partner_id\":\"123\","
//				+ "\"email_type\":\"google\","
//				+ "\"is_primary_email_address\":false,"
//				+ "\"phone_extension\":\"012\","
//				+ "\"phone_country_code\":\"+62\","
//				+ "\"phone_area_code\":\"+62\","
//				+ "\"phone_description\":\"+62\","
//				+ "\"is_primary_phone\":true,"
//				+ "\"location_address1\":\"asdadasdsafaf\","
//				+ "\"location_address2\":\"adssasadsadf\","
//				+ "\"location_geographic_lat\":\"123123\","
//				+ "\"location_geographic_long\":\"1232132\","
//				+ "\"is_validated\":0,"
//				+ "\"is_primary\":1"
//				
//				+ "}";
//		RegistrationInterface obj = new RegistrationSQLServer();
//		
//		String hasil = "Partner: " + obj.registerPartner(input1);
//		hasil += "Email: " + obj.addEmail(input1);
//		hasil += "Phone: " + obj.addPhone(input1);
//		hasil += "Location: " + obj.addGeographicLocation(input1);
//		//assertEquals(" { id:1, result: true}", hasil);		
//		
//		System.out.println(hasil);		
//	}
//}
