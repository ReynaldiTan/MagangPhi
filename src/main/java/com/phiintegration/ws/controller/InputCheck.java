package com.phiintegration.ws.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;

import com.phiintegration.ws.model.DBCon;
import com.phiintegration.ws.model.msUserState;
import com.phiintegration.ws.model.stagingInput;

public class InputCheck {
	
	public String checkInput(String input) throws SQLException{
		String JSON = "{message:\"input gagal\" }";
		msUserState us = new msUserState();
		stagingInput si = new stagingInput();
		try {
			si.jsonParse(input);
		
			UserStateMethod m = new UserStateMethod();
			us = m.checkUser(si.getUsername());
			si.setState(us.getState());
			si.setState_num(us.getStateNum());
			
			us = checkRegex(us,si.getMessage());
			if(us.isCheck()) {

				ExecuteState exe = new ExecuteState();
				JSON = exe.doState(us,si);
				
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return JSON;
	}
	
	public msUserState checkRegex(msUserState user, String input) throws JSONException{
		DBCon con = null;
		Pattern p = null;
		try {
			con = new DBCon();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		String query = "SELECT * from ms_input WHERE state ='"+user.getState()+"' AND state_num ="+user.getStateNum();
		try {
			ResultSet rs = con.executeQuery(query);
			while(rs.next()){
				p = p.compile(rs.getString("input"));
				Matcher m = p.matcher(input);
				if(m.matches()){
					user.setState(rs.getString("nextstate"));
					user.setStateNum(rs.getInt("nextstatenum"));
					user.setCheck(true);
					return user;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		user.setCheck(false);
		return user;
	}
}
