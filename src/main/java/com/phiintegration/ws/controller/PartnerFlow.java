package com.phiintegration.ws.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.phiintegration.ws.model.DBCon;
import com.phiintegration.ws.model.msEmail;
import com.phiintegration.ws.model.msPartner;
import com.phiintegration.ws.model.msPhone;
import com.phiintegration.ws.model.msUserState;
import com.phiintegration.ws.model.stagingInput;

public class PartnerFlow {
	DBCon db;
	public PartnerFlow() throws SQLException{
		db = new DBCon();
	}
	
	public String PartnerFirstFlow(msUserState user, stagingInput input){
		
		try {
			
			//Cek ada atau ga
			RegistrationInterface regis = new RegistrationSQLServer();
			if(!regis.checkPartnerAlias(user.getUsers())){
				UserStateMethod userState;
				userState = new UserStateMethod();
				userState.updateUser(user);
				
			    
			}else{
				return "{message:\"Telah terdaftar, Gagal Register Partner\" }";
			}
			return "{message:\"Silahkan masukkan Nama: \" }";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{message:\"Terjadi error, Gagal Register Partner\" }";
	}
	
	public String PartnerGetNamaFlow(msUserState user, stagingInput input){
		try {
			
			//GET NAMA, INSERT
			StagingInputMethod sim = new StagingInputMethod();
			//masukan ke staging input
			sim.addStaging_input(input);
			//response
			
			
			UserStateMethod userState;
			userState = new UserStateMethod();
			userState.updateUser(user);
			return "{message:\"Silahkan masukkan Alamat: \" }";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "{message:\"Terjadi error, Gagal Register Partner\" }";
	}

	public String PartnerGetAlamatFlow(msUserState user, stagingInput input){
	
		try {
			
			StagingInputMethod sim = new StagingInputMethod();
			//masukan ke staging input
			sim.addStaging_input(input);
			
			UserStateMethod userState;
			userState = new UserStateMethod();
			userState.updateUser(user);
			return "{message:\"Silahkan masukkan Email: \" }";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{message:\"Terjadi error, Gagal Register Partner\" }";
	}
	
	public String PartnerGetEmailFlow(msUserState user, stagingInput input){
		
		try {
			
			//GET Email, Update
			StagingInputMethod sim = new StagingInputMethod();
			//masukan ke staging input
			sim.addStaging_input(input);
			
			UserStateMethod userState;
			userState = new UserStateMethod();
			userState.updateUser(user);
			return "{message:\"Silahkan masukkan Phone: \" }";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{message:\"Terjadi error, Gagal Register Partner\" }";
	}
	
	public String PartnerConfirmationFlow(msUserState user, stagingInput input){
		
		try {
			//Get Phone, Update
			StagingInputMethod sim = new StagingInputMethod();
			//masukan ke staging input
			sim.addStaging_input(input);
			
			ResultSet rs = sim.selectAllState(user.getState(),user.getUsers());
			ArrayList<String> al = new ArrayList<String>();
			while(rs.next()){
				al.add(rs.getString("message"));
			}
			//System.out.println(al.get(0));
			//Insert to master
			msPartner partner = new msPartner();
			msEmail email = new msEmail();
			msPhone phone = new msPhone();
			
			partner.setPartner_alias(input.getUsername());
			partner.setPartner_external_id(input.getChat_id());
			partner.setPartner_name(al.get(0));
			partner.setIs_active(0);
			email.setEmail_address(al.get(2));
			phone.setPhone_number(al.get(3));
			phone.setIs_primary_phone(1);
			phone.setPhone_description("deskripsinya");
			
			RegistrationInterface r = new RegistrationSQLServer();
			int id = r.insertPartner(partner, email);
			partner.setPartner_id(id);
			r.InsertEmailPartner(partner, email);
			r.InsertPhonePartner(partner, phone);
			
			String temp = PartnerCancelFlow(user,input);

			SMTPMethod sm = new SMTPMethod();
			String isiBody = "Hi! "+al.get(0)+" Selamat anda menjadi anggota dari Chatbot<br><br>";
			String isiPesan = "<h4>Berikut adalah data diri yang anda daftarkan!!:</h4>"
								+"<ul>"
									+"<li><table><tr><td><b>Nama     </b></td><td>: "+ al.get(0) +"</td></tr>"
									+"<tr><td><b>Alamat   </b></td><td>: "+ al.get(2) +"</td></tr>"
									+"<tr><td><b>No handphone   </b></td><td>: "+al.get(3)+"</td></tr>"
								+"</ul>";
			
			sm.sendEmail(al.get(2), isiBody, isiPesan);
			
			//SMTP
			//SMTP s = new SMTP();
			//s.generateAndSendToken(id);
			
			UserStateMethod userState;
			userState = new UserStateMethod();
			userState.updateUser(user);
			return "{message:\"Silahkan cek email konfirmasi \" }";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{message:\"Terjadi error, Gagal Register Partner\" }";
	}
	
	
	public String PartnerCancelFlow(msUserState user, stagingInput input){
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
