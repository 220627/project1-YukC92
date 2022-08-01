package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.controllers.AuthController;
import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.Type;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDAO implements ReimbursementDAOInterface {

	@Override
	public boolean insertReimbursement(Reimbursement reimbursement) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			Object userId = AuthController.ses.getAttribute("userId");
			
			Integer author = Integer.parseInt(userId.toString());
			
			
			String sql = "insert into reimbursements (amount, description, author, type_fk)" +
						"values (?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reimbursement.getAmount());
			ps.setString(2, reimbursement.getDescription());
			ps.setInt(3, author);
			ps.setInt(4, reimbursement.getType_id_fk());
			
			ps.executeUpdate();
			
			System.out.println("test pass");
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("test fail");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Reimbursement> getAllReimbursements(String filter_status) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "select * from reimbursements";
			if (filter_status != "0") {
				sql += " inner join users on user_id = author where status_fk = ?";
			}
			
			PreparedStatement ps = conn.prepareStatement(sql);

			if (filter_status != "0") {
				Integer status_fk = Integer.parseInt(filter_status);
				ps.setInt(1, status_fk);
			}
						
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Reimbursement> reimbList = new ArrayList<>();
			
			while (rs.next()) {
				
				Reimbursement r = new Reimbursement(
						rs.getInt("reimb_id"),
						rs.getInt("amount"),
						rs.getTimestamp("submitted"),
						rs.getTimestamp("resolved"),
						rs.getString("description"),
						rs.getBinaryStream("receipt"),
						null,
						null,
						null,
						null,
						1
						);
				
				int reimb_author_id = rs.getInt("author");
				int reimb_resolver_id = rs.getInt("resolver");
				int reimb_status_id = rs.getInt("status_fk");
				int reimb_type_id = rs.getInt("type_fk");
				
				UserDAO uDAO = new UserDAO();
				
				User author = uDAO.getUserById(reimb_author_id);
				
				User resolver = uDAO.getUserById(reimb_resolver_id);
				
				r.setAuthor(author);
				
				r.setResolver(resolver);
				
				StatusDAO sDAO = new StatusDAO();
				
				Status status = sDAO.getStatusById(reimb_status_id);
				
				r.setStatus(status);
				
				TypeDAO tDAO = new TypeDAO();
				
				Type type = tDAO.getTypeById(reimb_type_id);
				
				r.setType(type);
				
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
			
			String sql = "delete from reimbusements where reimb_id = ?";
			
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
	public ArrayList<Reimbursement> getReimbursementsByAuthor(int author) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "select * from reimbursements inner join users on user_id = author where author = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, author);
								
					ResultSet rs = ps.executeQuery();
					
					ArrayList<Reimbursement> reimbList = new ArrayList<>();
					
					while (rs.next()) {
						
						Reimbursement r = new Reimbursement(
								rs.getInt("reimb_id"),
								rs.getInt("amount"),
								rs.getTimestamp("submitted"),
								rs.getTimestamp("resolved"),
								rs.getString("description"),
								rs.getBinaryStream("receipt"),
								null,
								null,
								null,
								null,
								0
								);
						
						int reimb_author_id = rs.getInt("author");
						int reimb_resolver_id = rs.getInt("resolver");
						int reimb_status_id = rs.getInt("status_fk");
						int reimb_type_id = rs.getInt("type_fk");
						
						
						UserDAO uDAO = new UserDAO();
						
						User uauthor = uDAO.getUserById(reimb_author_id);
						
						User resolver = uDAO.getUserById(reimb_resolver_id);
						
						StatusDAO sDAO = new StatusDAO();
						
						Status status = sDAO.getStatusById(reimb_status_id);
						
						r.setAuthor(uauthor);
						
						r.setResolver(resolver);
						
						r.setStatus(status);
						
						TypeDAO tDAO = new TypeDAO();
						
						Type type = tDAO.getTypeById(reimb_type_id);
						
						r.setType(type);
						
						reimbList.add(r);
						
					}
					
//					Object userRole = AuthController.ses.getAttribute("userRole");
//					
//					System.out.println("jshdkjashd");
					return reimbList;
					
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean approveReimbursement(Reimbursement reimbursement) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "update reimbursements set resolved = ?, status_fk = 2 where reimb_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setTimestamp(1, reimbursement.getResolved());
			ps.setInt(2, reimbursement.getReimb_id());
			
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
	public boolean denyReimbursement(Reimbursement reimbursement) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "update reimbursements set resolved = ?, status_fk = 3 where reimb_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setTimestamp(1, reimbursement.getResolved());
			ps.setInt(2, reimbursement.getReimb_id());
			
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
	public ArrayList<Reimbursement> getAllRe() {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
					
			String sql = "select * from reimbursements";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			ArrayList<Reimbursement> reimbList = new ArrayList<>();
			
			while (rs.next()) {
				
				Reimbursement r = new Reimbursement(
						rs.getInt("reimb_id"),
						rs.getInt("amount"),
						rs.getTimestamp("submitted"),
						rs.getTimestamp("resolved"),
						rs.getString("description"),
						rs.getBinaryStream("receipt"),
						null,
						null,
						null,
						null,
						0
						);
				
				int reimb_author_id = rs.getInt("author");
				int reimb_resolver_id = rs.getInt("resolver");
				int reimb_status_id = rs.getInt("status_fk");
				int reimb_type_id = rs.getInt("type_fk");
				
				
				UserDAO uDAO = new UserDAO();
				
				User uauthor = uDAO.getUserById(reimb_author_id);
				
				User resolver = uDAO.getUserById(reimb_resolver_id);
				
				StatusDAO sDAO = new StatusDAO();
				
				Status status = sDAO.getStatusById(reimb_status_id);
				
				r.setAuthor(uauthor);
				
				r.setResolver(resolver);
				
				r.setStatus(status);
				
				TypeDAO tDAO = new TypeDAO();
				
				Type type = tDAO.getTypeById(reimb_type_id);
				
				r.setType(type);
				
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


}
