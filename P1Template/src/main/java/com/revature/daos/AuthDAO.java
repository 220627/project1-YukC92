package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Role;
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
						rs.getString("password"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("user_email"),
						null
						);
				
				int user_role_id_fk = rs.getInt("user_role_id_fk");
				
				RoleDAO rDAO = new RoleDAO();
				
				Role role = rDAO.getRoleById(user_role_id_fk);
				
				u.setRole(role);
				
				return u;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
