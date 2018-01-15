package market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import market.vo.Possess;

public class PossessDao {
	
	public void insert(Possess possess) {
		Connection connection = null;
		try {
			connection = DBHelper.getConnection();
			String sql = "INSERT INTO `personnel_market`.`possess` "+
					"(`customerId`, `resumeId`, `resumeName`,`deleted`) "+
					"VALUES (?,?,?,?);";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, possess.getCustomerId());
			ps.setInt(2, possess.getResumeId());
			ps.setString(3, possess.getResumeName());
			ps.setBoolean(4, possess.isDeleted());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void delete(int resumeId) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "UPDATE `personnel_market`.`possess` SET `deleted`='1' WHERE `resumeId`=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, resumeId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Possess possess=new Possess();
		possess.setCustomerId(2);
		possess.setResumeId(3);
		possess.setDeleted(false);
		possess.setResumeName("招聘");
		PossessDao pDao=new PossessDao();
		//pDao.insert(possess);
		//pDao.delete(1);

	}

}
