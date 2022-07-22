package com.revature;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.Test;

import com.revature.utils.ConnectionUtil;

public class TestClass {

	@Test
	public void testGetConnection() throws SQLException {
		
		assertNotNull(ConnectionUtil.getConnection());
		
	}
	
	@Test
	public void testInvalidConnectionCredentials() throws SQLException{
		
		
	}
	
	//If our Mockito lesson has to be moved, basic tests are fine. assertTrue/False, assertNull/NotNull, etc.
	
}
