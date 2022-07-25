package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

public class RoleDAO implements RoleDAOInterface {

	@Override
	public boolean insertRole(Role role) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "insert into ERS_roles (role_title) values (?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, role.getRole_title());
			
			ps.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Role getRoleById(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "select * from roles where role_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id); 
			
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next()) {
				
				Role role = new Role(
						rs.getInt("role_id"),
						rs.getString("role_title")
					);
				
				return role;			
				
			}
			
		} catch (SQLException e) {
			System.out.println("Get Role Failed");
			e.printStackTrace();
		
		}
		
		return null;
	}

	
	
}
