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
			
			String JSONUsers = gson.toJson(status);
			
			ctx.result(JSONUsers);
			
			ctx.status(200);	
		} else {
				
			ctx.result("you haven't logged in yet!");
			ctx.status(406);
				
		}

	};
}
