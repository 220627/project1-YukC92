package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Status;
import com.revature.utils.ConnectionUtil;

public class StatusDAO implements StatusDAOInterface {

	@Override
	public Status getStatusById(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "select * from status where status_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Status status = new Status(
						rs.getInt("status_id"),
						rs.getString("status")
						);
						
				return status;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Status> getStatus() {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "select * from status";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			ArrayList<Status> statusList = new ArrayList<>();
			
			while(rs.next()) {
				
				Status status = new Status(
						rs.getInt("status_id"),
						rs.getString("status")
						);
				
				statusList.add(status);
			
				
			}
			
			return statusList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

}
