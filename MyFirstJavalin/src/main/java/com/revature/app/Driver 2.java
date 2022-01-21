package com.revature.app;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class Driver {

	public static void main(String[] args) {
		
		// creates application, sets up Javalin, reserves a port
		Javalin app = Javalin.create().start(7070);
		
		// in order to access the request and build a response 
		// use static variable ctx in Javalin, stands for context

		
		// every URL endpoint and HTTP verb requires a handler
		// handlers can be defined in one line like below
		app.get("/hello", ctx -> {
			// the syntax above is called a "lambda" or an anonymous method
			// (a method without a name) passed as a parameter
			// code to execute when someone accesses "site.com/users"
			
			// ctx.result returns a String in the response body
			ctx.result("Hello World!");
		});
		
		// access the above behavior at localhost:7070/hello
		
		// if we want to separate the behavior from the path,
		// we use handler variables to store lambda variables
		app.get("/user/{id}", getUserById);
		// when this is called, it will access the below code
		// the {id} syntax represents a path parameter called id
		// it can be accessed using ctx
	}
	
	public static Handler getUserById = ctx -> {
		
		//JDBC code for looking up a user
		// can get the path parameter using ctx like so
		ctx.result("You entered the id: " + ctx.pathParam("id"));
	};

}
