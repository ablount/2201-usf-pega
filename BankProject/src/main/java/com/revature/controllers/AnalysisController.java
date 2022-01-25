package com.revature.controllers;

import java.sql.Connection;

import com.revature.accounts.UserAccount;
import com.revature.dao.AnalysisDAO;

import io.javalin.Javalin;
import io.javalin.http.Handler;


public class AnalysisController {

	Javalin app;
	Connection connection;
	AnalysisDAO analysisDAO;
		
	public AnalysisController(Javalin app, Connection connection) {
		
			this.app = app;
			this.connection = connection;
			analysisDAO = new AnalysisDAO();
			
			app.get("/analysis/openaccounts", countOpenAccounts);
			app.get("/analysis/pendingaccounts", countPendingAccounts);
			app.get("/analysis/typeofaccounts/{accountType}", countAccountTypes);
			

			
		}
		
	public Handler countAccountTypes = ctx -> {
		
		try {
			
		int account = 0;
			
		int numberOfAccounts = analysisDAO.countAccountTypes(account = Integer.parseInt(ctx.pathParam("accountType")));
			
			ctx.json(numberOfAccounts);
			
			ctx.status(200);
			
		} catch (Exception e) {
				
			e.printStackTrace();

		}
	};
	
	public Handler countOpenAccounts = ctx -> {
		
		int openAccounts = analysisDAO.countOpenAccounts();
		
		ctx.json(openAccounts);
			
			ctx.status(201); 
		
	};
	
	public Handler countPendingAccounts = ctx -> {
		
		int pendingAccounts = analysisDAO.countPendingAccounts();
		
		ctx.json(pendingAccounts);
			
			ctx.status(201); 
		
	};
}
