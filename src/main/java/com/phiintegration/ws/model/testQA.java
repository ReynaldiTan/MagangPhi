package com.phiintegration.ws.model;

public class testQA {
	public static void main(String[] args) {
		msQuestion qa = new msQuestion();
		String user = "Feris";
		String pesan = "apa kbr";
		qa.addPattern("apa ka?ba?r");
		qa.addPattern("hello");
		qa.addPattern("[Hh]a?i+");
		qa.addPattern("hallo");
		qa.addPattern("Alo");
		
		qa.setResponse(pesan+" juga "+user+". Apa yang bisa kami bantu?");
		
		if(qa.checkPattern(pesan)) System.out.println(qa.getResponse());
		
	}
}
