package com.revature.daos;

import com.revature.models.User;

public interface UserDAOInterface {

	boolean insertUser(User user);
	
	User getUserById(int id);
	
	
}
