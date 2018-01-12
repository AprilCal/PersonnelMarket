package market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import market.vo.Enterprise;

public class EnterpriseDao {
	
	public void insert(Enterprise enterprise) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
	
			String sql = "insert into enterprise "
					+ "(enterpriseName,tel,mail,messageNum,resumeRecv,password,deleted)"
					+ " values (?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, enterprise.getEnterpriseName());
			ps.setString(2, enterprise.getTel());
			ps.setString(3, enterprise.getMail());
			ps.setInt(4, enterprise.getMessageNum());
			ps.setInt(5, enterprise.getResumeRecv());
			ps.setString(6, enterprise.getPassword());
			ps.setBoolean(7, enterprise.isDeleted());

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
	
	public void delete(int id) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "UPDATE `personnel_market`.`enterprise` SET `deleted`='1' WHERE `enterpriseId`=?;";
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
	
	public Enterprise selectByName() {
		return null;
	}
	
	public Enterprise selectByID() {
		return null;
	}

}
