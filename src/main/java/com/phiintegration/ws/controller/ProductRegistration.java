package com.phiintegration.ws.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.phiintegration.ws.model.DBCon;
import com.phiintegration.ws.model.msProduct;

public class ProductRegistration implements ProductRegistrationInterface {
	DBCon db;
	public ProductRegistration() throws SQLException{
			db = new DBCon();
	}

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.model.OrderingInterface#addProduct(com.phiintegration.ws.model.ms_product)
	 */
	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.ProductRegistrationInterface#addProduct(com.phiintegration.ws.model.msProduct)
	 */
	@Override
	public int addProduct(msProduct p){
		try{
			
			if(db.executeQuery("Select partner_id from ms_partner where partner_id = "+p.getPartner_seller_id()).next()){
				String query = "insert into ms_product"
						+ " (partner_seller_id, product_external_id, product_name, product_description, product_price, product_unit,"
						+ "is_active, how_to_order) values ("+p.getPartner_seller_id()+",'"+p.getProduct_external_id()+"','"+p.getProduct_name()+"','"
						+ p.getProduct_description() +"',"+p.getProduct_price()+",'"+p.getProduct_unit()+"',"+p.isActive()+", '"+p.getHow_to_order()+"')";
				int id = db.executeInsert(query);
				return id;
			}else{
				return -1;
			}
		}catch(Exception e){
			return -1;
		}		
	}

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.model.OrderingInterface#updateProduct(com.phiintegration.ws.model.ms_product)
	 */
	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.ProductRegistrationInterface#updateProduct(com.phiintegration.ws.model.msProduct)
	 */
	@Override
	public boolean updateProduct(msProduct p){
		if(p.isActive() == 0) return false;
		try{
			if(db.executeQuery("Select partner_id from ms_partner where partner_id = "+p.getPartner_seller_id()).next()){
				String query = "UPDATE ms_product SET partner_seller_id = "+p.getPartner_seller_id()+", product_external_id = '"+p.getProduct_external_id()+"',"
						+ "product_name = '"+p.getProduct_name()+"', product_description = '"+ p.getProduct_description()+"', product_price="+p.getProduct_price()+","
						+ "product_unit = '"+p.getProduct_unit()+"' , is_active = "+p.isActive()+", how_to_order ='"+p.getHow_to_order()+"' "
						+ "WHERE product_id = "+p.getProduct_id();
				System.out.println(query);
				db.executeUpdate(query);
			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.model.OrderingInterface#inactivateProduct(com.phiintegration.ws.model.ms_product)
	 */
	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.ProductRegistrationInterface#inactivateProduct(com.phiintegration.ws.model.msProduct)
	 */
	@Override
	public boolean inactivateProduct(msProduct p){
		try{
			db.executeUpdate("UPDATE ms_product SET is_active = 0 "
					+ "WHERE product_id = "+p.getProduct_id());
		}catch(Exception e){
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.model.OrderingInterface#activateProduct(com.phiintegration.ws.model.ms_product)
	 */
	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.ProductRegistrationInterface#activateProduct(com.phiintegration.ws.model.msProduct)
	 */
	@Override
	public boolean activateProduct(msProduct p){
		try{
			db.executeUpdate("UPDATE ms_product SET is_active = 1 "
					+ "WHERE product_id = "+p.getProduct_id());
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.ProductRegistrationInterface#getProduct(int)
	 */
	@Override
	public msProduct getProduct(int id, int partnerID){
		msProduct p = new msProduct();
		try {
			db = new DBCon();
			ResultSet Rs = db.executeQuery("Select * From ms_product where product_id = "+id+" AND is_active='1' AND partner_seller_id='"+partnerID+"'");
			while(Rs.next()){
				p.setProduct_id(Rs.getInt("product_id"));
				p.setPartner_seller_id(Rs.getInt("partner_seller_id"));
				p.setProduct_external_id(Rs.getString("product_external_id"));
				p.setProduct_name(Rs.getString("product_name"));
				p.setProduct_description(Rs.getString("product_description"));
				p.setProduct_price(Rs.getInt("product_price"));
				p.setProduct_unit(Rs.getString("product_unit"));
				p.setActive(Rs.getInt("is_active"));
				p.setHow_to_order(Rs.getString("how_to_order"));
				return p;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public msProduct getProductInactived(int id, int partnerID){
		msProduct p = new msProduct();
		try {
			db = new DBCon();
			ResultSet Rs = db.executeQuery("Select * From ms_product where product_id = "+id+" AND is_active='0' AND partner_seller_id='"+partnerID+"'");
			while(Rs.next()){
				p.setProduct_id(Rs.getInt("product_id"));
				p.setPartner_seller_id(Rs.getInt("partner_seller_id"));
				p.setProduct_external_id(Rs.getString("product_external_id"));
				p.setProduct_name(Rs.getString("product_name"));
				p.setProduct_description(Rs.getString("product_description"));
				p.setProduct_price(Rs.getInt("product_price"));
				p.setProduct_unit(Rs.getString("product_unit"));
				p.setActive(Rs.getInt("is_active"));
				p.setHow_to_order(Rs.getString("how_to_order"));
				return p;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Override
	public ArrayList<String> getProducts(int i){
		ArrayList<String> Product=new ArrayList<String>();
		try {
			db = new DBCon();
			ResultSet Rs = db.executeQuery("Select * From ms_product where partner_seller_id = " + i);
			while(Rs.next()){
				
				Product.add(Rs.getString("product_name"));
				
				
			}
			//return Product;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Product;
		
		
	}
	
	@Override
	public ArrayList<String> getProductsActive(int i){
		ArrayList<String> Product = new ArrayList<String>();
		try {
			db = new DBCon();
			ResultSet Rs = db.executeQuery("Select * From ms_product where is_active = 1 and partner_seller_id = " + i);
			while(Rs.next()){
				
				Product.add(Rs.getString("product_name"));
				
				
			}
			//return Product;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Product;
		
		
	}
	
	@Override
	public ArrayList<String> getProductsInactivate(int i){
		ArrayList<String> Product=new ArrayList<String>();
		try {
			db = new DBCon();
			ResultSet Rs = db.executeQuery("Select * From ms_product where is_active = 0 and partner_seller_id = " + i );
			while(Rs.next()){
				
				Product.add(Rs.getString("product_name"));
				
				
			}
			//return Product;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Product;
		
		
	}
	
	@Override
	public msProduct getProductByName(String name, int partnerID){
		msProduct p = new msProduct();
		try {
			db = new DBCon();
			ResultSet Rs = db.executeQuery("Select * From ms_product where product_name = '"+name+"' AND is_active='1' AND partner_seller_id='"+partnerID+"'");
			while(Rs.next()){
				p.setProduct_id(Rs.getInt("product_id"));
				p.setPartner_seller_id(Rs.getInt("partner_seller_id"));
				p.setProduct_external_id(Rs.getString("product_external_id"));
				p.setProduct_name(Rs.getString("product_name"));
				p.setProduct_description(Rs.getString("product_description"));
				p.setProduct_price(Rs.getInt("product_price"));
				p.setProduct_unit(Rs.getString("product_unit"));
				p.setActive(Rs.getInt("is_active"));
				p.setHow_to_order(Rs.getString("how_to_order"));
				return p;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Override
	public msProduct getProductByNameIncativate(String name, int partnerID){
		msProduct p = new msProduct();
		try {
			db = new DBCon();
			ResultSet Rs = db.executeQuery("Select * From ms_product where product_name = '"+name+"' AND is_active='0' AND partner_seller_id='"+partnerID+"'");
			while(Rs.next()){
				p.setProduct_id(Rs.getInt("product_id"));
				p.setPartner_seller_id(Rs.getInt("partner_seller_id"));
				p.setProduct_external_id(Rs.getString("product_external_id"));
				p.setProduct_name(Rs.getString("product_name"));
				p.setProduct_description(Rs.getString("product_description"));
				p.setProduct_price(Rs.getInt("product_price"));
				p.setProduct_unit(Rs.getString("product_unit"));
				p.setActive(Rs.getInt("is_active"));
				p.setHow_to_order(Rs.getString("how_to_order"));
				return p;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
