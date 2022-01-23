package com.revature.driver;

import java.sql.Connection;

import com.revature.controllers.BankAccountController;
import com.revature.controllers.UserAccountController;
import com.revature.dao.ConnectionManager;

import io.javalin.Javalin;

public class Console {

	public static void main(String[] args) {
		
		Javalin app = Javalin.create().start(7070);
		Connection connection = ConnectionManager.getConnection();
		UserAccountController controller = new UserAccountController(app, connection);
		BankAccountController controller2 = new BankAccountController(app, connection);

				
		while (true){
		
			Menu.welcomeMenu();
			System.out.println();
			System.out.println("__________________________________");
			System.out.println();
		}
		

	}

}
