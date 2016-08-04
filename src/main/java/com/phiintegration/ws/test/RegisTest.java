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

public class RegisTest {

	String inputStart = "{\"user_ID\":\"1\","
			+ "\"messageInput\":\"Registration\","
			+ "}";
	String inputHeader = "{\"user_ID\":\"1\","
			+ "\"messageInput\":\"#lasda\","
			+ "\"partner_name\":\"Arief\","
			+ "\"partner_logo\":\"null\","
			+ "\"partner_alias\":\"Kim Jong Un\","
			+ "\"partner_external_id\":\"32\","
			+ "\"is_active\":\"1\","
			+ "\"email_id\":\"Alola\","
			+ "\"email_type\":\"General\","
			+ "\"email_address\":\"arifuradana@gmail.com\","
			+ "\"phone_type\":\"Handphone\","
			+ "\"phone_number\":\"084993322559\","
			+ "\"phone_extension\":\"1553\","
			+ "\"phone_country_code\":\"+62\","
			+ "\"phone_area_code\":\"21\","
			+ "\"phone_description\":\"telepone president North Korea\","
			+ "\"is_primary_phone\":\"1\","
			+ "\"location_address1\":\"North Korea\","
			+ "\"location_geographic_lat\":\"-7.325\","
			+ "\"location_geographic_long\":\"239.12342\","
			+ "\"is_validated\":\"1\","
			+ "\"is_primary\":\"1\","
			+ "\"confirmed\":\"0\""
			+ "}";

	
	@Test
	public void testOrderFlow1() throws JSONException
	{
		InputCheck temp = new InputCheck();
		String response ="";
		try {
			response = temp.checkInput(inputStart);
			assertEquals("{message:\"Halo mau pesan dari toko apa ?\" }",response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
