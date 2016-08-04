package com.phiintegration.ws.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.phiintegration.ws.model.DBCon;
import com.phiintegration.ws.model.NameQuantity;
import com.phiintegration.ws.model.msProduct;
import com.phiintegration.ws.model.msStock;
import com.phiintegration.ws.model.msUserState;
import com.phiintegration.ws.model.trRestock;

public class RestockingSQLServer implements RestockingInterface {
	DBCon db;
	public RestockingSQLServer() throws SQLException{
			db=new DBCon();
	}

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.RestockingInterface#addStock(com.phiintegration.ws.model.msStock, com.phiintegration.ws.model.msProduct)
	 */
	@Override
	public int addStock(msStock objStock){
		try {
			if(db.executeQuery("Select partner_id from ms_partner where partner_id = " + objStock.getDistributor_partner_id()).next() &&
			   db.executeQuery("Select * from ms_product where product_id = '" + objStock.getProduct_id() +"' AND is_active=1").next()) {
				String query="INSERT INTO ms_stock(distributor_partner_id,distributor_name,product_id,product_name,product_unit,product_quantity,is_active) "
						+ "VALUES ("
						+ "'" + objStock.getDistributor_partner_id() + "',"
						+ "'" + objStock.getDistributor_name() + "',"
						+ "'" + objStock.getProduct_id() + "',"
						+ "'" + objStock.getProduct_name() + "',"
						+ "'" + objStock.getProduct_unit() + "',"
						+ "'" + objStock.getProduct_quantity() + "',"
						+ "" + objStock.getIs_active() + ")";
				int temp_id=db.executeInsert(query);
				
				return temp_id;
			}
			else
			{
				return -1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
		
	}
	
	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.RestockingInterface#updateStock(com.phiintegration.ws.model.msStock)
	 */
	@Override
	public boolean updateStock(msStock objStock){
		
		try {
			
			String query="UPDATE ms_stock SET ";
					query+= "distributor_partner_id='" + objStock.getDistributor_partner_id() + "',";
					query+= "distributor_name='" + objStock.getDistributor_name() + "', ";
					query+= "product_id='" + objStock.getProduct_id() + "',";
					query+= "product_name='" + objStock.getProduct_name() + "',";
					query+= "product_unit='" + objStock.getProduct_unit() + "',";
					query+= "product_quantity='" + objStock.getProduct_quantity() + "',";
					query+= "is_active=" + objStock.getIs_active() + " ";
					query +=" WHERE stock_id='" + objStock.getStock_id() + "'";
					System.out.println(query);
					db.executeUpdate(query);
					
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.RestockingInterface#deleteStock(com.phiintegration.ws.model.msStock)
	 */
	@Override
	public boolean deleteStock(msStock objStock){
		try {
			String query="DELETE FROM ms_stock WHERE stock_id='" + objStock.getStock_id() + "'";
			db.executeUpdate(query);
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.RestockingInterface#checkStock(com.phiintegration.ws.model.msProduct, java.util.Date)
	 */
	@Override
	public int checkStock(msProduct objProduct, Date dateCheck){
		try {
			int orderQty = 0,restockQty = 0;		
			String query="SELECT sum(t2.quantity) FROM tr_order_header t1 JOIN tr_order_detail t2 ON t1.order_id=t2.order_id "
					+ "WHERE t1.partner_id_seller='" + objProduct.getPartner_seller_id() + "'"
					+ " AND t2.product_id='" + objProduct.getProduct_id() + "' AND t1.order_date <= '" + dateCheck + "'";
			ResultSet rs= db.executeQuery(query);
			if(rs.next()) orderQty=rs.getInt(0);
			
			query="SELECT sum(product_quantity) FROM tr_restock WHERE "
					+ "distributor_partner_id='" + objProduct.getPartner_seller_id() + "' AND product_id='" + objProduct.getProduct_id() + "' AND receive_date <= '" + dateCheck + "'";
			ResultSet rs1= db.executeQuery(query);
			if(rs1.next()) restockQty=rs.getInt(0);
			return restockQty-orderQty;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.RestockingInterface#newRestock(com.phiintegration.ws.model.trRestock)
	 */
	@Override
	public int newRestock(trRestock objRestock){
		try{
			String query="INSERT INTO tr_restock(restock_date,distributor_partner_id,distributor_name"
					+ ",product_id,product_name,product_unit,product_quantity) VALUES ("
					+ "'" + objRestock.getRestock_date() + "','" + objRestock.getDistributor_partner_id() + "',"
					+ "'" + objRestock.getDistributor_name() + "','" + objRestock.getProduct_id() + "',"
					+ "'" + objRestock.getProduct_name() + "','" + objRestock.getProduct_unit() + "','" + objRestock.getProduct_quantity() + "')";
			int tmpID = db.executeInsert(query);
			return tmpID;
		}
		catch(Exception ex)
		{
			return -1;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.RestockingInterface#updateRestock(com.phiintegration.ws.model.trRestock)
	 */
	@Override
	public boolean updateRestock(trRestock objRestock){
		try {
			if(!db.executeQuery("SELECT receive_date FROM tr_restock WHERE restock_id='" + objRestock.getRestock_id() + "'").next()){
				String query="UPDATE tr_restock SET ";
						if(objRestock.getRestock_date() != null) query += "restock_date='" + objRestock.getRestock_date() + "', ";
						if(objRestock.getReceive_date() != null) query += "receive_date='" + objRestock.getReceive_date() + "', ";
						if(objRestock.getDistributor_partner_id() != 0) query += "distributor_partner_id='" + objRestock.getDistributor_partner_id() + "', ";
						if(objRestock.getDistributor_name() != null) query += "distributor_name='" + objRestock.getDistributor_name() + "', ";
						if(objRestock.getProduct_id() != 0) query += "product_id='" + objRestock.getProduct_id() + "', ";
						if(objRestock.getProduct_name() != null) query += "product_name='" + objRestock.getProduct_name() + "', ";
						if(objRestock.getProduct_unit() != null) query += "product_unit='" + objRestock.getProduct_unit() + "', ";
						if(objRestock.getProduct_quantity() != 0) query += "product_quantity='" + objRestock.getProduct_quantity() + "', ";
						query += " WHERE restock_id='" + objRestock.getRestock_id() + "'";
				db.executeUpdate(query);
				return true;						
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.RestockingInterface#deleteRestock(com.phiintegration.ws.model.trRestock)
	 */
	@Override
	public boolean deleteRestock(trRestock objRestock){
			try {
				if(!db.executeQuery("SELECT receive_date FROM tr_restock WHERE restock_id='" + objRestock.getRestock_id() + "'").next()){
					String query="DELETE FROM tr_restock restock_id='" + objRestock.getRestock_id() + "'";
					db.executeUpdate(query);
					return true;						
				}else{
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return false;
			}
	}
	
	@Override
	public ArrayList<NameQuantity> getRestockList(String user){
			ArrayList<NameQuantity> anq = new ArrayList<NameQuantity>();
			NameQuantity nq = new NameQuantity();
			try {
				String query = "SELECT * FROM tr_restock WHERE distributor_name='"+user+"' AND receive IS NULL";
				ResultSet rs = db.executeQuery(query);
				while(rs.next()){
					nq.setId(rs.getInt("restock_id"));
					nq.setName(rs.getString("product_name"));
					nq.setQuantity(rs.getInt("product_quantity"));
					anq.add(nq);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			return anq;
	}
	
	@Override
	public trRestock getRestockInfo(int id){
			trRestock tr = new trRestock();
			try {
				String query = "SELECT * FROM tr_restock WHERE restock_id='"+id+"'";
				ResultSet rs = db.executeQuery(query);
				while(rs.next()){
					tr.setProduct_id(id);
					tr.setRestock_date(rs.getString("restock_date"));
					tr.setDistributor_partner_id(rs.getInt("distributor_partner_id"));
					tr.setDistributor_name(rs.getString("distributor_name"));
					tr.setProduct_id(rs.getInt("product_id"));
					tr.setProduct_name(rs.getString("product_name"));
					tr.setProduct_unit(rs.getString("product_unit"));
					tr.setProduct_quantity(rs.getInt("product_quantity"));
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			return tr;
	}
	
	
	@Override
	public boolean updateRecieve(trRestock objRestock){
		
		try {			
			String query="UPDATE tr_restock SET ";
					query+= "receive='" + objRestock.getReceive_date() + "'";
					query +=" WHERE restock_id='" + objRestock.getRestock_id() + "'";
			db.executeUpdate(query);
			
			query ="SELECT product_quantity FROM ms_stock WHERE distributor_partner_id='"+objRestock.getDistributor_partner_id()+"'"
					+" AND product_id="+objRestock.getProduct_id();
			ResultSet rs = db.executeQuery(query);
			int num = 0;
			while(rs.next()){
				num = rs.getInt("product_quantity");
			}
			num = num + objRestock.getProduct_quantity();
			
			query="UPDATE ms_stock SET ";
				query += "product_quantity=" + num ;
				query += " WHERE distributor_partner_id='"+objRestock.getDistributor_partner_id()+"'";
				query += " AND product_id="+objRestock.getProduct_id();
				db.executeUpdate(query);
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	
	@Override
	public boolean reciveIDValid(int id){
			try {
				String query = "SELECT * FROM tr_restock WHERE restock_id='"+id+"' AND receive IS NULL";
				ResultSet rs = db.executeQuery(query);
				while(rs.next()){
					return true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			return false;
	}
}
