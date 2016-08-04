package com.phiintegration.ws.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.phiintegration.ws.model.DBCon;
import com.phiintegration.ws.model.msProduct;
import com.phiintegration.ws.model.msStock;
import com.phiintegration.ws.model.msUserState;
import com.phiintegration.ws.model.stagingInput;
import com.phiintegration.ws.model.trOrderDetail;
import com.phiintegration.ws.model.trOrderHeader;
import com.phiintegration.ws.model.trRestock;

public class RestockFlow {
	DBCon db;
	
	public RestockFlow() throws SQLException{
		db = new DBCon();
	}
	
	public String RestockFirstFlow(msUserState user, stagingInput input){
		try {
			String message ="";
			//check partner seller
			ProductRegistrationInterface  pr = new ProductRegistration();
			RegistrationInterface ri = new RegistrationSQLServer();

			if(ri.checkPartnerAlias(user.getUsers())){
				message = "{message:\"List produk: ";
				for (String productName : pr.getProducts(ri.getPartnerId(user.getUsers()))) {
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
		return "{message:\"Gagal Restock\" }";
	}
	
	public String RestockProductFlow(msUserState user, stagingInput input){
		String message = "";
		try{
			ProductRegistrationInterface  pr = new ProductRegistration();
			
			RegistrationInterface regis = new RegistrationSQLServer();
			int userID = regis.getPartnerId(input.getUsername());
			
			if(pr.getProductByName(input.getMessage(),userID)!=null){
				StagingInputMethod sim = new StagingInputMethod();
				//masukan ke staging input
				sim.addStaging_input(input);
				message = "{message:\"Masukan jumlah yang diinginkan\"}";
				
				UserStateMethod userState;
				userState = new UserStateMethod();
				userState.updateUser(user);
			} else {
				message = "{message:\"produk yang anda masukkan salah";
			}
			return message;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	
public String RestockQuantityFlow(msUserState user ,stagingInput input){
		
		JSONObject info = new JSONObject();
		try {
			StagingInputMethod sim = new StagingInputMethod();
			sim.addStaging_input(input);
			
			//response
			info.put("message", "Apakah sudah benar?");
			UserStateMethod userState;
			userState = new UserStateMethod();
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

	
	public String doneRestockFlow(msUserState user ,stagingInput input){
		JSONObject info = new JSONObject();
		try {
			ProductRegistration pr = new ProductRegistration();
			StagingInputMethod sim = new StagingInputMethod();
			
			String productName = sim.selectByState("restock", 1, user.getUsers());
			
			RegistrationInterface regis = new RegistrationSQLServer();
			int userID = regis.getPartnerId(input.getUsername());
			msProduct product = pr.getProductByName(productName,userID);
			RestockingInterface restock = new RestockingSQLServer();
			trRestock tr = new trRestock();
			
			RegistrationInterface r = new RegistrationSQLServer();
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			Date now = new Date();
		    String strDate = sdfDate.format(now);
			tr.setRestock_date(strDate);

			tr.setDistributor_partner_id(r.getPartnerId(input.getUsername()));
			tr.setDistributor_name(input.getUsername());
			tr.setProduct_id(product.getProduct_id());
			
			String temp = product.getProduct_name();
			tr.setProduct_name(temp);
			tr.setProduct_unit(product.getProduct_unit());
			tr.setProduct_quantity(Integer.parseInt(sim.selectByState("restock", 2, input.getUsername())));
			restock.newRestock(tr);
			
			
			SMTPMethod cs = new SMTPMethod();
			String email = cs.pickEmail(userID);
			String isiBody = "Hi!<br>Berikut adalah product yang berhasil di restock<br><br>";
			String isiPesan = "<table border = 1>"
				+"<tr>"
					+"<th>Distributor partner Id</th>"
					+"<th>Distributor Name</th>"
					+"<th>Product Id</th>"
					+"<th>Product Name</th>"
					+"<th>Product unit</th>"
					+"<th>Product Quantity</th>"
					+"<th>Product restock date</th>"
				+"</tr>"
				+"<tr>"
					+"<td>"+ r.getPartnerId(input.getUsername()) +"</td>"
					+"<td>"+ input.getUsername() +"</td>"
					+"<td>"+ product.getProduct_id() +"</td>"
					+"<td>"+ temp +"</td>"
					+"<td>"+ product.getProduct_unit() + "</td>"
					+"<td>"+ Integer.parseInt(sim.selectByState("restock", 2, input.getUsername())) + "</td>"
					+"<td>"+ strDate + "</td>"
				+"</tr>"
				+"</table>";
			
			cs.sendEmail(email, isiBody, isiPesan);
			
			sim.deleteStaging_input(input);
			info.put("message", "confirm");
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
	
	public String cancelRestockFlow(msUserState user ,stagingInput input){
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
