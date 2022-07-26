package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.RoleDAO;
import com.revature.models.Role;

import io.javalin.http.Handler;

public class RoleController {

	RoleDAO rDAO = new RoleDAO();
	
	public Handler insertRoleHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		Role newRole = gson.fromJson(body, Role.class);
		
		if (rDAO.insertRole(newRole)) {
			
			ctx.status(202);
			
		} else {
			
			ctx.status(406);
			
		}
		
	};
	
	
	
}
