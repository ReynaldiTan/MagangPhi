package com.phiintegration.ws.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBCon {
	Connection conn;
	Statement stmt;
	String url ="jdbc:jtds:sqlserver://localhost:1433/Chatbot;user=alpha;password=qweqwe";

	public DBCon(String url) throws SQLException{
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			this.conn = DriverManager.getConnection(url);
			this.stmt = this.conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public DBCon() throws SQLException{
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
	public int executeInsert(String query){
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
