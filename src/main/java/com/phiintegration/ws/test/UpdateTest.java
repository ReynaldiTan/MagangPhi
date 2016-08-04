package com.phiintegration.ws.test;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.junit.Test;

import com.phiintegration.ws.controller.RegistrationInterface;
import com.phiintegration.ws.controller.RegistrationSQLServer;

public class UpdateTest {
	//String inputAwal = "{\"name\":\"Feris\",\"email\":\"feris@phi-integration.com\",\"phone\":\"+6281296595535\",\"phone_type\":\"mobile\"}";
	//String inputBaru = "{\"name\":\"Dana\",\"email\":\"dana@phi-integration.com\",\"phone\":\"+6281296595535\",\"phone_type\":\"mobile\"}";
	String emailBaru="{\"email_id\":\"1\",\"Partner_id\":\"1\",\"email\":\"feris@phi-integration.com\",\"email_type\":\"Other Email\",\"is_primary\":\"false\"}";
	@Test
	public void updatePartner() throws JSONException {
		RegistrationInterface obj = new RegistrationSQLServer();
		
		/*//String hasil = obj.updateEmail(emailBaru);
		//System.out.println(hasil);
		//assertEquals("\\{ id:\\d+, result: true\\}", hasil);
		Pattern p = Pattern.compile("\\s+\\{ id\\:[0-9]+, result\\: true\\}");//. represents single character.
		Matcher m = p.matcher(hasil);
		boolean b = m.matches();
		assertEquals(b, true);	*/	
	}

}
