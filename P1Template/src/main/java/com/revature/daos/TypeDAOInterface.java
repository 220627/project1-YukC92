package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Type;

public interface TypeDAOInterface {

	boolean insertType(Type type);
	
	ArrayList<Type> getTypes();
	
	Type getTypeById(int id);
	
	
}
