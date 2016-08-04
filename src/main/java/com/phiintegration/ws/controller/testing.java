package com.phiintegration.ws.controller;

import org.json.JSONException;
import org.json.JSONObject;

public class testing {
	  public static void main(String[] args) throws JSONException {
		String json = "{id:1,message:{sender:\'Feris\',message:\'Berapa Harganya?\'}}";
		  JSONObject temp = new JSONObject(json);
		  temp.getJSONObject("message").put("receiver", "Arief");
		  System.out.println(temp.getJSONObject("message").getString("message"));
		  System.out.println(temp.getJSONObject("message").getString("receiver"));
		  System.out.println(temp.toString());
	  }
}
