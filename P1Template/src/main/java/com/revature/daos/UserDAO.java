package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class UserDAO implements UserDAOInterface{

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "insert into users (username, password, first_name, last_name, user_email, role_id_fk) values (?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirst_name());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getUser_email());
			ps.setInt(6, user.getUser_role_id_fk());
			
			ps.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "select * from users where user_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				User u = new User(
						rs.getInt("user_id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("user_email"),
						null
						);
				
				int roleFK = rs.getInt("role_id_fk");
				
				RoleDAO rDAO = new RoleDAO();
				
				Role r = rDAO.getRoleById(roleFK);
				
				u.setRole(r);
				
				return u;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		
		ArrayList<User> usersList = new ArrayList<>();
		
		String sql = "select * from users where role_id_fk = 2"; //employee role_id in ERS_roles
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				
				User u = new User(
							rs.getInt("user_id"),
							rs.getString("username"),
							rs.getString("password"),
							rs.getString("first_name"),
							rs.getString("last_name"),
							rs.getString("user_email"),
							null
							);
						
				int roleFK = rs.getInt("role_id_fk");
				
				RoleDAO rDAO = new RoleDAO();
				
				Role r = rDAO.getRoleById(roleFK);
				
				u.setRole(r);
				
				usersList.add(u);
				
				return usersList;
			}
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}



}
