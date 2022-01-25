package com.revature.controllers;

import java.sql.Connection;


import com.revature.accounts.BankAccount;
import com.revature.dao.BankAccountDAO;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class BankAccountController {
	
	Javalin app;
	Connection connection;
	BankAccountDAO bankDAO;
	
	public BankAccountController(Javalin app, Connection connection) {
		this.app = app;
		this.connection = connection;
		bankDAO = new BankAccountDAO();
		
		// get is just for getting info, the URL is whatever you want it to be, anything in curly braces is what you're calling
		//	parameter the that will be taken from the URL that's typed into the browser
		// the light blue is whatever you want to call your method you'll build in your DAO 
		app.get("/bankAccounts/{username}", getAccountDetails);
		app.get("/bankAccounts/{account}", getBankAccountDetails);
		app.put("/bankAccounts/deposit/{username}/{deposit}", onlineDeposit);
		app.put("/bankAccounts/withdraw/{username}/{withdraw}", onlineWithdraw);
	}
	
	public Handler getAccountDetails = ctx -> {
		// getAccountDetails is what I'm calling this method/what I'll call it in my DAO
		
		try {
		BankAccount gottenAccount = bankDAO.getAccountDetails(ctx.pathParam("username"));
		// the dark blue is what I want to show in the browser (I want to show the details of a bank account)
		// the yellow is a random name I chose
		// light blue is the instance of the DAO I named at the beginning of this class
		// green is the name of the method I'm going to make in my DAO
		// "username" is the parameter I specified above that will come from the URL someone types in their browser
		
		ctx.json(gottenAccount);
		
		ctx.status(200);
		
		} catch (Exception e){
			
			e.printStackTrace();
		}
	};
	
	public Handler getBankAccountDetails = ctx -> {
		
		try {
			
		int account = 0;
			
		BankAccount gottenAccount = bankDAO.getBankAccountDetails(account = Integer.parseInt(ctx.pathParam("account")));
		
		ctx.json(gottenAccount);
		
		ctx.status(200);
		
		} catch (Exception e) {
			
			e.printStackTrace();

		}
	};
	
	public Handler onlineDeposit = ctx -> {
		
		int deposit = 0;
		
		boolean didDeposit = bankDAO.onlineDeposit(ctx.pathParam("username"), (deposit = Integer.parseInt(ctx.pathParam("deposit"))));
		
		ctx.json(didDeposit);
			
			ctx.status(204);
		
	};
	
	public Handler onlineWithdraw = ctx -> {
		
		int withdraw = 0;
		
		boolean didWithdraw = bankDAO.onlineWithdraw(ctx.pathParam("username"), (withdraw = Integer.parseInt(ctx.pathParam("withdraw"))));
		
		ctx.json(didWithdraw);
			
			ctx.status(204);
		
	};
}

	

