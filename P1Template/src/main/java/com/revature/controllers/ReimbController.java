package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.daos.ReimbursementDAO;
import com.revature.models.Reimbursement;

import io.javalin.http.Handler;

public class ReimbController {

	ReimbursementDAO reDAO = new ReimbursementDAO();
	
	public Handler insertReimbursementHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		Reimbursement newReimb = gson.fromJson(body, Reimbursement.class);
		
		if (reDAO.insertReimbursement(newReimb)) {
			
			ctx.status(202);
			
		} else {
			
			ctx.status(406);
			
		}
		
	};
	
	public Handler getReimbusementsHandler = (ctx) -> {
		
		if (AuthController.ses != null) {
			
			Object userRole = AuthController.ses.getAttribute("userRole");
			Object userId = AuthController.ses.getAttribute("userId");
			
//			System.out.println(userRole);
//			System.out.println(userId);
			
			if (userRole.equals(1)) {
				
				System.out.println("manager");
				
				ArrayList<Reimbursement> reimbursements = reDAO.getAllReimbursements();
				
				Gson gson = new Gson();
				
				String JSONReimb = gson.toJson(reimbursements);
				
				ctx.result(JSONReimb);
				
				ctx.status(202);

			} else {
				
				System.out.println("employee");
				
				Integer author = Integer.parseInt(userId.toString());
				
				ArrayList<Reimbursement> auth_reimb = reDAO.getReimbursementsByAuthor(author);
				
				Gson gson = new Gson();
				
				String JSONAuthReimb = gson.toJson(auth_reimb);
				
				ctx.result(JSONAuthReimb);
				
				if (reDAO.getReimbursementsByAuthor(author) != null) {
					
					ctx.status(202);
				
				} else {
					
					ctx.status(406);
				
				}
				
			}		
			
				
		} else {
			
			ctx.status(406);
			
		}
		
	
	
	};
	
	public Handler deleteReimbursementHandler = (ctx) -> {
		
		Integer id = Integer.parseInt(ctx.pathParam("reimb_id"));
		
		if (reDAO.deleteReimbursement(id)) {
			
			ctx.status(202);
			
		} else {
			System.out.println(ctx);
			ctx.status(406);
			
		}
		
	};
	
//	public Handler getReimbursementsByAuthorHandler = (ctx) -> {
//		
//		System.out.println(ctx);
//		
//		Integer author = Integer.parseInt(ctx.pathParam("user_id"));
//		
//		ArrayList<Reimbursement> auth_reimb = reDAO.getReimbursementsByAuthor(author);
//		
//		Gson gson = new Gson();
//		
//		String JSONAuthReimb = gson.toJson(auth_reimb);
//		
//		ctx.result(JSONAuthReimb);
//		
//		if (reDAO.getReimbursementsByAuthor(author) != null) {
//			
//			ctx.status(202);
//		
//		} else {
//			
//			ctx.status(406);
//			
//		}
//		
//	
//	
//	};
	
	public Handler approveReimbursementHandler = (ctx) -> {
		
		if (AuthController.ses != null) {
				
			Object userRole = AuthController.ses.getAttribute("userRole");
			
			if (userRole.equals(1)) {
			
				String body = ctx.body();
				
				Gson gson = new Gson();
				
				Reimbursement appReimb = gson.fromJson(body, Reimbursement.class);
				
				if (reDAO.approveReimbursement(appReimb)) {
					
					ctx.status(202);
					
				} else {
					
					ctx.status(406);
					
				}
				
			}
			
		} else {
			
			ctx.status(403);
		}

		
	};
	
	public Handler denyReimbursementHandler = (ctx) -> {
		
		if (AuthController.ses != null) {
			
			Object userRole = AuthController.ses.getAttribute("userRole");
			
			if (userRole.equals(1)) {
			
				String body = ctx.body();
				
				Gson gson = new Gson();
				
				Reimbursement denyReimb = gson.fromJson(body, Reimbursement.class);
				
				if (reDAO.denyReimbursement(denyReimb)) {
					
					ctx.status(202);
					
				} else {
					
					ctx.status(406);
					
				}
				
			}
			
		} else {
			
			ctx.status(403);
		}

		
	};
	
}

