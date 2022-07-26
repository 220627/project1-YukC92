package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ReimbursementDAOInterface {

	boolean insertReimbursement(Reimbursement reimbursement);
	
	ArrayList<Reimbursement> getAllReimbursements();
	
	boolean deleteReimbursement(int reimb_id);
	
	ArrayList<Reimbursement> getReimbursementsByAuthor();
	
	ArrayList<Reimbursement> getReimbursementsByResolver();
	
	boolean updateReimbursementStatus(Reimbursement reimbursement);
	
}
