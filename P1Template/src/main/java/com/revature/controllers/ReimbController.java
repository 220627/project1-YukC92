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
	
	public Handler getReimbursementsByAuthorHandler = (ctx) -> {
		
		ArrayList<Reimbursement> auth_reimb = reDAO.getReimbursementsByAuthor();
		
		Gson gson = new Gson();
		
		String JSONAuthReimb = gson.toJson(auth_reimb);
		
		ctx.result(JSONAuthReimb);
		
		if (reDAO.getReimbursementsByAuthor() != null) {
			
			ctx.status(202);
		
		} else {
			
			ctx.status(406);
			
		}
		
	
	
	};
	
	public Handler approveReimbursementHandler = (ctx) -> {

		String body = ctx.body();
		
		Gson gson = new Gson();
		
		Reimbursement appReimb = gson.fromJson(body, Reimbursement.class);
		
		if (reDAO.approveReimbursement(appReimb)) {
			
			ctx.status(202);
			
		} else {
			
			ctx.status(406);
			
		}
		
	};
	
	public Handler denyReimbursementHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		Reimbursement denyReimb = gson.fromJson(body, Reimbursement.class);
		
		if (reDAO.denyReimbursement(denyReimb)) {
			
			ctx.status(202);
			
		} else {
			
			ctx.status(406);
			
		}
		
	};
	
}

