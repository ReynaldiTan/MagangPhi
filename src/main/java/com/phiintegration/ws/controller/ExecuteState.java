package com.phiintegration.ws.controller;

import java.sql.SQLException;

import org.json.JSONException;
import org.springframework.cglib.core.internal.Function;

import com.phiintegration.ws.model.msUserState;
import com.phiintegration.ws.model.stagingInput;

public class ExecuteState {
	public String doState(msUserState user,stagingInput input) throws JSONException{
		String response = "";
		try {
			String UserState=user.getState();
			String StateNum=String.valueOf(user.getStateNum());

			switch(UserState){
			case "order": 
				OrderFlow doFlow;
				doFlow = new OrderFlow();
				switch(StateNum){
							case "1": 
								//validasi user dan menampilkan seller list
								response = doFlow.OrderFirstFlow(user, input);
									  break;
							case "2": 
								//validasi seller yang dipilih, ambil id, insert header
								response = doFlow.OrderHeaderFlow(user, input);
							  		  break;
							case "3": 
								//validasi product name, masukin ke staging
								response = doFlow.OrderNameFlow(user, input);
					  		  	 	  break;
							case "4": 
								//validasi product quantity, insert detail
								response = doFlow.OrderQuantityFlow(user, input);
					  		  		  break;
							case "5": 
								//hanya buat bertanya confirm 
								response = doFlow.confirmOrderFlow(user, input);
					  		  		  break;
							case "6": 
								//pindah ke state 0 dan isconfirmed = 1
								response = doFlow.closeOrderFlow(user, input);
					  		  		  break;
							case "0": 
								//cancel
								response = doFlow.deleteOrderFlow(user, input);
					  		  		  break;
						} 
				break;
			case "restock": 
				RestockFlow rFlow;
				rFlow = new RestockFlow();
				switch(StateNum){
							case "1": 
								//validasi user dan menampilkan seller list
								response = rFlow.RestockFirstFlow(user, input);
									  break;
							case "2": 
								//validasi product name, masukin ke staging
								response = rFlow.RestockProductFlow(user, input);
					  		  	 	  break;
							case "3": 
								//construct insert
								response = rFlow.RestockQuantityFlow(user, input);
					  		  		  break;
							case "4": 
								//hanya buat bertanya confirm 
								response = rFlow.doneRestockFlow(user, input);
					  		  		  break;
							case "0": 
								//cancel
								response = rFlow.cancelRestockFlow(user, input);
					  		  		  break;
						} 
				break;
			case "recieve": 
				RecieveStockFlow rsFlow;
				rsFlow = new RecieveStockFlow();
				switch(StateNum){
							case "1": 
								response = rsFlow.RecieveFirstFlow(user, input);
									  break;
							case "2": 
								response = rsFlow.RecieveGetIDFlow(user, input);
							  		  break;
							case "3": 
								response = rsFlow.RecieveGetDateFlow(user, input);
					  		  	 	  break;
							case "0": 
								//cancel
								response = rsFlow.RecieveCancelFlow(user, input);
					  		  		  break;
						} 
				break;
			case "produk": 
				ProdukFlow pFlow = new ProdukFlow();
				switch(StateNum){
				case "1": response = pFlow.ProdukFirstFlow(user, input);
						  break;
				case "2": response = pFlow.ProdukGetExIDFlow(user, input);
				  		  break;					
				case "3": response = pFlow.ProdukGetNamaFlow(user, input);
			  		  	  break;	
				case "4": response = pFlow.ProdukGetDescriptionFlow(user, input);
		  		  		  break;
				case "5": response = pFlow.ProdukGetPriceFlow(user, input);
		  		  		  break;
				case "6": response = pFlow.ProdukGetUnitFlow(user, input);
		  		  		  break;
				case "7": response = pFlow.ProdukGetHowToOrderFlow(user, input);
		  		  		  break;
				case "8": response = pFlow.ProdukGetConfirmationFlow(user, input);
		  		  		  break;
				case "0": response = pFlow.deleteProductFlow(user, input);
				  		  break;
			}break;
			case "partner" : 
				PartnerFlow paFlow = new PartnerFlow();
				switch(StateNum){
				case "1": response = paFlow.PartnerFirstFlow(user, input);
						  break;
				case "2": response = paFlow.PartnerGetNamaFlow(user, input);
				  		  break;					
				case "3": response = paFlow.PartnerGetAlamatFlow(user, input);
		  		  		  break;		  
				case "4": response = paFlow.PartnerGetEmailFlow(user, input);
				  		  break;					
				case "5": response = paFlow.PartnerConfirmationFlow(user, input);
				  		  break;		  
				case "0": response = paFlow.PartnerCancelFlow(user, input);
				  		  break;
			}break;
			case "activate" : 
				activatedFlow acFlow = new activatedFlow();
				switch(StateNum){
				case "1": response = acFlow.ActivatedFirstFlow(user, input);
						  break;
				case "2": response = acFlow.ActiveProductFlow(user, input);
				  		  break;
				case "3": response = acFlow.ActivateGetConfirmationFlow(user, input);
		  		  		  break;
				case "0": response = acFlow.cancelActiveFlow(user, input);
				  		  break;
			}break;
			
			case "inactivate" : 
				inactivateFlow inacFlow = new inactivateFlow();
				switch(StateNum){
				case "1": response = inacFlow.InactivateFirstFlow(user, input);
						  break;
				case "2": response = inacFlow.InactiveProductFlow(user, input);
				  		  break;
				case "3": response = inacFlow.InactivateGetConfirmationFlow(user, input);
		  		  		  break;
				case "0": response = inacFlow.cancelInactiveFlow(user, input);
				  		  break;
			}break;
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
		
	}
}
