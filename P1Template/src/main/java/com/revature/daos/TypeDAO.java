package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Type;
import com.revature.utils.ConnectionUtil;

public class TypeDAO implements TypeDAOInterface{

	@Override
	public boolean insertType(Type type) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "insert into ERS_reimb_types (reimb_type) values (?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, type.getReimb_type());
			
			ps.executeUpdate();
			
			System.out.println("Type " + type.getReimb_type() + " added!");
			
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public ArrayList<Type> getTypes() {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "select * from ERS_reimb_types";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			ArrayList<Type> TypeList = new ArrayList<>();
			
			while (rs.next()) {
				
				Type t = new Type(
						rs.getInt("type_id"),
						rs.getString("reimb_type")
						);
				
				TypeList.add(t);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getTypeById(int id) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "select * from ERS_reimb_types where type_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Type type = new Type(
						rs.getInt("type_id"),
						rs.getString("reimb_type")
						);
					
				return type;
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}

}
