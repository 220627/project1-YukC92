package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.UserDAO;
import com.revature.models.User;

import io.javalin.http.Handler;

public class UserController {

	UserDAO uDAO = new UserDAO();
	
	public Handler insertUserHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		User newUser = gson.fromJson(body, User.class);
		
		if (uDAO.insertUser(newUser)) {
			
			ctx.status(202);
			
		} else {
			
			ctx.status(406);
			
		}
		
	};
	
}
