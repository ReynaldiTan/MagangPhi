package com.phi.controller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phiintegration.ws.controller.InputCheck;


@Controller
public class InputCheckService {
	
	@RequestMapping(value = "/inputcheck", method= RequestMethod.POST)
	public @ResponseBody String inputCheck(@RequestBody String data) {
		
		JSONObject info = new JSONObject();
		try {
			File file = new File("C:\\Users\\arief pradana\\workspace\\test1Dump.txt");
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(data);
			fileWriter.flush();
			fileWriter.close();

			//InputCheck ci = new InputCheck();
			//info.put("message", ci.checkInput(data));
			info.put("message", "hmmm");
		} catch (IOException e) {
		      e.printStackTrace();
		}catch(JSONException e){
			try {
				info.put("error_code", 101);
				info.put("result", false);
				info.put("description", "JSON Error");
				return info.toString();
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
//		catch(SQLException e){
//			try {
//				info.put("error_code", 102);
//				info.put("result", false);
//				info.put("description", "SQL Error");
//				return info.toString();
//			} catch (JSONException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
		return info.toString();
	}
}
