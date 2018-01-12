package market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import market.vo.Submit;

public class SubmitDao {
	public void insert(Submit submit) {
		Connection connection = null;
		try {
			connection = DBHelper.getConnection();
			String sql = "INSERT INTO `personnel_market`.`submit` "+
					"(`resumeId`, `enterpriseId`, `recruitmentId`, `readornot`, `deleted`, `state`) "+
					"VALUES (?,?,?,?,?,?);";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, submit.getResumeId());
			ps.setInt(2, submit.getEnterpriseId());
			ps.setInt(3, submit.getRecruitmentId());
			ps.setBoolean(4, submit.isReadOrNot());
			ps.setBoolean(5, submit.isDeleted());
			ps.setString(6, submit.getState());
			
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
	
	public void delete(int resumeId,int enterpriseId,int recruitmentId) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "UPDATE `personnel_market`.`submit` SET `deleted`='1' WHERE"+
					" `resumeId`=? and `enterpriseId`=? and `recruitmentId`=?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, resumeId);
			ps.setInt(2, enterpriseId);
			ps.setInt(3, recruitmentId);
			
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
	
	public void update(Submit submit) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "UPDATE `personnel_market`.`submit` "+
					"SET `readornot`=?, `deleted`=?, `state`=? WHERE `resumeId`=? and `enterpriseId`=? and `recruitmentId`=?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, submit.isReadOrNot());
			ps.setBoolean(2, submit.isDeleted());
			ps.setString(3, submit.getState());
			ps.setInt(4, submit.getResumeId());
			ps.setInt(5, submit.getEnterpriseId());
			ps.setInt(6, submit.getRecruitmentId());
			
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
	public static void SubmitInsertTest() {
		try {
			Connection connection = DBHelper.getConnection();
			if(connection!=null) {
				System.out.print("connect success");
			}
			Submit submit=new Submit();
			submit.setResumeId(1);
			submit.setEnterpriseId(2);
			submit.setRecruitmentId(2);
			submit.setReadOrNot(true);
			submit.setDeleted(false);
			submit.setState("Accepted");
			SubmitDao sdao=new SubmitDao();
			sdao.insert(submit);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		SubmitDao sDao = new SubmitDao();
//		Submit submit = new Submit();
//		submit.setResumeId(1);
//		submit.setEnterpriseId(2);
//		submit.setRecruitmentId(3);
//		submit.setReadOrNot(true);
//		submit.setDeleted(false);
//		submit.setState("refused");
//		SubmitInsertTest();
		//sDao.update(submit);
	}
}
