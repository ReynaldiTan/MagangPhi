package com.phiintegration.ws.controller;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.phiintegration.ws.model.DBCon;
import com.phiintegration.ws.model.msProduct;
import com.phiintegration.ws.model.msUserState;
import com.phiintegration.ws.model.stagingInput;

public class inactivateFlow {
	
DBCon db;
	
	public inactivateFlow() throws SQLException{
		db = new DBCon();
	}
	
	public String InactivateFirstFlow(msUserState user, stagingInput input){
		try {
			String message ="";
			//check partner seller
			ProductRegistrationInterface  pr = new ProductRegistration();
			RegistrationInterface ri = new RegistrationSQLServer();

			if(ri.checkPartnerAlias(user.getUsers())){
				message = "{message:\"berikut adalah list produk yang aktif: ";
				for (String productName : pr.getProductsActive(ri.getPartnerId(user.getUsers()))) {
				message += "\n"+productName;
			} 
			
			message += "\" }";
				
				UserStateMethod userState;
				userState = new UserStateMethod();
				userState.updateUser(user);
			}
			else {
				message = "{message:\"Daftarkan diri anda terlebih dahulu\" }";
			}
			return message;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{message:\"Gagal non-Aktivasi product\" }";
	}
	
	public String InactiveProductFlow(msUserState user, stagingInput input){
		String message = "";
		try{
			ProductRegistrationInterface  pr = new ProductRegistration();
			
			RegistrationInterface regis = new RegistrationSQLServer();
			int userID = regis.getPartnerId(input.getUsername());
			if(pr.getProductByName(input.getMessage(),userID)!=null){
				StagingInputMethod sim = new StagingInputMethod();
				//masukan ke staging input
				sim.addStaging_input(input);
				message = "{message:\"Masukan nama produk yang ingin di non-aktifkan \"}";
				
				UserStateMethod userState;
				userState = new UserStateMethod();
				userState.updateUser(user);
			} else {
				message = "{message:\"produk yang anda masukkan tidak ada";
			}
			return message;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	
	public String InactivateGetConfirmationFlow(msUserState user, stagingInput input) throws JSONException{
		JSONObject info = new JSONObject();
		try {
			//Get Summary
			//Insert into master
			ProductRegistration pr = new ProductRegistration();
			StagingInputMethod sim = new StagingInputMethod();
		
			String productDetail = sim.selectByState("inactivate", 1, user.getUsers());
			
			RegistrationInterface regis = new RegistrationSQLServer();
			int userID = regis.getPartnerId(input.getUsername());
			msProduct product = pr.getProductByName(productDetail, userID);
			msProduct m = new msProduct();
			m.setProduct_id(product.getProduct_id());
			//aktivasi produk
			ProductRegistrationInterface pi = new ProductRegistration();
			pi.inactivateProduct(m);
			
			SMTPMethod cs = new SMTPMethod();

			String abc = cs.pickEmail((userID));
			
			String isiBody = "Hi<br>Berikut adalah daftar produk yang sudah diaktivasi<br>";
			String isiPesan = productDetail;
			cs.sendEmail(abc, isiBody, isiPesan);
			
			//delete isi staging
			sim.deleteStaging_input(input);
			info.put("message", "confirm");
			UserStateMethod userState;
			userState = new UserStateMethod();
			user.setState("start");
			user.setStateNum(0);
			userState.updateUser(user);
			return "{message:\"Produk Telah Berhasil di non-aktifkan! \" }";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{message:\"Terjadi error, Gagal aktifasi produk Produk\" }";
	}
	
	public String cancelInactiveFlow(msUserState user ,stagingInput input){
		JSONObject info = new JSONObject();
		try {
			info.put("message", "cancel");
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
