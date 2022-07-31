package com.revature.controllers;

import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.AuthService;

import io.javalin.http.Handler;

public class AuthController {

	AuthService as = new AuthService();
	
	public static HttpSession ses;
	
	
	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		LoginDTO lDTO = gson.fromJson(body, LoginDTO.class);
		
		User user = as.login(lDTO.getUsername(), lDTO.getPassword());
		
		if (user != null) {
			
//			System.out.println(ctx.req);
			
			ses = ctx.req.getSession();
			
//			System.out.println(ses);
			
			ses.setAttribute("userId", user.getUser_id());
			ses.setAttribute("userRole", user.getRole().getRole_id());
		    
			String userJson = gson.toJson(user);
			
			ctx.result(userJson);
			ctx.status(202);

		} else {
			
			ctx.result("User Failed to login!");
			ctx.status(401);
		}
		
	};
	
	public Handler logoutHandler = (ctx) -> {
		
		ses = ctx.req.getSession();
		
		if (ses != null) {
			
			ses = ctx.req.getSession(false);
		
			ctx.status(202);
		} else {
			
			ctx.status(401);
		}
		
	};
}
