package market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import market.vo.Possess;

public class PossessDao {
	
	public List<Possess> selectAllByCustomerId(int customerId){
		Connection conn = null;
		List<Possess> ret = new ArrayList<Possess>();
		try {
			conn = (Connection) DBHelper.getConnection();
			String sql = "select * from possess  where deleted=0 and customerId=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,customerId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Possess possess=new Possess();
				possess.setCustomerId(rs.getInt("customerId"));
				possess.setResumeId(rs.getInt("resumeId"));
				possess.setResumeName(rs.getString("resumeName"));
				possess.setDeleted(rs.getBoolean("deleted"));
				ret.add(possess);
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
//		Possess possess=new Possess();
//		possess.setCustomerId(2);
//		possess.setResumeId(3);
//		possess.setDeleted(false);
//		possess.setResumeName("招聘");
		PossessDao pDao=new PossessDao();
		List<Possess> ret =pDao.selectAllByCustomerId(2);
		for (int i = 0; i < ret.size(); i++) 
		{
			 Possess possess=ret.get(i);
	         System.out.println(possess.getCustomerId()+":"+possess.getResumeId()+":"+possess.getResumeName());
	    }
		Possess possess=new Possess();
		possess.setCustomerId(2);
		possess.setResumeId(3);
		possess.setDeleted(false);
		possess.setResumeName("招聘");
		//PossessDao pDao=new PossessDao()
		//pDao.insert(possess);
		//pDao.delete(1);

	}

}
