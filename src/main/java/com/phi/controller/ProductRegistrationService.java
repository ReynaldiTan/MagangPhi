package com.phi.controller;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phiintegration.ws.controller.ProductRegistration;
import com.phiintegration.ws.controller.ProductRegistrationInterface;
import com.phiintegration.ws.model.msProduct;

@Controller
public class ProductRegistrationService {
		
	@RequestMapping(value = "/addProduct", method= RequestMethod.POST)
	public @ResponseBody String inputProduct(@RequestBody String Json){
		
		msProduct p = new msProduct();
		JSONObject info = new JSONObject();
		try{
			ProductRegistrationInterface regis = new ProductRegistration();
			p.jsonParse(Json);
			info.put("id", regis.addProduct(p));
			info.put("result", true);
		}
		catch(JSONException e){
			try {
				info.put("error_code", 101);
				info.put("result", false);
				info.put("description", "JSON Error");
				return info.toString();
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		catch(SQLException e){
			try {
				info.put("error_code", 102);
				info.put("result", false);
				info.put("description", "SQL Error");
				return info.toString();
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		
		return info.toString();
	}
	
	@RequestMapping(value="/updateProduct", method= RequestMethod.POST)
	public @ResponseBody String updateProduct(@RequestBody String Json){
		msProduct p = new msProduct();
		JSONObject info = new JSONObject();
		try{
			ProductRegistrationInterface regis = new ProductRegistration();
			p.jsonParse(Json);
			info.put("result", regis.updateProduct(p));
		}
		catch(JSONException e){
			try {
				info.put("error_code", 101);
				info.put("result", false);
				info.put("description", "JSON Error");
				return info.toString();
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		catch(SQLException e){
			try {
				info.put("error_code", 102);
				info.put("result", false);
				info.put("description", "SQL Error");
				return info.toString();
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return info.toString();
	}
	
	@RequestMapping(value = "/activateProduct", method= RequestMethod.POST)
	public @ResponseBody String activate(@RequestBody String Json){
		msProduct p = new msProduct();
		JSONObject info = new JSONObject();
		try{
			ProductRegistrationInterface regis = new ProductRegistration();
			p.jsonParse(Json);
			info.put("result", regis.activateProduct(p));

		}
		catch(JSONException e){
			try {
				info.put("error_code", 101);
				info.put("result", false);
				info.put("description", "JSON Error");
				return info.toString();
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		catch(SQLException e){
			try {
				info.put("error_code", 102);
				info.put("result", false);
				info.put("description", "SQL Error");
				return info.toString();
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return info.toString();
	}
	
	@RequestMapping(value = "/inactivateProduct", method= RequestMethod.POST)
	public @ResponseBody String inactivate(@RequestBody String Json){
		msProduct p = new msProduct();
		JSONObject info = new JSONObject();
		try{
			ProductRegistrationInterface regis = new ProductRegistration();
			p.jsonParse(Json);
			info.put("result", regis.inactivateProduct(p));

		}
		catch(JSONException e){
			try {
				info.put("error_code", 101);
				info.put("result", false);
				info.put("description", "JSON Error");
				return info.toString();
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		catch(SQLException e){
			try {
				info.put("error_code", 102);
				info.put("result", false);
				info.put("description", "SQL Error");
				return info.toString();
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return info.toString();
	}
	
}
