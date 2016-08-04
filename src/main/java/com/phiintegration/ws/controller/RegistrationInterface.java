package com.phiintegration.ws.controller;

import java.util.ArrayList;

import org.json.JSONException;


import com.phiintegration.ws.model.*;


public interface RegistrationInterface {

	public abstract int insertPartner(msPartner objPartner, msEmail objEmail) throws JSONException;
	
	public abstract int InsertEmailPartner(msPartner objPartner, msEmail objEmail) throws JSONException;
	
	public abstract int InsertPhonePartner(msPartner objPartner, msPhone objPhone) throws JSONException;
	
	public abstract int insertGeographicLocation(msPartner objPartner, msGeographicLocation objLocation) throws JSONException;

	public abstract msPartner getObjPartner();

	public abstract void setObjPartner(msPartner objPartner);

	public abstract boolean loadEmail();

	public abstract int UpdatePartner(msPartner objPartner, msEmail objEmail) throws JSONException;
	
	public abstract int updateEmailPartner(msPartner objPartner, msEmail objEmail) throws JSONException;
	
	public abstract int updateGeographicLocation(msPartner objPartner, msGeographicLocation objLocation) throws JSONException;
	
	public abstract int UpdatePhonePartner(msPartner objPartner, msPhone objPhone) throws JSONException;
	
	public abstract int deactivatePartner(msPartner objPartner) throws JSONException;
	
	public abstract boolean checkPartnerAlias(String username);
	
	public abstract ArrayList<String> getPartnerList(String username);
	
	public abstract int getPartnerId(String username);
}