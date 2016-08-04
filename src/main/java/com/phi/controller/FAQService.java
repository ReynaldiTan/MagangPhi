package com.phi.controller;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phiintegration.ws.controller.FAQInterface;
import com.phiintegration.ws.controller.FAQSQLServer;
import com.phiintegration.ws.model.QuestionAnswer;

@Controller
public class FAQService {
	
	@RequestMapping(value = "/newQAService", method= RequestMethod.POST)
	public @ResponseBody String newQAService(@RequestBody String data) {
		JSONObject info = new JSONObject();
		try {
			QuestionAnswer qa = new QuestionAnswer();
			qa.jsonParse(data);
			
			FAQInterface faq = new FAQSQLServer();
			int id = faq.newQuestionAnswer(qa);
			
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
	
	@RequestMapping(value = "/updateQAService", method= RequestMethod.POST)
	public @ResponseBody String updateQAService(@RequestBody String data) {
		JSONObject info = new JSONObject();
		try {
			QuestionAnswer qa = new QuestionAnswer();
			qa.jsonParse(data);
			
			FAQInterface faq = new FAQSQLServer();
			boolean result = faq.updateQuestionAnswer(qa);
			
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
	
	@RequestMapping(value = "/deleteQAService", method= RequestMethod.POST)
	public @ResponseBody String deleteQAService(@RequestBody String data) {
		JSONObject info = new JSONObject();
		try {
			QuestionAnswer qa = new QuestionAnswer();
			qa.jsonParse(data);
			
			FAQInterface faq = new FAQSQLServer();
			boolean result = faq.deleteQuestionAnswer(qa);
			
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
