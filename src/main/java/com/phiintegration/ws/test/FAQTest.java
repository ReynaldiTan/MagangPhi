package com.phiintegration.ws.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.phiintegration.ws.controller.FAQInterface;
import com.phiintegration.ws.controller.FAQSQLServer;
import com.phiintegration.ws.model.QuestionAnswer;

public class FAQTest {
	QuestionAnswer qa = new QuestionAnswer(0,1,"Description",1);
	QuestionAnswer qa2 = new QuestionAnswer(1,1,"Description2",2);
	QuestionAnswer qa3 = new QuestionAnswer(1,1,"Description2",2);
	
	@Test
	public void test1() {
		FAQInterface obj;
		try {
			obj = new FAQSQLServer();
			int kembalian = obj.newQuestionAnswer(qa);
			Pattern p = Pattern.compile("[0-9]+");
			Matcher m = p.matcher(""+kembalian);
			boolean b = m.matches();
			assertEquals(b, true);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		FAQInterface obj;
		try {
			obj = new FAQSQLServer();
			boolean b = obj.updateQuestionAnswer(qa2);
			assertEquals(b, true);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3() {
		FAQInterface obj;
		try {
			obj = new FAQSQLServer();
			int kembalian = obj.newQuestionAnswer(qa3);
			qa3.setQuestion_id(kembalian);
			boolean b = obj.deleteQuestionAnswer(qa3);
			assertEquals(b, true);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
