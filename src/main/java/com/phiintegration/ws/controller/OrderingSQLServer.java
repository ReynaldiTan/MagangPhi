package com.phiintegration.ws.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.phiintegration.ws.model.DBCon;
import com.phiintegration.ws.model.msProduct;
import com.phiintegration.ws.model.msUserState;
import com.phiintegration.ws.model.trOrderDetail;
import com.phiintegration.ws.model.trOrderHeader;

public class OrderingSQLServer implements OrderingInterface {
	DBCon db;
	public OrderingSQLServer() throws SQLException{
		db = new DBCon();
	}

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.OrderingInterface#newOrderHeader(com.phiintegration.ws.model.trOrderHeader)
	 */
	@Override
	public int newOrderHeader(trOrderHeader oh){
		try{
			if(db.executeQuery("SELECT * FROM ms_partner WHERE partner_id ="+oh.getPartner_id_seller()).next() 
			&& db.executeQuery("SELECT * FROM ms_partner WHERE partner_id ="+oh.getPartner_id_customer()).next())
			{
				String query = "insert into tr_order_header"
						+ " (order_number, order_date, partner_id_seller, partner_id_customer, seller_name, customer_name, session_id, total_discount, total_value,confirmed)"
						+ " values ('"+oh.getOrder_number()+"','"+oh.getOrder_date()+"',"+oh.getPartner_id_seller()+","
						+ oh.getPartner_id_customer() +",'"+oh.getSeller_name()+"','"+oh.getCustomer_name()+"','"+oh.getSession_id()+"', '"
						+oh.getTotal_discount()+"','"+oh.getTotal_value()+"',"+oh.isConfirmed()+")";
				int id = db.executeInsert(query);
				return id;
			} else {
				System.out.println("Partner_ID not found");
				return -1;
			}
		}catch(Exception e){
			return -1;
		}
	}

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.OrderingInterface#updateOrderHeader(com.phiintegration.ws.model.trOrderHeader)
	 */
	@Override
	public boolean updateOrderHeader(trOrderHeader oh){
		try{
			
			if(!db.executeQuery("SELECT * FROM tr_order_header WHERE order_id ="+oh.getOrder_id()+" AND confirmed=1").next()){
				if(db.executeQuery("SELECT * FROM ms_partner WHERE partner_id ="+oh.getPartner_id_seller()).next()
				&& db.executeQuery("SELECT * FROM ms_partner WHERE partner_id ="+oh.getPartner_id_customer()).next())
				{
					
					db.executeUpdate("UPDATE tr_order_header SET order_number = '"+oh.getOrder_number()+"', order_date = '"+oh.getOrder_date()+"',"
							+ "partner_id_seller = "+oh.getPartner_id_seller()+", partner_id_customer = "+ oh.getPartner_id_customer()+", seller_name='"+oh.getSeller_name()+"',"
							+ "customer_name = '"+oh.getCustomer_name()+"' , session_id = '"+oh.getSession_id()+"', total_discount ='"+oh.getTotal_discount()+"' , total_value ='"+oh.getTotal_value()
							+"', confirmed = "+oh.isConfirmed()+""
							+ " WHERE order_id = "+oh.getOrder_id());
					return true;
				} else {
					System.out.println("Partner_ID not found");
					return false;
				}
			} else {
				System.out.println("Confimed");
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.OrderingInterface#closeOrder(com.phiintegration.ws.model.trOrderHeader)
	 */
	@Override
	public boolean closeOrder(trOrderHeader oh){
		try{
			db.executeUpdate("UPDATE tr_order_header SET confirmed = 1 "
					+ "WHERE order_id = "+oh.getOrder_id());
		}catch(Exception e){
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.OrderingInterface#addOrderDetail(com.phiintegration.ws.model.trOrderDetail)
	 */

	@Override
	public int addOrderDetail(trOrderDetail od){
		try{
			if(db.executeQuery("SELECT * FROM ms_product WHERE product_id ="+od.getProduct_id()+" AND is_active=1").next()){
				String query = "insert into tr_order_detail"
						+ " (order_id, line_id, product_id, product_name, quantity, units, discount_value, discount_percentage, price, total_price)"
						+ " values ("+od.getOrder_id()+","+od.getLine_id()+","+od.getProduct_id()+",'"+od.getProduct_name()+"',"
						+ od.getQuantity() +",'"+od.getUnits()+"',"+od.getDiscount_value()+",'"+od.getDiscount_percentage()+"',"
						+od.getPrice()+","+od.getTotal_price()+")";
				int id = db.executeInsert(query);
				return id;
			} else {
				return -1;
			}
		}catch(Exception e){
			return -1;
		}
	}

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.OrderingInterface#updateOrderDetail(com.phiintegration.ws.model.trOrderDetail)
	 */
	@Override
	public boolean updateOrderDetail(trOrderDetail od){
		try{
			if(!db.executeQuery("SELECT * FROM tr_order_header WHERE order_id ="+od.getOrder_id()+" AND confirmed=1").next()){
				if(db.executeQuery("SELECT * FROM ms_product WHERE product_id ="+od.getProduct_id()+" AND is_active=1").next()){
					db.executeUpdate("UPDATE tr_order_detail SET order_id = "+od.getOrder_id()+", line_id = "+od.getLine_id()+", product_id = "+od.getProduct_id()+","
							+ "product_name = '"+od.getProduct_name()+"', quantity = "+ od.getQuantity()+", units='"+od.getUnits()+"',"
							+ "discount_value = "+od.getDiscount_value()+" , discount_percentage = "+od.getDiscount_percentage()+",price ="+od.getPrice()
							+", total_price = "+od.getTotal_price()
							+ "WHERE row_id = "+od.getRow_id());
				} else {
					return false;
				}
			} else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	@Override
	public int readOrderHeader(msUserState user){
		try{
			int id = 0;
			ResultSet temp = db.executeQuery("SELECT order_id FROM tr_order_header WHERE partner_id_customer = "+user.getUser_ID()+" AND confirmed=0");
			while(temp.next()){
				id = temp.getInt("order_id");
			}
			return id;
		}catch(SQLException e){
			return -1;
		}
	}
	
	@Override
	public boolean deleteOrder(trOrderHeader oh){
		try{	
			db.executeUpdate("DELETE FROM tr_Order_Detail WHERE order_id = '"+ oh.getOrder_id()+"'");
			db.executeUpdate("DELETE FROM tr_Order_Header WHERE order_id = '"+ oh.getOrder_id()+"'");
			
		}catch(SQLException e){
			return false;
		}
		return true;
	}

	@Override
	public boolean updateHeaderTotal(msUserState user){
		try{
			int order_id = readOrderHeader(user);
			String total_discount ="";
			String total_value = "";
			ResultSet temp = db.executeQuery("SELECT SUM(discount_value) as total_discount FROM tr_order_detail WHERE order_id = '"+order_id+"'");
			while(temp.next()){
				 total_discount += temp.getInt("total_discount");
			}
			temp = db.executeQuery("SELECT SUM(price) as total_value FROM tr_order_detail WHERE order_id = '"+order_id+"'");
			while(temp.next()){
				 total_value += temp.getInt("total_value");
			}
			db.executeUpdate( "UPDATE tr_order_header SET total_discount='"+total_discount+"', total_value='"+total_value+"' WHERE order_id='"+order_id+"'" );
		}catch(SQLException e){
			return false;
		}
		return true;
	}
	
	@Override
	public boolean checkStock(msUserState user){
		
		try{
			boolean result = false;
			int order_id = readOrderHeader(user);
			
			ResultSet temp = db.executeQuery("SELECT * FROM tr_order_detail WHERE order_id = '"+order_id+"'");
			ResultSet stock;
			int num = 0;
			String product_id = "";
			while(temp.next()){
				num = temp.getInt("quantity");
				product_id = temp.getString("product_id");
			}	
			stock = db.executeQuery("SELECT * FROM ms_Stock WHERE product_id="+product_id);
			while(stock.next()){
				num = stock.getInt("product_quantity")-num;
				if(num > -1) {
					result = true;
				}
				else {
					result = false;
				}
			}
			

			
			return result;
		}catch(SQLException e){
			return false;
		}
	}
	
	@Override
	public boolean minusStock(msUserState user){
		try{
			int order_id = readOrderHeader(user);
			ResultSet temp = db.executeQuery("SELECT * FROM tr_order_detail WHERE order_id = '"+order_id+"'");
			ResultSet stock;
			int num = 0;
			String product_id = "";
			while(temp.next()){
				num = temp.getInt("quantity");
				product_id = temp.getString("product_id");
			}	
			stock = db.executeQuery("SELECT * FROM ms_Stock WHERE product_id="+product_id);
			while(stock.next()){
				num = stock.getInt("product_quantity")-num;
				db.executeUpdate("UPDATE ms_Stock set product_quantity="+num+" WHERE product_id='"+product_id+"'" );
			}
			
			return true;
		}catch(SQLException e){
			return false;
		}
	}
	
	
}
