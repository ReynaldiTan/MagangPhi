package com.phiintegration.ws.controller;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.phiintegration.ws.model.ms_response;

public class ms_response_method {
	
	Connection conn;
	Statement stmt;
	String url ="jdbc:jtds:sqlserver://localhost:1433/chatbot;user=alpha;password=qweqwe";

	public ms_response_method(String url) throws SQLException{
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			this.conn = DriverManager.getConnection(url);
			this.stmt = this.conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ms_response_method() throws SQLException{
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			this.conn = DriverManager.getConnection(url);
			this.stmt = this.conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String query) throws SQLException{
		return stmt.executeQuery(query);

	}

	/***
	 * Method to insert data based on sql statement, returning 
	 * new sequence id.
	 * 
	 * @author Gustave Lyman
	 * @param query
	 * @return -1 if false, incremental id if succeed
	 */
	@SuppressWarnings("static-access")
	public int addMs_response(ms_response p){
		String query = "INSERT INTO ms_response(state_num, state, response) VALUES('"+p.getState_num()+"','"+p.getState()+"','"+p.getResponse()+"')";
		try{
			stmt.executeUpdate(query,stmt.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		}
		catch(Exception e){
			return -1;
		}
	}
	
	public int updateMs_response(ms_response p){
		String query = "UPDATE ms_response SET state_num = '"+p.getState_num()+"', state = '"+p.getState()+"', response = '"+p.getResponse()+"' WHERE response_id = '"+p.getResponse_id()+"'";
		try{
			stmt.executeUpdate(query,stmt.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		}
		catch(Exception e){
			return -1;
		}
	}
	
	
	public int deleteMs_response(ms_response p){
		String query = "DELETE FROM ms_response WHERE response_id = '"+p.getResponse_id()+"'";
		try{
			stmt.executeUpdate(query,stmt.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		}
		catch(Exception e){
			return -1;
		}
	}
	
	public void executeUpdate(String query) throws SQLException{
		stmt.executeUpdate(query);		
	}
	
}
