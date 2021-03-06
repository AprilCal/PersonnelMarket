package market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import market.vo.Submit;

public class SubmitDao {
	
	public Submit selectSubmitByPrimaryKey(int resumeId,int enterpriseId,int recruitmentId){
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
	
			String sql = "select * from submit where resumeId=? and enterpriseId=? and recruitmentId = ? and deleted=0";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,resumeId);
			ps.setInt(2, enterpriseId);
			ps.setInt(3, recruitmentId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Submit submit=new Submit();
				submit.setResumeId(rs.getInt("resumeId"));
				submit.setEnterpriseId(rs.getInt("enterpriseId"));
				submit.setRecruitmentId(rs.getInt("recruitmentId"));
				submit.setReadOrNot(rs.getBoolean("readornot"));
				submit.setDeleted(rs.getBoolean("deleted"));
				submit.setState(rs.getString("state"));
				submit.setCustomerId(rs.getInt("customerId"));
				return submit;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public List<Submit> getAllSubmitByEnterpriseId(int id) throws SQLException
	{
		Connection conn = null;
		List<Submit> ret = new ArrayList<Submit>();
		try {
			conn = (Connection) DBHelper.getConnection();
			String sql = "select * from submit  where enterpriseId=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Submit submit=new Submit();
				submit.setResumeId(rs.getInt("resumeId"));
				submit.setEnterpriseId(rs.getInt("enterpriseId"));
				submit.setRecruitmentId(rs.getInt("recruitmentId"));
				submit.setReadOrNot(rs.getBoolean("readornot"));
				submit.setDeleted(rs.getBoolean("deleted"));
				submit.setState(rs.getString("state"));
				submit.setCustomerId(rs.getInt("customerId"));
				ret.add(submit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
	public List<Submit> getAllSubmitBycustomerId(int id) throws SQLException
	{
		Connection conn = null;
		List<Submit> ret = new ArrayList<Submit>();
		try {
			conn = (Connection) DBHelper.getConnection();
			String sql = "select * from submit  where customerId=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Submit submit=new Submit();
				submit.setResumeId(rs.getInt("resumeId"));
				submit.setEnterpriseId(rs.getInt("enterpriseId"));
				submit.setRecruitmentId(rs.getInt("recruitmentId"));
				submit.setReadOrNot(rs.getBoolean("ReadOrNot"));
				submit.setDeleted(false);
				submit.setState(rs.getString("state"));
				submit.setCustomerId(rs.getInt("customerId"));
				ret.add(submit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
		
	}
	public void insert(Submit submit) throws SQLException {
		Connection connection = null;
		try {
			connection = DBHelper.getConnection();
			String sql = "INSERT INTO `personnel_market`.`submit` "+
					"(`resumeId`, `enterpriseId`, `recruitmentId`, `readornot`, `deleted`, `state`,`customerId`) "+
					"VALUES (?,?,?,?,?,?,?);";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, submit.getResumeId());
			ps.setInt(2, submit.getEnterpriseId());
			ps.setInt(3, submit.getRecruitmentId());
			ps.setBoolean(4, submit.isReadOrNot());
			ps.setBoolean(5, submit.isDeleted());
			ps.setString(6, submit.getState());
			ps.setInt(7, submit.getCustomerId());
			
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
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
			String sql = "DELETE FROM `personnel_market`.`submit` WHERE"+
					" `resumeId`=? and `enterpriseId`=? and `recruitmentId`=?;";
			//DELETE FROM `personnel_market`.`submit` WHERE `resumeId`='1' and`enterpriseId`='2' and`recruitmentId`='3';
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
					"SET `readornot`=?, `deleted`=?, `state`=? WHERE `resumeId`=? and `enterpriseId`=? and `recruitmentId`=? and `customerId`=?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, submit.isReadOrNot());
			ps.setBoolean(2, submit.isDeleted());
			ps.setString(3, submit.getState());
			ps.setInt(4, submit.getResumeId());
			ps.setInt(5, submit.getEnterpriseId());
			ps.setInt(6, submit.getRecruitmentId());
			ps.setInt(7, submit.getCustomerId());
			
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
			//submit.setResumeId(1);
			submit.setEnterpriseId(2);
			submit.setRecruitmentId(2);
			submit.setReadOrNot(true);
			submit.setDeleted(false);
			submit.setState("refused");
			submit.setCustomerId(2);
			SubmitDao sdao=new SubmitDao();
			sdao.insert(submit);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SubmitDao sDao = new SubmitDao();
		//sDao.delete(1, 2, 2);
		//Submit submit=sDao.selectSubmitByPrimaryKey(1,2,2);
		//System.out.println(submit.getState());
//		Submit submit = new Submit();
//		submit.setResumeId(1);
//		submit.setEnterpriseId(2);
//		submit.setRecruitmentId(3);
//		submit.setReadOrNot(true);
//		submit.setDeleted(false);
//		submit.setState("refused");
		//SubmitInsertTest();
		//sDao.update(submit);
	}
}
