package com.phiintegration.ws.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.phiintegration.ws.model.DBCon;
import com.phiintegration.ws.model.msProduct;
import com.phiintegration.ws.model.msStock;
import com.phiintegration.ws.model.msUserState;
import com.phiintegration.ws.model.stagingInput;
import com.phiintegration.ws.model.trOrderDetail;
import com.phiintegration.ws.model.trOrderHeader;

public class ProdukFlow {
	DBCon db;
	public ProdukFlow() throws SQLException{
		db = new DBCon();
	}
	
	public String ProdukFirstFlow(msUserState user, stagingInput input){
		
		try {
			UserStateMethod userState;
			userState = new UserStateMethod();
			userState.updateUser(user);
			return "{message:\"Silahkan masukkan external id produk: \" }";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{message:\"Terjadi error, Gagal Register Produk\" }";
	}
	
	public String ProdukGetExIDFlow(msUserState user, stagingInput input){
		
		try {
			
			//GET ID, INSERT
			StagingInputMethod sim = new StagingInputMethod();
			//masukan ke staging input
			sim.addStaging_input(input);
			
			
			UserStateMethod userState;
			userState = new UserStateMethod();
			userState.updateUser(user);
			return "{message:\"Silahkan masukkan Nama Produk: \" }";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{message:\"Terjadi error, Gagal Register Produk\" }";
	}
	
	public String ProdukGetNamaFlow(msUserState user, stagingInput input){
		
		try {
			
			//GET Nama, Update
			StagingInputMethod sim = new StagingInputMethod();
			
			
			ProductRegistrationInterface pi = new ProductRegistration();
			
			RegistrationInterface regis = new RegistrationSQLServer();
			int userID = regis.getPartnerId(input.getUsername());
			
			if(pi.getProductByName(input.getMessage(),userID)!=null){
				return "{message:\"Nama Produk sudah ada\" }";
			}
			
			sim.addStaging_input(input);
			UserStateMethod userState;
			userState = new UserStateMethod();
			userState.updateUser(user);
			return "{message:\"Silahkan masukkan Deskripsi Produk: \" }";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{message:\"Terjadi error, Gagal Register Produk\" }";
	}
	
	public String ProdukGetDescriptionFlow(msUserState user, stagingInput input){
		
		try {
			
			//GET Desc, Update
			StagingInputMethod sim = new StagingInputMethod();
			//masukan ke staging input
			sim.addStaging_input(input);
			
			UserStateMethod userState;
			userState = new UserStateMethod();
			userState.updateUser(user);
			return "{message:\"Silahkan masukkan Harga Produk: \" }";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{message:\"Terjadi error, Gagal Register Produk\" }";
	}
	public String ProdukGetPriceFlow(msUserState user, stagingInput input){
		
		try {
			StagingInputMethod sim = new StagingInputMethod();
			//masukan ke staging input
			sim.addStaging_input(input);
			//GET Harga, Update
			
			
			UserStateMethod userState;
			userState = new UserStateMethod();
			userState.updateUser(user);
			return "{message:\"Silahkan masukkan Satuan Produk: \" }";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{message:\"Terjadi error, Gagal Register Produk\" }";
	}
	
	public String ProdukGetUnitFlow(msUserState user, stagingInput input){
		
		try {
			
			//GET Unit, Update
			StagingInputMethod sim = new StagingInputMethod();
			//masukan ke staging input
			sim.addStaging_input(input);
			
			UserStateMethod userState;
			userState = new UserStateMethod();
			userState.updateUser(user);
			return "{message:\"Silahkan masukkan Cara Memesan Produk: \" }";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{message:\"Terjadi error, Gagal Register Produk\" }";
	}
	public String ProdukGetHowToOrderFlow(msUserState user, stagingInput input){
		
		try {
			
			//GET How to Order, Update
			StagingInputMethod sim = new StagingInputMethod();
			//masukan ke staging input
			sim.addStaging_input(input);
			
			ResultSet r = sim.selectAllState("produk", input.getUsername());
			ArrayList<String> al = new ArrayList<String>();
			while(r.next()){
				al.add(r.getString("message"));
			}
			
			//Get Summary
			
			UserStateMethod userState;
			userState = new UserStateMethod();
			userState.updateUser(user);
			return "{message:\" Apakah produk sudah benar?: "
							+ "\\nExternalID: "+al.get(0)+"\\n"
							+ "Nama Produk: "+al.get(1)+"\\n"
							+ "Deskripsi Produk: "+al.get(2)+"\\n"
							+ "Harga Produk: "+al.get(3)+"\\n"
							+ "Satuan produk: "+al.get(4)+"\\n"
							+ "Cara Memesan produk: "+al.get(5)+"\\n"
							+ " \" }";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{message:\"Terjadi error, Gagal Register Produk\" }";
	}
	public String ProdukGetConfirmationFlow(msUserState user, stagingInput input){
		
		try {
		
			//Get Summary
			//Insert into master
			StagingInputMethod sim = new StagingInputMethod();
			RegistrationInterface ri = new RegistrationSQLServer();
			ResultSet r = sim.selectAllState("produk", input.getUsername());
			ArrayList<String> al = new ArrayList<String>();
			while(r.next()){
				al.add(r.getString("message"));
			}
			
			msProduct m = new msProduct();
			m.setProduct_external_id(al.get(0));
			m.setProduct_name(al.get(1));
			m.setProduct_description(al.get(2));
			m.setProduct_price(Integer.parseInt(al.get(3)));
			m.setProduct_unit(al.get(4));
			m.setActive(1);
			m.setHow_to_order(al.get(5));
			m.setPartner_seller_id(ri.getPartnerId(input.getUsername()));
			ProductRegistrationInterface pi = new ProductRegistration();
			int id = pi.addProduct(m);
			
			
			msStock ms = new msStock();
			ms.setProduct_id(id);
			ms.setProduct_name(al.get(1));
			ms.setProduct_quantity(0);
			ms.setProduct_unit(al.get(4));
			ms.setDistributor_name(user.getUsers());
			ms.setDistributor_partner_id(ri.getPartnerId(input.getUsername()));
			ms.setIs_active(1);
			RestockingInterface re = new RestockingSQLServer();
			re.addStock(ms);
			
			SMTPMethod cs = new SMTPMethod();
			String email = cs.pickEmail(ri.getPartnerId(input.getUsername()));
			String isiBody = "Hi<br>Berikut adalah daftar produk yang sudah didaftarkan<br><br>";
			String isiPesan ="<table border = 1>"
						+"<tr>"
							+"<th>Product External id</th>"
							+"<th>Product Name</th>"
							+"<th>Product Description</th>"
							+"<th>Product price</th>"
							+"<th>Product unit</th>"
							+"<th>How to oder</th>"
							+"<th>Partner Seller id</th>"
						+"</tr>"
						+"<tr>"
							+"<td>"+ al.get(0) +"</td>"
							+"<td>"+ al.get(1) +"</td>"
							+"<td>"+ al.get(2) +"</td>"
							+"<td>"+ Integer.parseInt(al.get(3)) +"</td>"
							+"<td>"+ al.get(4) + "</td>"
							+"<td>"+ al.get(5) +"</td>"
							+"<td>"+ ri.getPartnerId(input.getUsername()) + "</td>"
						+"</tr>"
					+"</table>";
			
			cs.sendEmail(email, isiBody, isiPesan);
			
			deleteProductFlow(user,input);
			
			return "{message:\"Produk Telah Berhasil Diregistrasi! \" }";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{message:\"Terjadi error, Gagal Register Produk\" }";
	}
	

	public String deleteProductFlow(msUserState user ,stagingInput input){
		JSONObject info = new JSONObject();
		//DELETE TEMP
		try{
			StagingInputMethod sim = new StagingInputMethod();
			sim.deleteStaging_input(input);
			
			info.put("message", "cancel ");
			
			UserStateMethod userState;
			userState = new UserStateMethod();
			user.setState("start");
			user.setStateNum(0);
			userState.updateUser(user);
		}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
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
