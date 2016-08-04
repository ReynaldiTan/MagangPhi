package com.phiintegration.ws.controller;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONException;


import com.phiintegration.ws.model.DBCon;
import com.phiintegration.ws.model.msEmail;
import com.phiintegration.ws.model.msGeographicLocation;
import com.phiintegration.ws.model.msPartner;
import com.phiintegration.ws.model.msPhone;
import com.phiintegration.ws.model.msUserState;

public class RegistrationSQLServer implements RegistrationInterface {
	DBCon db;
	msPartner objPartner = new msPartner();
	msPhone objPhone = objPartner.phone;
	msEmail objEmail = objPartner.email;
	msGeographicLocation objLocation = objPartner.location;

	public msPartner getObjPartner() {
		return objPartner;
	}

	/**
	 * @param objPartner the objPartner to set
	 */

	public void setObjPartner(msPartner objPartner) {
		this.objPartner = objPartner;
		this.loadEmail();
	}
	
	public RegistrationSQLServer() {
	
	}
	
	/*
	 Load All Email Partner;
	 */
	@Override
	public boolean loadEmail() {
		try {
			if(objPartner.getPartner_id()>-1)
			{
				db = new DBCon();
				ResultSet rs = db.executeQuery("SELECT email_address FROM ms_email where partner_id=" + objPartner.getPartner_id());
	
				while(rs.next())
				{
					objPartner.addEmail(rs.getString("email_address"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	
	
	@Override
	public int insertPartner(msPartner objPartner, msEmail objEmail) throws JSONException {
		int info = 0;
		
		if(objEmail.getEmail_address()==null)
		{
			return -1;
		}
	
		try {
			db = new DBCon();
			String query1 = "SELECT email_address FROM ms_email where email_address='"+ objEmail.getEmail_address()+"'";
			System.out.println(query1);
			ResultSet rs = db.executeQuery(query1);
	
			if (rs.next())
			{
				info = -1;
			}
			else
			{
				String query = "INSERT INTO ms_partner "
						+ "("
						+ " partner_external_id"
						+ ", partner_alias"
						+ ", partner_name"
						+ ", partner_logo"
						+ ", is_active) VALUES ('" 
						+ objPartner.getPartner_external_id() +"',"
						+ "'" + objPartner.getPartner_alias() +"',"
						+ "'" + objPartner.getPartner_name() +"',"
						+ "'" + objPartner.getPartner_logo() + "',"
						+ "" + objPartner.getIs_active() +")";
				
				int temp_id = db.executeInsert(query);
				
				this.objPartner.setPartner_id(temp_id);
	
				info = temp_id;
			}
			return info;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public int InsertEmailPartner(msPartner objPartner,msEmail objEmail) throws JSONException
	{
		
		int info = 0;
		
		try {
			  db = new DBCon();
			  ResultSet rs = db.executeQuery("SELECT email_address FROM ms_email where email_address='"+ objEmail.getEmail_address()+"'");
			 	//System.out.println(objPartner.addEmail(objEmail.getEmail_address()));
			  	//boolean emailExist=objPartner.addEmail(objEmail.getEmail_address());
		      if (rs.next())
		      {
		    	  info = -1;
		    	  
		      }
		      else
		      {		  
		    	  int is_active_email=((objEmail.getIs_primary_email()==0)? 0 : 1 );
		    	  String queryemail= "INSERT INTO ms_email (partner_id, email_type, email_address, is_primary_email) VALUES ('"+objPartner.getPartner_id()+"','"+objEmail.getEmail_type()+"','"+objEmail.getEmail_address()+"'," + is_active_email + ")";
		    	
		    	  int temp_id = db.executeInsert(queryemail);
		    	  
		    	  
		    	  info = temp_id;
		      }
		      return info;
			    
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public int InsertPhonePartner(msPartner objPartner, msPhone objPhone) throws JSONException
	{
	
		int info = 0;
		
		try {
			db = new DBCon();
				
		      ResultSet rs = db.executeQuery("SELECT phone_number FROM ms_phone where phone_number = '" + objPhone.getPhone_number() + "'");
		      if (rs.next())
		      {
		    	  info = -1;
		    	  
		      }
		      else
		      {		  	    
		    	  String queryphone = "INSERT INTO ms_phone (partner_id, phone_type, phone_number, phone_extension, phone_country_code, phone_area_code, phone_description, is_primary_phone) VALUES ('"+objPartner.getPartner_id()+"','"+objPhone.getPhone_type()+"','"+objPhone.getPhone_number()+"','"+objPhone.getPhone_extension()+"','"+objPhone.getPhone_country_code()+"','"+objPhone.getPhone_area_code()+"','"+objPhone.getPhone_description()+"',"+objPhone.isIs_primary_phone()+")";
	
		    	  
		    	  int temp_id = db.executeInsert(queryphone);
		    	  info = temp_id;
	  	      
		      }
		      return info;
			    
		} 
		
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public int insertGeographicLocation(msPartner objPartner, msGeographicLocation objLocation) throws JSONException{
		
		int info = 0;
		
		try {
			  db = new DBCon();
			  
	
		      ResultSet rs = db.executeQuery("SELECT location_address1 FROM ms_geographic_location where location_address1='" + objLocation.getLocation_address1()+ "'");
		      if (rs.next())
		      {
		    	  info = -1;
		    	  
		      }
		      else
		      {		    		
		    	  String query = "INSERT INTO ms_geographic_location (partner_id, location_address1, location_address2, location_geographic_lat, location_geographic_long, is_validated, is_primary) VALUES ('"+objPartner.getPartner_id()+"','"+objLocation.getLocation_address1()+"','"+objLocation.getLocation_address2()+"','"+objLocation.getLocation_geographic_lat()+"','"+objLocation.getLocation_geographic_long()+"',"+objLocation.getIs_validated()+","+objLocation.getIs_primary()+")";
		    	 
		    	  int temp_id = db.executeInsert(query);
		    	  info = temp_id;
	
		      }
		      return info;
			    
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}

	/* (non-Javadoc)
	 * @see com.ocr.controller.RegistrationInterface#UpdatePartner()
	 */
	@Override
	public int UpdatePartner(msPartner objPartner, msEmail objEmail) throws JSONException{
	
		int info = 0;
		
		if(objEmail.getEmail_address()==null)
		{
			return -1;
		}
		
		try {
			db = new DBCon();
			
	
			ResultSet rs = db.executeQuery("SELECT email_address FROM ms_email where email_address='"+objEmail.getEmail_address()+"'");
	
			if (rs == null)
			{
				info = -1;
	
			}
			else
			{		    		
				String query = "update ms_partner set ";
				query += "partner_external_id='" + objPartner.getPartner_external_id() +" ',";
				query += "partner_alias='" + objPartner.getPartner_alias() + "',";
				query += "partner_name='" + objPartner.getPartner_name() + "',";
				query += "partner_logo='" + objPartner.getPartner_logo() + "' ";
				
	
				int panjang = query.length();
				query = query.substring(0, panjang - 1);
	
				query += " where partner_id='"+objPartner.getPartner_id()+"'";
	
				db.executeUpdate(query);
	
				info = objPartner.getPartner_id();
	
			}
			return info;
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return info;
	}

	@Override
	public int updateEmailPartner(msPartner objPartner, msEmail objEmail) throws JSONException {
				//loadEmail();	
				int info = 0;
				try {
					db = new DBCon();
				     
				    	  String query = "UPDATE ms_email SET ";
				    	  query += "email_type='" + objEmail.getEmail_type() + "', ";
				    	  query += "email_address='" + objEmail.getEmail_address() + "', ";
				    	  query += "is_primary_email=" + objEmail.getIs_primary_email() + " ";
				    	  
				    	  int panjang = query.length();
				    	  query = query.substring(0, panjang - 1);
				    	  
				    	  query += " where partner_id='"+objPartner.getPartner_id() + "' AND email_id='" + objEmail.getEmail_id() + "'";
				    	  
				    	  
				    	  
				    	  db.executeUpdate(query);
				    	  
				    	  info = objPartner.getPartner_id();
				    	 
				          return info;
					    
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return info;
			}

	@Override
	public int updateGeographicLocation(msPartner objPartner, msGeographicLocation objLocation) throws JSONException{
			int info = 0;
			
			try {
				db = new DBCon();
							
			      ResultSet rs = db.executeQuery("SELECT location_address1 FROM ms_geographic_location where location_address1='"+objLocation.getLocation_address1()+"'");
			      
			      if (rs.next())
			      {
			    	  info = -1;
			    	  
			      }
			      else
			      {
	//		    	  query = "UPDATE Application SET KTP_Path="+KTPImg+", SIM_Path="+SIMImg+", NPWP_Path="+NPWPImg+" WHERE ID="+Application_ID;
			    	  String query = "update ms_geographic_location set ";
			    	  query += "location_address1='" + objLocation.getLocation_address1() + "',";
			    	  query += "location_address2='" + objLocation.getLocation_address2() + "',";
			    	  query += "location_geographic_lat='" + objLocation.getLocation_geographic_lat() + "',";
			    	  query += "location_geographic_long='" + objLocation.getLocation_geographic_long() + "',";		    	  
			    	  query += "is_validated=" + objLocation.getIs_validated() + ",";
			    	  query += "is_primary=" + objLocation.getIs_primary()+ ",";
			    	  
			    	  int panjang = query.length();
			    	  query = query.substring(0, panjang - 1);
			    	  
			    	  query += " where partner_id='" + objPartner.getPartner_id() + "' AND location_id='" + objLocation.getLocation_id() + "'";
			    	  
			    	  db.executeUpdate(query);
	
			    	  
			    	  info = objPartner.getPartner_id();
			      }
			      return info;
				    
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return info;
		}

	@Override
	public int UpdatePhonePartner(msPartner objPartner, msPhone objPhone) throws JSONException
	{
	
		int info = 0;
		try {
			db = new DBCon();
			
		      ResultSet rs = db.executeQuery("SELECT phone_number FROM ms_phone where phone_number '"+objPhone.getPhone_number()+"'");	
		      if (rs==null)
		      {
		    	  info =-1;
		    	  
		      }
		      else
		      {
		    	  //query = "UPDATE Application SET KTP_Path="+KTPImg+", SIM_Path="+SIMImg+", NPWP_Path="+NPWPImg+" WHERE ID="+Application_ID;
		    	  String query = "update ms_phone set ";
		    	  query += "phone_type='" + objPhone.getPhone_type() + "',";
		    	  query += "phone_number='" + objPhone.getPhone_number() + "',";
		    	  query += "phone_extension='" + objPhone.getPhone_extension()+ "',";
		    	  query += "phone_country_code='" + objPhone.getPhone_country_code() + "',";
		    	  query += "phone_area_code='" + objPhone.getPhone_area_code() + "',";
		    	  query += "phone_description='" + objPhone.getPhone_description() + "',";
		    	  query += "is_primary_phone=" + objPhone.isIs_primary_phone() + " ";
		    	  
		    	  int panjang = query.length();
		    	  query = query.substring(0, panjang - 1);
		    	  
		    	  query += " where partner_id='" + objPhone.getPartner_id() + "' AND phone_id='" + objPhone.getPhone_id() + "'";
		    	  
		    	  db.executeUpdate(query);
	
		    	  info = objPhone.getPartner_id();
		    	 
		      }
		      return info;
			    
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public int deactivatePartner(msPartner objPartner) throws JSONException {
	
		int info = 0;
		
		try {
			db = new DBCon();
		

		      ResultSet rs = db.executeQuery("SELECT id FROM ms_partner where id = "+objPartner.getPartner_id());
		      
		      if (rs == null)
		      {
		    	  info = -1;
		      }
		      else
		      {
		    	  String query = "update ms_partner set ";
				query += "is_active='" + objPartner.getPartner_logo() + "' ";
					
		
					int panjang = query.length();
					query = query.substring(0, panjang - 1);
		
					query += " where partner_id='"+objPartner.getPartner_id()+"'";
		
					db.executeUpdate(query);
		
					info = objPartner.getPartner_id();
		
		    	  
		    	  info =objPartner.getPartner_id();
		      }
		      return info;
			    
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return info;
	}
	
	@Override
	public boolean checkPartnerAlias(String username){
		
		try {
			db=new DBCon();
			
			String query="SELECT * FROM ms_partner where partner_alias = '" + username + "'";
			if(db.executeQuery(query).next()){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	@Override
	public ArrayList<String> getPartnerList(String username){
		ArrayList<String> partner=new ArrayList<String>();
		try {
			db = new DBCon();
			String query = "SELECT * FROM ms_partner where partner_alias != '" + username + "' "
					+ " AND partner_id IN (SELECT partner_id from ms_product WHERE is_active = 1)";
			ResultSet Rs = db.executeQuery(query);
			while(Rs.next()){
				
				partner.add(Rs.getString("partner_alias"));
				
				
			}
			return partner;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return partner;
		
		
	}
	
	@Override
	public int getPartnerId(String username){
		
		try {
			db=new DBCon();
			
			String query="SELECT * FROM ms_partner where partner_alias = '" + username + "'";
			ResultSet Rs = db.executeQuery(query);
			while(Rs.next()){
				
				return Rs.getInt("partner_id");
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
}
