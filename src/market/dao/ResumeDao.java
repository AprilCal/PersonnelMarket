package market.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import market.vo.Resume;

public class ResumeDao {
	public void insert(Resume resume) {
		Connection conn=null;
		try{
			conn=(Connection) DBHelper.getConnection();
			String sql = "insert into resume "
					+ "(resumeId,customerId,birth,education,graduate,"
					+"major,experiment,resumeCont,deleted)"
					+ " values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, resume.getResumeId());
			ps.setInt(2,resume.getCustomerId());
			ps.setString(3, resume.getBirth());
			ps.setString(4, resume.getEducation());
			ps.setString(5, resume.getGraduate());
			ps.setString(6, resume.getMajor());
			ps.setString(7, resume.getExperiment());
			ps.setString(8, resume.getResumeCont());
			ps.setBoolean(9, resume.isDeleted());
			
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	public void delete(int id) {
		Connection conn = null;
		try {
			conn = (Connection) DBHelper.getConnection();
			String sql = "UPDATE `personnel_market`.`resume` SET `deleted`='1' WHERE `resumetId`=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
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
	
	
	
	
}
