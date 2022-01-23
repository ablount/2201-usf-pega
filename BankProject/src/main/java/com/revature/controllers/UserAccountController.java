package com.revature.controllers;

import java.sql.Connection;

import com.revature.accounts.BankAccount;
import com.revature.accounts.UserAccount;
import com.revature.dao.UserAccountDAO;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class UserAccountController {
	
	Javalin app;
	Connection connection;
	UserAccountDAO userDAO;
	
	public UserAccountController(Javalin app, Connection connection) {
		this.app = app;
		this.connection = connection;
		userDAO = new UserAccountDAO();
		
		app.post("/userAccounts", createUserAccount);
		app.get("/userAccounts/{username}", getUserByUsername);
		app.put("/userAccounts/update/{username}/{accountType}", updateUserAccountType);
		app.delete("/userAccounts/delete/{username}", deleteUserAccount);
		app.get("/accountTypes/{accountType}", getAccountTypes);

	}
	
	public Handler createUserAccount = ctx -> {
		
		UserAccount controllerUser = ctx.bodyAsClass(UserAccount.class);
		
		if (userDAO.createUserAccount(controllerUser))
			
			ctx.status(201); 
		
		else ctx.status(400);
	};
	
	public Handler getUserByUsername = ctx -> {
		
		UserAccount controllerUser = userDAO.getUserByUsername(ctx.pathParam("username"));
		
		ctx.json(controllerUser);
		
		ctx.status(200);
	};
	
	public Handler updateUserAccountType = ctx -> {
		
		boolean controllerUser = userDAO.updateUserAccountType(ctx.pathParam("username"), ctx.pathParam("accountType"));
		
		ctx.json(controllerUser);
			
			ctx.status(204);
		
	};
	
	public Handler deleteUserAccount = ctx -> {
		
		boolean controllerUser = userDAO.deleteUserAccount(ctx.pathParam("username"));
		
		ctx.json(controllerUser);
		
			ctx.status(204);
	
	};
	
public Handler getAccountTypes = ctx -> {
		
		try {
			
		int account = 0;
			
		int controllerUser = userDAO.getAccountTypes(account = Integer.parseInt(ctx.pathParam("accountType")));
		
		ctx.json(controllerUser);
		
		ctx.status(200);
		
		} catch (Exception e) {
			
			e.printStackTrace();

		}
	};

}
