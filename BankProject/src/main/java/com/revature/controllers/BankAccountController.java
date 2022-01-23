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
		
		app.get("/bankAccounts/{username}", getAccountDetails);
		app.get("/bankAccounts/{account}", getBankAccountDetails);
	}

	
	public Handler getAccountDetails = ctx -> {
		
		try {
		BankAccount controllerUser = bankDAO.getAccountDetails(ctx.pathParam("username"));
		
		ctx.json(controllerUser);
		
		ctx.status(200);
		
		} catch (Exception e){
			
			e.printStackTrace();
		}
	};
	
	public Handler getBankAccountDetails = ctx -> {
		
		try {
			
		int account = 0;
			
		BankAccount controllerUser = bankDAO.getBankAccountDetails(account = Integer.parseInt(ctx.pathParam("account")));
		
		ctx.json(controllerUser);
		
		ctx.status(200);
		
		} catch (Exception e) {
			
			e.printStackTrace();

		}
	};
}

	

