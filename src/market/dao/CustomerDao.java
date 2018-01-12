package market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import market.vo.Customer;;
/**
 * 
 * create by AprilCal on 2008.1.11.
 *
 */
public class CustomerDao {
	
	public void insert(Customer customer) {
		Connection connection = null;
		try {
			connection = DBHelper.getConnection();
			String sql = "INSERT INTO `personnel_market`.`customer` "+
					"(`customerName`, `time`, `password`, `tel`, `mail`, `messageNum`, `deleted`) "+
					"VALUES (?,?,?,?,?,?,?);";
			
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
	
	public void update(Customer customer) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "UPDATE `personnel_market`.`customer` "+
					"SET `customerName`=?, `time`=?, `password`=?, `tel`=?, `mail`=?, `messageNum`=? WHERE `customerId`=?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getTime());
			ps.setString(3, customer.getPassword());
			ps.setString(4, customer.getTel());
			ps.setString(5, customer.getMail());
			ps.setInt(6, customer.getMessageNum());
			ps.setInt(7, customer.getCustomerID());
			
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
			String sql = "UPDATE `personnel_market`.`customer` SET `deleted`='1' WHERE `customerId`=?;";
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
	
	public Customer selectById(int id){
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
	
			String sql = "select * from customer where customerId=? and deleted=0";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerID(rs.getInt("customerId"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setTime(rs.getString("time"));
				customer.setPassword(rs.getString("password"));
				customer.setTel(rs.getString("tel"));
				customer.setMail(rs.getString("mail"));
				customer.setMessageNum(rs.getInt("messageNum"));
				customer.setDeleted(rs.getBoolean("deleted"));
				return customer;
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
	
	public Customer selectByName(String name) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
	
			String sql = "select * from customer where customerName = ? and deleted=0";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerID(rs.getInt("customerId"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setTime(rs.getString("time"));
				customer.setPassword(rs.getString("password"));
				customer.setTel(rs.getString("tel"));
				customer.setMail(rs.getString("mail"));
				customer.setMessageNum(rs.getInt("messageNum"));
				customer.setDeleted(rs.getBoolean("deleted"));
				return customer;
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
	
	/*public List<Customer> selectByCondition(
			String name, Integer ageBegin, Integer ageEnd, Integer sex) {
		Connection conn = null;
		List<Customer> ret = new ArrayList<Customer>();
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from user where 1=1";
			ArrayList<Object> params = new ArrayList<Object>();
			
			//name.trim().isEmpty()
			if(name != null && name.trim().isEmpty() == false) {
				sql += " and name like ?";
				params.add("%"+name+"%");
			} 
			if( sex != null) {
				sql += " and sex = ?";
				params.add(sex);
			} 
			if( ageBegin != null) {
				sql += " and age >= ?";
				params.add(ageBegin);
			} 
			if( ageEnd != null) {
				sql += " and age <= ?";
				params.add(ageEnd);
			} 

			System.out.println("SQL:"+sql);
			System.out.println("Params:"+params);
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int i=1; i <= params.size(); i++) {
				ps.setObject(i, params.get(i-1));
			}
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getInt("sex"));
				user.setAddress(rs.getString("address"));
				ret.add(user);
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
		System.out.println("大小啊"+ret.size());
		return ret;
	}*/

}
