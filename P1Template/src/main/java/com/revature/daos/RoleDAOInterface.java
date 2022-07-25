package com.revature.daos;

import com.revature.models.Role;

public interface RoleDAOInterface {

	boolean insertRole(Role role);
	
	Role getRoleById(int id);
	
	
}
