package com.phi.controller;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phiintegration.ws.controller.RestockingInterface;
import com.phiintegration.ws.controller.RestockingSQLServer;
import com.phiintegration.ws.model.msProduct;
import com.phiintegration.ws.model.msStock;
import com.phiintegration.ws.model.trRestock;

@Controller
public class RestockingService {
	
	@RequestMapping(value = "/addStock", method= RequestMethod.POST)
	public @ResponseBody String addStock(@RequestBody String data) {
		JSONObject info = new JSONObject();
		try {
			msStock s = new msStock();
			s.jsonParse(data);
			
			RestockingInterface restocking = new RestockingSQLServer();
			int id = restocking.addStock(s);
			
			info.put("id", id);
		}  catch(JSONException e){
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
	
	@RequestMapping(value = "/updateStock", method= RequestMethod.POST)
	public @ResponseBody String updateStock(@RequestBody String data) {
		JSONObject info = new JSONObject();
		try {
			msStock s = new msStock();
			s.jsonParse(data);
			
			RestockingInterface restocking = new RestockingSQLServer();
			boolean result = restocking.updateStock(s);
			
			info.put("result", result);
		} catch(JSONException e){
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
	
	@RequestMapping(value = "/deleteStock", method= RequestMethod.POST)
	public @ResponseBody String deleteStock(@RequestBody String data) {
		JSONObject info = new JSONObject();
		try {
			msStock s = new msStock();
			s.jsonParse(data);
			
			RestockingInterface restocking = new RestockingSQLServer();
			boolean result = restocking.deleteStock(s);
			
			info.put("result", result);
		} catch(JSONException e){
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
	
	@RequestMapping(value = "/checkStock", method= RequestMethod.POST)
	public @ResponseBody String checkStock(@RequestBody String data) {
		JSONObject info = new JSONObject();
		try {
			msProduct p = new msProduct();
			p.jsonParse(data);
			
			Date datecheck = null;
			JSONObject jsonObj;
			jsonObj = new JSONObject(data);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(jsonObj.has("date"))datecheck = sdf.parse(jsonObj.getString("date"));
			
			RestockingInterface restocking = new RestockingSQLServer();
			int value = restocking.checkStock(p,datecheck);
			
			info.put("value", value);
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
		} catch (ParseException e) {
			try {
				info.put("error_code", 103);
				info.put("result", false);
				info.put("description", "Date Format Error");
				return info.toString();
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return info.toString();
	}
	
	@RequestMapping(value = "/newRestock", method= RequestMethod.POST)
	public @ResponseBody String newRestock(@RequestBody String Json){
		trRestock r = new trRestock();
		JSONObject info = new JSONObject();
		try{
			RestockingInterface restock = new RestockingSQLServer();
			r.jsonParse(Json);
			info.put("id", restock.newRestock(r));
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
	
	@RequestMapping(value = "/updateRestock", method= RequestMethod.POST)
	public @ResponseBody String updateRestock(@RequestBody String Json){
		trRestock r = new trRestock();
		JSONObject info = new JSONObject();
		try{
			RestockingInterface restock = new RestockingSQLServer();
			r.jsonParse(Json);
			info.put("result", restock.updateRestock(r));
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
	
	@RequestMapping(value = "/deleteRestock", method= RequestMethod.POST)
	public @ResponseBody String deleteRestock(@RequestBody String Json){
		trRestock r = new trRestock();
		JSONObject info = new JSONObject();
		try{
			RestockingInterface restock = new RestockingSQLServer();
			r.jsonParse(Json);
			info.put("result", restock.deleteRestock(r));
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
