package com.phiintegration.ws.controller;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.phiintegration.ws.model.DBCon;
import com.phiintegration.ws.model.stagingInput;

public class StagingInputMethod {
	DBCon conn;
	
	public StagingInputMethod() throws SQLException {
		conn = new DBCon();
	}

	public int addStaging_input(stagingInput i){
		String query = "INSERT INTO ms_staging_input(state, state_num, message, username, chat_id) VALUES('"+i.getState()+"','"+i.getState_num()+"','"+i.getMessage()+"','"+i.getUsername()+"','"+i.getChat_id()+"')";
		try{
			int id = conn.executeInsert(query);
			return id;
		}
		catch(Exception e){
			return -1;
		}
	}
	
	public boolean deleteStaging_input(stagingInput s){
		String query = "DELETE FROM ms_staging_input WHERE username = '"+s.getUsername()+"'";
		try{
			 conn.executeUpdate(query);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public String selectByState(String state, int statenum, String username){
		String query = "SELECT * FROM ms_staging_input WHERE state='"+state+"' AND state_num="+statenum+" AND username='"+username+"'";
		String message = "";
		try{
			ResultSet rs = conn.executeQuery(query);
			while(rs.next()){
				message = rs.getString("message");
			}
			
			return message;
		}
		catch(Exception e){
			return message;
		}
	}
	
	public ResultSet selectAllState(String state, String username){
		String query = "SELECT * FROM ms_staging_input WHERE state='"+state+"' AND username='"+username+"' ORDER BY state_num";
		try{
			ResultSet rs = conn.executeQuery(query);
			
			return rs;
		}
		catch(Exception e){
			return null;
		}
	}
	
}
