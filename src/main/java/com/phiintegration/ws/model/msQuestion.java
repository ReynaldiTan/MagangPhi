package com.phiintegration.ws.model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class msQuestion {
	private String question;
	private ArrayList<String> PatternList = new ArrayList<String>();
	private String response;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public ArrayList<String> getPattern() {
		return PatternList;
	}
	public void setPattern(ArrayList<String> pattern) {
		PatternList = pattern;
	}
	
	public void addPattern(String pat){
		PatternList.add(pat);
	}
	
	public void removePattern(String pat){
		PatternList.remove(pat);
	}
	
	public boolean checkPattern(String pat){
		
		for(int i = 0; i < PatternList.size(); i++){
			Pattern r = Pattern.compile(PatternList.get(i));
			Matcher m = r.matcher(pat);
			if(m.find()) return true;
				
		}
		return false;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
}
