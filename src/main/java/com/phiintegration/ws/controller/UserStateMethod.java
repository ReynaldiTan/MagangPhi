package com.phiintegration.ws.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.phiintegration.ws.model.DBCon;
import com.phiintegration.ws.model.msUserState;

public class UserStateMethod {
	
	DBCon conn;
	public UserStateMethod() throws SQLException {
		conn = new DBCon();
	}

	
	
	public int addUser(msUserState ms) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO ms_user_state (users, state, stateNum) + VALUES ('" + ms.getUsers() + ", "
				+ ms.getState() + ", " + ms.getStateNum() + "')";
		try {
			return conn.executeInsert(query);
		} catch (Exception e) {
			return -1;
		}
	}

	public int updateUser(msUserState ms) {
		// TODO Auto-generated method stub
		String query = "UPDATE ms_user_state SET users='" + ms.getUsers() + "',state='" + ms.getState()
				+ "', stateNum='" + ms.getStateNum() + "' where user_ID='" + ms.getUser_ID() + "'";
		try {
			conn.executeUpdate(query);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	public msUserState checkUser(int user_id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM ms_user_state where user_ID = "+user_id;
		try {
			ResultSet rs = conn.executeQuery(query);
			msUserState ms = new msUserState();
			while (rs.next()) {
				ms.setUser_ID(rs.getInt("user_ID"));
				ms.setUsers(rs.getString("users"));
				ms.setState(rs.getString("state"));
				ms.setStateNum(rs.getInt("stateNum"));
				
				}
			return ms;

		}catch (Exception e) {
			return null;

		}
	}
	
	public msUserState checkUser(String username) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM ms_user_state where users = '"+username+"'";
		try {
			ResultSet rs = conn.executeQuery(query);
			msUserState ms = new msUserState();
			while (rs.next()) {
				ms.setUser_ID(rs.getInt("user_ID"));
				ms.setUsers(rs.getString("users"));
				ms.setState(rs.getString("state"));
				ms.setStateNum(rs.getInt("stateNum"));
				
				}
			return ms;

		}catch (Exception e) {
			return null;

		}
	}
}
