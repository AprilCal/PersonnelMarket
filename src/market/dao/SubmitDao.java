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
			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getTime());
			ps.setString(3, customer.getPassword());
			ps.setString(4, customer.getTel());
			ps.setString(5, customer.getMail());
			ps.setInt(6, customer.getMessageNum());
			ps.setBoolean(7, customer.isDeleted());
			
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
}
