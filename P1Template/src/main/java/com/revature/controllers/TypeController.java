package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.daos.TypeDAO;
import com.revature.models.Type;

import io.javalin.http.Handler;

public class TypeController {

	TypeDAO tDAO = new TypeDAO();
	
	public Handler insertTypeHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		Type newType = gson.fromJson(body, Type.class);
		
		if (tDAO.insertType(newType)) {
			
			ctx.status(202);
		
		} else {
			
			ctx.status(406);
			
		}
		
		
	};
	
	public Handler getTypeHandler = (ctx) -> {
		
		if (AuthController.ses != null) {
			
			ArrayList<Type> types = tDAO.getTypes();
			
			Gson gson = new Gson();
			
			String JSONTypes = gson.toJson(types);
			
			ctx.result(JSONTypes);
			
			ctx.status(200);

		} else {
			
			ctx.result("You haven't logged in yet!");
			ctx.status(401);
			
		}
		
	};
	
	
}
