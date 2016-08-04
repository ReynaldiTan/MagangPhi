package com.phiintegration.ws.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.phiintegration.ws.model.ms_input_model;

public class ms_input_method {
	Connection conn;
	Statement stmt;
	String url ="jdbc:jtds:sqlserver://localhost:1433/Chatbot;user=alpha;password=qweqwe";

	public void con_msinput(String url) throws SQLException{
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			this.conn = DriverManager.getConnection(url);
			this.stmt = this.conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public ms_input_method() throws SQLException{
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			this.conn = DriverManager.getConnection(url);
			this.stmt = this.conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("static-access")
	public int addms_input(ms_input_model ms) {
		// TODO Auto-generated method stub
		//String query1 = "INSERT INTO product(partner_setter_id, product_external_id, product_name,product_description,product_price,product_unit,active,how_to_order) VALUES(?,?,?,?,?)";
		String query = "INSERT INTO ms_input(state,state_num,input,nextstate,nextstatenum) values('" + ms.getState() + "'," + ms.getState_num()+ ",'" + ms.getInput()+ "','" + ms.getNextstate()+ "'," + ms.getNextstatenum()+ ")";
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


	public int updatems_input(ms_input_model ms) {
		// TODO Auto-generated method stub
		String query = "UPDATE ms_input set state='"+ms.getState()+"',state_num='"+ms.getState_num()+"',input='"+ms.getInput()+"',nextstate='"+ms.getNextstate()+"',nextstatenum='"+ms.getNextstatenum()+"' where input_ID='"+ms.getInputID()+"'";
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


	public int deletems_input(ms_input_model ms) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM ms_input where input_ID='"+ms.getInputID()+"'";
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
	
}
