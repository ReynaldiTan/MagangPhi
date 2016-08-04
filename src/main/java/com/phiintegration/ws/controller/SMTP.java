package com.phiintegration.ws.controller;

import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.phiintegration.ws.model.DBCon;

public class SMTP {
	DBCon db;
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	static String link = "http://localhost/phiws/confirm/";
	
	public SMTP(){
		try{
			this.db = new DBCon();
		}catch(Exception e){
			System.out.println("SMTP DB Connection Failed");
		}
	}
	
	public static void generateAndSendEmail(String to, String token) throws AddressException, MessagingException {
		 
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "465");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		//generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@crunchify.com"));
		generateMailMessage.setSubject("Email Confirmation from PHI ChatBot");
		String emailBody = "Hi,<br>Please click on the following link to confirm your email<br>Click <a href='"+ link+token + "'>Here</a><br><br> Regards, <br>PHI Admin";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "email.percobaan4321@gmail.com", "kurakuraninj4");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
	
	public void generateAndSendToken(int user_id){
		String token = UUID.randomUUID().toString().replaceAll("-", "");
		String query = "INSERT INTO msUserConfirm (token, user_id) values ('"+token+"',"+user_id+")";
		
		if(db.executeInsert(query)!= -1){
			query = "SELECT email_address from ms_email WHERE partner_id = "+user_id;
			try{
				ResultSet rs = db.executeQuery(query);
				String email ="";
				while(rs.next()){
					email = rs.getString("email_address");
				}
				generateAndSendEmail(email, token);
			}catch(SQLException ex){
				System.out.println("Email tidak berhasil di temukan");
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	public void confirmToken(String token){
			String query = "UPDATE ms_partner SET is_active = 1 WHERE partner_id IN (SELECT user_id from msUserConfirm where token = '"+token+"') ";
			try{
				db.executeUpdate(query);
			}catch(SQLException e){
				System.out.println("Konfirmasi Gagal");
			}
				
	}
}
