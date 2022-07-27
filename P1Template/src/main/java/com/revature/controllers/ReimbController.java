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
				
		ArrayList<Reimbursement> reimbursements = reDAO.getAllReimbursements();
		
		Gson gson = new Gson();
		
		String JSONReimb = gson.toJson(reimbursements);
		
		ctx.result(JSONReimb);
	
		if (reDAO.getAllReimbursements() != null) {
		
			ctx.status(202);
		
		} else {
			
			ctx.status(401);
			
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
	
	public Handler getReimbusementsByAuthorHandler = (ctx) -> {
		
		ArrayList<Reimbursement> auth_reimb = reDAO.getReimbursementsByAuthor();
		
		Gson gson = new Gson();
		
		String JSONAuthReimb = gson.toJson(auth_reimb);
		
		ctx.result(JSONAuthReimb);
		
		if (reDAO.getReimbursementsByAuthor() != null) {
			
			ctx.status(202);
		
		} else {
			
			ctx.status(401);
			
		}
		
	
	
	};
	
	public Handler getReimbusementsByResolverHandler = (ctx) -> {
		
		
		ArrayList<Reimbursement> reso_reimb = reDAO.getReimbursementsByResolver();
		
		Gson gson = new Gson();
		
		String JSONResolverReimb = gson.toJson(reso_reimb);
		
		ctx.result(JSONResolverReimb);
	
		if (reDAO.getReimbursementsByResolver() != null) {
			
			ctx.status(202);
		
		} else {
			
			ctx.status(401);
			
		}
		
	
	
	};
	
	public Handler updateReimbursementStatusHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		Reimbursement newReStatus = gson.fromJson(body, Reimbursement.class);
		
		if (reDAO.updateReimbursementStatus(newReStatus)) {
			
			ctx.status(202);
			
		} else {
			
			ctx.status(406);
			
		}
		
	};
	
}
