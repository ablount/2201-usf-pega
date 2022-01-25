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

	}
	
	public Handler createUserAccount = ctx -> {
		
		UserAccount createdUser = ctx.bodyAsClass(UserAccount.class);
		
		if (userDAO.createUserAccount(createdUser))
			
			ctx.status(201); 
		
		else ctx.status(400);
	};
	
	public Handler getUserByUsername = ctx -> {
		
		UserAccount gottenUser = userDAO.getUserByUsername(ctx.pathParam("username"));
		
		ctx.json(gottenUser);
		
		ctx.status(200);
	};
	
	public Handler updateUserAccountType = ctx -> {
		
		boolean updatedUser = userDAO.updateUserAccountType(ctx.pathParam("username"), ctx.pathParam("accountType"));
		
		ctx.json(updatedUser);
			
			ctx.status(204);
		
	};
	
	public Handler deleteUserAccount = ctx -> {
		
		boolean deletedUser = userDAO.deleteUserAccount(ctx.pathParam("username"));
		
		ctx.json(deletedUser);
		
			ctx.status(204);
			
	
	};

}
