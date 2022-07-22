package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Status;

public interface StatusDAOInterface {

	Status getStatusById(int id);
	
	ArrayList<Status> getStatus();
	
	
}
