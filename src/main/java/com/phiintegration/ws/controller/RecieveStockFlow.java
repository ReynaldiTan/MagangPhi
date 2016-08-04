package com.phiintegration.ws.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.phiintegration.ws.model.DBCon;
import com.phiintegration.ws.model.NameQuantity;
import com.phiintegration.ws.model.msProduct;
import com.phiintegration.ws.model.msUserState;
import com.phiintegration.ws.model.stagingInput;
import com.phiintegration.ws.model.trOrderDetail;
import com.phiintegration.ws.model.trOrderHeader;
import com.phiintegration.ws.model.trRestock;


public class RecieveStockFlow {
	DBCon db;
	public RecieveStockFlow() throws SQLException{
		db = new DBCon();
	}
	
	public String RecieveFirstFlow(msUserState user, stagingInput input){
		try {
			RegistrationInterface regis = new RegistrationSQLServer();
			RestockingInterface restock = new RestockingSQLServer();
			
			String message = "";
			if(regis.checkPartnerAlias(user.getUsers())){
				UserStateMethod userState;
				userState = new UserStateMethod();
				userState.updateUser(user);
				
			    message = "{message:\"List Restock: \n ID, Nama Produk, Jumlah";
				for (NameQuantity restockList : restock.getRestockList(user.getUsers())) {
					message += "\n"+restockList.getId()+", "+restockList.getName()+", "+restockList.getQuantity();
				} 
				
				message += "\"\n Silahkan masukkan id nya }";
			
			} else {
				message = "{message:\"Mohon register terlebih dahulu\"";
			}
			return message;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{message:\"Gagal Pesan\" }";
	}
	
	public String RecieveGetIDFlow(msUserState user, stagingInput input){
		try {
			RestockingInterface restocking= new RestockingSQLServer();
			if(restocking.reciveIDValid(Integer.parseInt(input.getMessage()))){
				//GET ID, INSERT
				StagingInputMethod sim = new StagingInputMethod();
				//masukan ke staging input
				sim.addStaging_input(input);
				//response
	
				UserStateMethod userState;
				userState = new UserStateMethod();
				userState.updateUser(user);
				return "{message:\"Silahkan masukkan tanggal penerimaan barang \" }";
			}
			else {
				return "{message:\"ID yang anda masukkan salah\" }";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "{message:\"Terjadi error, Gagal Register Partner\" }";
	}
	
	public String RecieveGetDateFlow(msUserState user, stagingInput input){
		try {
			
			//GET RECIEVE DATE, INSERT
			StagingInputMethod sim = new StagingInputMethod();
			//masukan ke staging input
			sim.addStaging_input(input);
			
			//update trRestock
			ResultSet rs = sim.selectAllState(user.getState(),user.getUsers());
			ArrayList<String> al = new ArrayList<String>();
			while(rs.next()){
				al.add(rs.getString("message"));
			}
			trRestock tr = new trRestock();
			RestockingInterface restock = new RestockingSQLServer();
			
			tr = restock.getRestockInfo(Integer.parseInt(al.get(0)));
			tr.setRestock_id(Integer.parseInt(al.get(0)));
			tr.setReceive_date(al.get(1));
			
			restock.updateRecieve(tr);
			
			System.out.println(user.getUser_ID());
			SMTPMethod cs = new SMTPMethod();
			String getId = cs.pickId(user.getUser_ID());
			String email = cs.pickEmail(Integer.parseInt(getId));
			
			String isiBody = "Hi<br>Berikut adalah daftar produk yang sudah didaftarkan<br><br>";
			String isiPesan = "<table border = 1>"
						+"<tr>"
							+"<th>Restock Id</th>"
							+"<th>Recieve Date</th>"
						+"</tr>"
						+"<tr>"
							+"<td>"+ al.get(0) +"</td>"
							+"<td>"+ al.get(1) + "</td>"
						+"</tr>"
						+"</table>";
			
			cs.sendEmail(email, isiBody, isiPesan);
			
			
			RecieveCancelFlow(user,input);
			return "{message:\"Recieve Date Updated\" }";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "{message:\"Terjadi error, Gagal Register Partner\" }";
	}
	
	public String RecieveCancelFlow(msUserState user, stagingInput input){
		JSONObject info = new JSONObject();
		try {
			
			//DELETE TEMP
			StagingInputMethod sim = new StagingInputMethod();
			sim.deleteStaging_input(input);
			
			
			info.put("message", "cancel ");
			UserStateMethod userState;
			userState = new UserStateMethod();
			user.setState("start");
			user.setStateNum(0);
			userState.updateUser(user);
		}catch(JSONException e){
			try {
				info.put("error_code", 101);
				info.put("message", false);
				info.put("description", "JSON Error");
				return info.toString();
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		catch(SQLException e){
			try {
				info.put("error_code", 102);
				info.put("message", false);
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
