package com.phiintegration.ws.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.phiintegration.ws.controller.SMTP;
import com.phiintegration.ws.controller.SMTPMethod;
import com.phiintegration.ws.model.DBCon;
import com.phiintegration.ws.model.trOrderDetail;

public class percobaanArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SMTPMethod sm = new SMTPMethod();
		ArrayList<trOrderDetail> order = sm.PickOrder(0);
		
//		for(int i = 0; i < orderan.size(); i++)
//		{
//			System.out.println(orderan.get(i).getProduct_name());
//		}
		
		String isiPesan = "<table border = 1>"
				+"<tr>"
					+"<th><center>Nama Product</th>"
					+"<th><center>Jumlah</th>"
					+"<th><center>Unit</th>"
					+"<th><center>Harga</th>"
					+"<th><center>total harga</th>"
				+"</tr>";
			
				for(int a = 0; a < order.size(); a++)
				{
					
				isiPesan += "<tr>"
						+"<td><center>"+  order.get(a).getProduct_name()+"</td>"
						+"<td><center>"+ order.get(a).getQuantity() +"</td>"
						+"<td><center>"+ order.get(a).getUnits() +"</td>"
						+"<td><center>"+ order.get(a).getPrice() +"</td>"
						+"<td><center>"+ order.get(a).getTotal_price() + "</td>"
					+"</tr>";
				}
				int sum = 0;
				for(int b = 0; b < order.size(); b++)
				{
					sum += order.get(b).getTotal_price();
				}
				
				isiPesan +="<tr>"
						+"<td colspan = '2'><center><b>Total</b></td>"
						+"<td colspan = '3'><center>"+ sum +"</td>"
					+"</tr>"
				+"</table>";
		
//		for(int i = 0; i < order.size(); i++)
//		{
//				System.out.println("ini hasilnya "+ order.get(i).getProduct_name());
//				System.out.println("ini hasil quantitynya " + order.get(i).getQuantity());
//		}
				
		System.out.println(isiPesan);
//		int sum = 0;
//		for(int b = 0; b < order.size(); b++)
//		{
//			
//			sum += order.get(b).getTotal_price();
//			System.out.println("ini total orderan " + b + "harganya :" +order.get(b).getTotal_price());
//			
//		}
//		System.out.println(sum);
	}

}
