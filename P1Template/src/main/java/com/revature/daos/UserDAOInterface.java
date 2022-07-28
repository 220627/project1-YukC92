package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.User;

public interface UserDAOInterface {

	boolean insertUser(User user);
	
	User getUserById(int id);
	
	ArrayList<User> getAllUsers();
	
}
