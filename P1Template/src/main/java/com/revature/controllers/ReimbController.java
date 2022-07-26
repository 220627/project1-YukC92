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
		
			ArrayList<Reimbursement> reimbursements = reDAO.getAllReimbursements();
			
			Gson gson = new Gson();
			
			String JSONReimb = gson.toJson(reimbursements);
			
			ctx.result(JSONReimb);
		
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
		
		if (AuthController.ses != null) {
		
			ArrayList<Reimbursement> auth_reimb = reDAO.getReimbursementsByAuthor();
			
			Gson gson = new Gson();
			
			String JSONAuthReimb = gson.toJson(auth_reimb);
			
			ctx.result(JSONAuthReimb);
		
			ctx.status(202);
		
		} else {
			
			ctx.status(401);
			
		}
		
	
	
	};
	
	public Handler getReimbusementsByResolverHandler = (ctx) -> {
		
		if (AuthController.ses != null) {
		
			ArrayList<Reimbursement> reso_reimb = reDAO.getReimbursementsByResolver();
			
			Gson gson = new Gson();
			
			String JSONResolverReimb = gson.toJson(reso_reimb);
			
			ctx.result(JSONResolverReimb);
		
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
//	boolean deleteReimbursement(int reimb_id);
//	
//	ArrayList<Reimbursement> getReimbursementsByAuthor();
//	
//	ArrayList<Reimbursement> getReimbursementsByResolver();
//	
//	boolean updateReimbursementStatus(Reimbursement reimbursement);
//	
}
