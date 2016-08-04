package com.phiintegration.ws.controller;

import java.sql.SQLException;

import com.phiintegration.ws.model.DBCon;
import com.phiintegration.ws.model.QuestionAnswer;

public class FAQSQLServer implements FAQInterface {
	DBCon db;
	
	public FAQSQLServer() throws SQLException{
		db = new DBCon();
	}

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.FAQInterface#newQuestionAnswer(com.phiintegration.ws.model.QuestionAnswer)
	 */
	@Override
	public int newQuestionAnswer(QuestionAnswer qa){
		try{
			int id = db.executeInsert("insert into tr_q_a"
					+ "(partner_id, question_description, line_order)"
					+ " values ("+qa.getPartner_id()+",'"+qa.getQuestion_description()+"',"+qa.getLine_order()+")");
			return id;
		}catch(Exception e){
			return -1;
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.FAQInterface#updateQuestionAnswer(com.phiintegration.ws.model.QuestionAnswer)
	 */
	@Override
	public boolean updateQuestionAnswer(QuestionAnswer qa){
		try{
			db.executeUpdate("UPDATE tr_q_a SET partner_id = "+qa.getPartner_id()+", "
					+" question_description = '"+qa.getQuestion_description()+"',"
					+ " line_order = "+qa.getLine_order()
					+ " WHERE question_id="+qa.getQuestion_id());
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.phiintegration.ws.controller.FAQInterface#deleteQuestionAnswer(com.phiintegration.ws.model.QuestionAnswer)
	 */
	@Override
	public boolean deleteQuestionAnswer (QuestionAnswer qa){
		try{
			db.executeUpdate("DELETE FROM tr_q_a WHERE question_id="+qa.getQuestion_id());
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	

}
