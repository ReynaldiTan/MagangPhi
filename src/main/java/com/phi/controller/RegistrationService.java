//package com.phi.controller;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.phiintegration.ws.controller.RegistrationInterface;
//import com.phiintegration.ws.controller.RegistrationSQLServer;
//
//@Controller
//public class RegistrationService {
//
//	@RequestMapping(value = "/registerPartner", method= RequestMethod.POST)
//	public @ResponseBody String registerPartner(@RequestBody String data) {
//		JSONObject info = new JSONObject();
//		try {
//			RegistrationInterface registration = new RegistrationSQLServer();
//				String value;
//				value = registration.registerPartner(data);
//				info = new JSONObject(value);
//			} catch(JSONException e){
//				try {
//					info.put("error_code", 101);
//					info.put("result", false);
//					info.put("description", "JSON Error");
//					return info.toString();
//				} catch (JSONException e1) {
//					e1.printStackTrace();
//				}
//			}	
//		return info.toString();
//	}
//	
//	@RequestMapping(value = "/addEmail", method= RequestMethod.POST)
//	public @ResponseBody String addEmail(@RequestBody String data) {
//		JSONObject info = new JSONObject();
//		try {
//			RegistrationInterface registration = new RegistrationSQLServer();
//				String value;
//				value = registration.addEmail(data);
//				info = new JSONObject(value);
//			} catch(JSONException e){
//				try {
//					info.put("error_code", 101);
//					info.put("result", false);
//					info.put("description", "JSON Error");
//					return info.toString();
//				} catch (JSONException e1) {
//					e1.printStackTrace();
//				}
//			}	
//		return info.toString();
//	}
//	
//	@RequestMapping(value = "/addPhone", method= RequestMethod.POST)
//	public @ResponseBody String addPhone(@RequestBody String data) {
//		JSONObject info = new JSONObject();
//		try {
//			RegistrationInterface registration = new RegistrationSQLServer();
//				String value;
//				value = registration.addPhone(data);
//				info = new JSONObject(value);
//			} catch(JSONException e){
//				try {
//					info.put("error_code", 101);
//					info.put("result", false);
//					info.put("description", "JSON Error");
//					return info.toString();
//				} catch (JSONException e1) {
//					e1.printStackTrace();
//				}
//			}	
//		return info.toString();
//	}
//	
//	@RequestMapping(value = "/addGeographicLocation", method= RequestMethod.POST)
//	public @ResponseBody String addGeographicLocation(@RequestBody String data) {
//		JSONObject info = new JSONObject();
//		try {
//			RegistrationInterface registration = new RegistrationSQLServer();
//				String value;
//				value = registration.addGeographicLocation(data);
//				info = new JSONObject(value);
//			} catch(JSONException e){
//				try {
//					info.put("error_code", 101);
//					info.put("result", false);
//					info.put("description", "JSON Error");
//					return info.toString();
//				} catch (JSONException e1) {
//					e1.printStackTrace();
//				}
//			}	
//		return info.toString();
//	}
//	
//	@RequestMapping(value = "/updatePartner", method= RequestMethod.POST)
//	public @ResponseBody String updatePartner(@RequestBody String data) {
//		JSONObject info = new JSONObject();
//		try {
//			RegistrationInterface registration = new RegistrationSQLServer();
//				String value;
//				value = registration.updatePartner(data);
//				info = new JSONObject(value);
//			} catch(JSONException e){
//				try {
//					info.put("error_code", 101);
//					info.put("result", false);
//					info.put("description", "JSON Error");
//					return info.toString();
//				} catch (JSONException e1) {
//					e1.printStackTrace();
//				}
//			}	
//		return info.toString();
//	}
//	
//	@RequestMapping(value = "/updateEmail", method= RequestMethod.POST)
//	public @ResponseBody String updateEmail(@RequestBody String data) {
//		JSONObject info = new JSONObject();
//		try {
//			RegistrationInterface registration = new RegistrationSQLServer();
//				String value;
//				value = registration.updateEmail(data);
//				info = new JSONObject(value);
//			} catch(JSONException e){
//				try {
//					info.put("error_code", 101);
//					info.put("result", false);
//					info.put("description", "JSON Error");
//					return info.toString();
//				} catch (JSONException e1) {
//					e1.printStackTrace();
//				}
//			}	
//		return info.toString();
//	}
//	
//	@RequestMapping(value = "/updatePhone", method= RequestMethod.POST)
//	public @ResponseBody String updatePhone(@RequestBody String data) {
//		JSONObject info = new JSONObject();
//		try {
//			RegistrationInterface registration = new RegistrationSQLServer();
//				String value;
//				value = registration.updatePhone(data);
//				info = new JSONObject(value);
//			} catch(JSONException e){
//				try {
//					info.put("error_code", 101);
//					info.put("result", false);
//					info.put("description", "JSON Error");
//					return info.toString();
//				} catch (JSONException e1) {
//					e1.printStackTrace();
//				}
//			}	
//		return info.toString();
//	}
//	
//	@RequestMapping(value = "/updateGeographicLocation", method= RequestMethod.POST)
//	public @ResponseBody String updateGeographicLocation(@RequestBody String data) {
//		JSONObject info = new JSONObject();
//		try {
//			RegistrationInterface registration = new RegistrationSQLServer();
//				String value;
//				value = registration.updateGeographicLocation(data);
//				info = new JSONObject(value);
//			} catch(JSONException e){
//				try {
//					info.put("error_code", 101);
//					info.put("result", false);
//					info.put("description", "JSON Error");
//					return info.toString();
//				} catch (JSONException e1) {
//					e1.printStackTrace();
//				}
//			}	
//		return info.toString();
//	}
//	
//}
