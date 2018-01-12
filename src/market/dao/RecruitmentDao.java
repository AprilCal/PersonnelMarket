package market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import market.vo.Recruitment;

public class RecruitmentDao {
	public void insert(Recruitment recruitment) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
	
			String sql = "insert into recruitment "
					+ "(title,department,position,time,enterpriseId,"
					+"salary_low,salary_high,experiment,positionDescription,province,city,techStack,positionRequirement,deleted)"
					+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, recruitment.getTitle());
			ps.setString(2, recruitment.getDepartment());
			ps.setString(3, recruitment.getPosition());
			ps.setString(4, recruitment.getTime());
			ps.setInt(5, recruitment.getEnterpriseId());
			ps.setInt(6, recruitment.getSalary_low());
			ps.setInt(7, recruitment.getSalary_high());
			ps.setString(8, recruitment.getExperiment());
			ps.setString(9, recruitment.getPositionDescription());
			ps.setString(10, recruitment.getProvince());
			ps.setString(11, recruitment.getCity());
			ps.setString(12, recruitment.getTechStack());
			ps.setString(13, recruitment.getPositionRequirment());
			ps.setBoolean(14, recruitment.isDeleted());
			
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
	
	public Recruitment selectById(int id){
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
	
			String sql = "select * from recruitment where RecruitmentId = ? and deleted=0";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Recruitment recruitment = new Recruitment();
				recruitment.setRecruitmentId(rs.getInt("recruitmentId"));
				recruitment.setTitle(rs.getString("title"));
				recruitment.setTime(rs.getString("time"));
				recruitment.setDepartment(rs.getString("department"));
				recruitment.setPosition(rs.getString("position"));
				recruitment.setEnterpriseId(rs.getInt("enterpriseId"));
				recruitment.setSalary_low(rs.getInt("salary_low"));
				recruitment.setSalary_high(rs.getInt("salary_high"));
				recruitment.setExperiment(rs.getString("experiment"));
				recruitment.setPositionDescription(rs.getString("positionDescription"));
				recruitment.setProvince(rs.getString("province"));
				recruitment.setCity(rs.getString("city"));
				recruitment.setTechStack(rs.getString("techStack"));
				recruitment.setPositionRequirment(rs.getString("positionRecruitment"));
				recruitment.setDeleted(rs.getBoolean("deleted"));
				return recruitment;
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
	
	public List<Recruitment> selectByPosition(String position){
		Connection conn = null;
		List<Recruitment> ret = new ArrayList<Recruitment>();
		try {
			conn = DBHelper.getConnection();
	
			String sql = "select * from recruitment where position=? and deleted=0";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, position);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Recruitment recruitment = new Recruitment();
				recruitment.setRecruitmentId(rs.getInt("recruitmentId"));
				recruitment.setTitle(rs.getString("title"));
				recruitment.setTime(rs.getString("time"));
				recruitment.setDepartment(rs.getString("department"));
				recruitment.setPosition(rs.getString("position"));
				recruitment.setEnterpriseId(rs.getInt("enterpriseId"));
				recruitment.setSalary_low(rs.getInt("salary_low"));
				recruitment.setSalary_high(rs.getInt("salary_high"));
				recruitment.setExperiment(rs.getString("experiment"));
				recruitment.setPositionDescription(rs.getString("positionDescription"));
				recruitment.setProvince(rs.getString("province"));
				recruitment.setCity(rs.getString("city"));
				recruitment.setTechStack(rs.getString("techStack"));
				recruitment.setPositionRequirment(rs.getString("positionRequirement"));
				recruitment.setDeleted(rs.getBoolean("deleted"));
				ret.add(recruitment);
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
	
	public List<Recruitment> selectAll(){
		Connection conn = null;
		List<Recruitment> ret = new ArrayList<Recruitment>();
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from recruitment  where deleted=0;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Recruitment recruitment = new Recruitment();
				recruitment.setRecruitmentId(rs.getInt("recruitmentId"));
				recruitment.setTitle(rs.getString("title"));
				recruitment.setTime(rs.getString("time"));
				recruitment.setDepartment(rs.getString("department"));
				recruitment.setPosition(rs.getString("position"));
				recruitment.setEnterpriseId(rs.getInt("enterpriseId"));
				recruitment.setSalary_low(rs.getInt("salary_low"));
				recruitment.setSalary_high(rs.getInt("salary_high"));
				recruitment.setExperiment(rs.getString("experiment"));
				recruitment.setPositionDescription(rs.getString("positionDescription"));
				recruitment.setProvince(rs.getString("province"));
				recruitment.setCity(rs.getString("city"));
				recruitment.setTechStack(rs.getString("techStack"));
				recruitment.setPositionRequirment(rs.getString("positionRequirement"));
				recruitment.setDeleted(rs.getBoolean("deleted"));
				ret.add(recruitment);
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

	public void delete(int id) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "UPDATE `personnel_market`.`recruitment` SET `deleted`='1' WHERE `recruitmentId`=?";
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
	
/*
	
	public List<User> selectByCondition(
			String name, Integer ageBegin, Integer ageEnd, Integer sex) {
		Connection conn = null;
		List<User> ret = new ArrayList<User>();
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from user where 1=1";
			//���屣������ļ���
			ArrayList<Object> params = new ArrayList<Object>();
			
			//name.trim().isEmpty() �ж�name��ȥ���ո�֮���Ƿ�Ϊ���ַ�����""��
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

			// 3.����Ԥ������� ?�ű�ʾռλ��
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.ִ�����
			
			// ���ò���
			for(int i=1; i <= params.size(); i++) {
				ps.setObject(i, params.get(i-1));
			}
			
			ResultSet rs = ps.executeQuery();// ִ�����
			while(rs.next()) {
				System.out.println("��ѯ�ɹ���");
				//�����û����󣬽������ݿ��ѯ�����ֶ����õ��ö�����
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
			// 5.�ر�����
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("��ѯ���ļ�¼����"+ret.size());
		return ret;
	}*/
}
