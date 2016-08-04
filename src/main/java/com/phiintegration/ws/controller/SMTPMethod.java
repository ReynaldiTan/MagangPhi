package com.phiintegration.ws.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.phiintegration.ws.model.DBCon;
import com.phiintegration.ws.model.msProduct;
import com.phiintegration.ws.model.trOrderDetail;



public class SMTPMethod {
	
	public void sendEmail(String penerima, String isiBody, String isiPesan ){
		
		try {
			System.out.println("mulai Konfigurasi =======================>>");
            	Properties properties=new Properties();
            	properties.put("mail.smtps.host","smtp.gmail.com");
            	properties.put("mail.smtps.auth","true");
            	properties.put("mail.smtps.ssl.enable","true");
            	properties.put("mail.smtps.port", "465");//default port dari smptp
             
            	Session session=Session.getInstance(properties);
            	session.setDebug(true);
            	System.out.println("Konfigurasi selesai =======================>>");
           
            	MimeMessage pesan=new MimeMessage(session);
            	pesan.setFrom();//isi dengan gmail kalian sendiri, biasanya sama nanti dengan username
            	pesan.setRecipient(Message.RecipientType.TO, new InternetAddress(penerima));//isi dengan tujuan email
            	pesan.setSubject("Konfirmasi aktivasi produk");
            	String isiKonten = isiBody + isiPesan;
            	pesan.setContent(isiKonten, "text/html");
            	
            	System.out.println("pesan telah selesai =======================>>");
             
            	String username="email.percobaan4321@gmail.com";//isi dengan gmail kalian sendiri
            	String password="kurakuraninj4";//isi dengan password sendiri
             
            	Transport transport = session.getTransport("smtps");
            	transport.connect(username, password);
            	transport.sendMessage(pesan, pesan.getAllRecipients());
            	transport.close();
            	System.out.println("tutup koneksi =======================>>");
            	System.out.println("email berhasil terkirim!");
        	} 
			catch (MessagingException ex) 
			{
            	ex.printStackTrace();
        	}
	}
	
	
	public String pickEmail(int p) throws SQLException
	{
		String email = "";
		try{
			DBCon db = new DBCon();
			ResultSet rs = db.executeQuery("SELECT email_address FROM ms_email WHERE partner_id =" + p);
		
			if(rs.next()) email = rs.getString("email_address");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return email;
	}
	
	public String pickId(int p) throws SQLException
	{
		String email = "";
		try{
			DBCon db = new DBCon();
			ResultSet rs = db.executeQuery("SELECT partner_id FROM ms_partner WHERE partner_external_id =" + p);
		
			if(rs.next()) email = rs.getString("partner_id");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return email;
	}
	
	public ArrayList<trOrderDetail> PickOrder(int p)
	{
		ArrayList<trOrderDetail> order = new ArrayList<trOrderDetail>();
		
		//String order = "";
		//String quantity = "";
		try{
			DBCon db = new DBCon();
			ResultSet rs = db.executeQuery("SELECT product_name, quantity, units, price, total_price FROM tr_order_detail WHERE order_id =" + p);
		
			while(rs.next())
			{
				trOrderDetail od = new trOrderDetail();
				od.setProduct_name(rs.getString("product_name"));
				od.setQuantity(rs.getInt("quantity"));
				od.setUnits(rs.getString("units"));
				od.setPrice(rs.getInt("price"));
				od.setTotal_price(rs.getInt("total_price"));
				
				order.add(od);
			}
			//if(rs.next()) order = rs.getString("product_name");
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return order;
	}
	
 }