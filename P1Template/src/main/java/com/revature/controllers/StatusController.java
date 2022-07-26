package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.daos.StatusDAO;
import com.revature.models.Status;

import io.javalin.http.Handler;

public class StatusController {

	StatusDAO sDAO = new StatusDAO();
	
	public Handler getStatusHandler = (ctx) -> {
		
		if (AuthController.ses != null) {
			
			ArrayList<Status> status = sDAO.getStatus();
			
			Gson gson = new Gson();
			
			String JSONStatus = gson.toJson(status);
			
			ctx.result(JSONStatus);
			
			ctx.status(200);
			
		} else {
			
			ctx.result("You haven't logged in yet!");
			ctx.status(401);
			
		}
		
		
	};
	
	
}
