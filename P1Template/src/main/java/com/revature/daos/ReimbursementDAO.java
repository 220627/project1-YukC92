package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.Type;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDAO implements ReimbursementDAOInterface {

	@Override
	public boolean insertReimbursement(Reimbursement reimbursement) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "insert into ERS_reimbursements (reimb_amount, reimb_sumitted, reimb_resolved, reimb_description, reimb_recipt, reimb_author, reimb_resolver, reimb_status, reimb_type)" +
						"values (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reimbursement.getReimb_amount());
			ps.setTimestamp(2, reimbursement.getReimb_sumitted());
			ps.setTimestamp(3, reimbursement.getReimb_resolved());
			ps.setString(4, reimbursement.getReimb_description());
			ps.setBlob(5, reimbursement.getReimb_receipt());
			ps.setInt(6, reimbursement.getReimb_author().getUser_id());
			ps.setInt(7, reimbursement.getReimb_resolver().getUser_id());
			ps.setInt(8, reimbursement.getReimb_status().getStatus_id());
			ps.setInt(9, reimbursement.getReimb_type().getType_id());
			
			ps.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Reimbursement> getAllReimbursements() {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "select * from ERS_reimbursements";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			ArrayList<Reimbursement> reimbList = new ArrayList<>();
			
			while (rs.next()) {
				
				Reimbursement r = new Reimbursement(
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getTimestamp("reimb_summited"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getBinaryStream("reimb_receipt"),
						null,
						null,
						null,
						null
						);
				
				int reimb_author_id = rs.getInt("reimb_author_id");
				int reimb_resolver_id = rs.getInt("reimb_resolver_id");
				int reimb_status_id = rs.getInt("reimb_status_id");
				int reimb_type_id = rs.getInt("reimb_type_id");
				
				UserDAO uDAO = new UserDAO();
				
				User author = uDAO.getUserById(reimb_author_id);
				
				User resolver = uDAO.getUserById(reimb_resolver_id);
				
				r.setReimb_author(author);
				
				r.setReimb_resolver(resolver);
				
				StatusDAO sDAO = new StatusDAO();
				
				Status status = sDAO.getStatusById(reimb_status_id);
				
				r.setReimb_status(status);
				
				TypeDAO tDAO = new TypeDAO();
				
				Type type = tDAO.getTypeById(reimb_type_id);
				
				r.setReimb_type(type);
				
				reimbList.add(r);
				
			}
			
			return reimbList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteReimbursement(int reimb_id) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "delete from ERS_reimbusements where reimb_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reimb_id);
			
			ps.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public ArrayList<Reimbursement> getReimbursementsByUser(User user, int role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateReimbursementStatus(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return false;
	}

}
