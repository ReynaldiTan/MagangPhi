package com.phi.controller;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phiintegration.ws.controller.OrderingInterface;
import com.phiintegration.ws.controller.OrderingSQLServer;
import com.phiintegration.ws.model.trOrderDetail;
import com.phiintegration.ws.model.trOrderHeader;

@Controller
public class OrderingService {
	
	@RequestMapping(value = "/newOrderHeader", method= RequestMethod.POST)
	public @ResponseBody String newOrderHeader(@RequestBody String data) {
		
		JSONObject info = new JSONObject();
		try {
			trOrderHeader oh = new trOrderHeader();
			oh.jsonParse(data);
			OrderingInterface ordering = new OrderingSQLServer();
			int id = ordering.newOrderHeader(oh);
		
			info.put("id", id);
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
	
	@RequestMapping(value = "/updateOrderHeader", method= RequestMethod.POST)
	public @ResponseBody String updateOrderHeader(@RequestBody String data) {
		JSONObject info = new JSONObject();
		try {
			trOrderHeader oh = new trOrderHeader();
			oh.jsonParse(data);
			
			OrderingInterface ordering = new OrderingSQLServer();
			boolean result = ordering.updateOrderHeader(oh);
			
			info.put("result", result);
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
	
	@RequestMapping(value = "/closeOrder", method= RequestMethod.POST)
	public @ResponseBody String closeOrder(@RequestBody String data) {
		JSONObject info = new JSONObject();
		try {
			trOrderHeader oh = new trOrderHeader();
			oh.jsonParse(data);
			
			OrderingInterface ordering = new OrderingSQLServer();
			boolean result = ordering.closeOrder(oh);
			
			info.put("result", result);
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
	
	@RequestMapping(value = "/addOrderDetail", method= RequestMethod.POST)
	public @ResponseBody String addOrderDetail(@RequestBody String data) {
		JSONObject info = new JSONObject();
		try {
			trOrderDetail od = new trOrderDetail();
			od.jsonParse(data);
			
			OrderingInterface ordering = new OrderingSQLServer();
			int id = ordering.addOrderDetail(od);
			
			info.put("id", id);
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
	
	@RequestMapping(value = "/updateOrderDetail", method= RequestMethod.POST)
	public @ResponseBody String updateOrderDetail(@RequestBody String data) {
		JSONObject info = new JSONObject();
		try {
			trOrderDetail od = new trOrderDetail();
			od.jsonParse(data);
			
			OrderingInterface ordering = new OrderingSQLServer();
			boolean result = ordering.updateOrderDetail(od);
			
			info.put("result", result);
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
