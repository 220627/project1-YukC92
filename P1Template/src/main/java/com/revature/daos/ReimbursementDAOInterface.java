package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Reimbursement;

public interface ReimbursementDAOInterface {

	boolean insertReimbursement(Reimbursement reimbursement);
	
	ArrayList<Reimbursement> getAllReimbursements();
	
	boolean deleteReimbursement(int reimb_id);
	
	ArrayList<Reimbursement> getReimbursementsByAuthor();
	
	boolean approveReimbursement(Reimbursement reimbursement);
	
	boolean denyReimbursement(Reimbursement reimbursement);
	
}
