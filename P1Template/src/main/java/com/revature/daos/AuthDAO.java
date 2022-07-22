package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class AuthDAO {

	public User login(String username, String password) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "select * from ERS_users where username = ? and password = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				User u = new User(
						rs.getInt("user_id"),
						rs.getString("username"),
						rs.getString("password")
						);
				
				return u;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
