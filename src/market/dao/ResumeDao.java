package market.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			String sql = "UPDATE `personnel_market`.`resume` SET `deleted`='1' WHERE `resumeId`=?";
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
	public Resume selectById(int id){
		Connection conn = null;
		try {
			conn = (Connection) DBHelper.getConnection();
	
			String sql = "select * from resume where resumeId = ? and deleted=0";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Resume resume=new Resume();
				resume.setResumeId(rs.getInt("resumeId"));
				resume.setCustomerId(rs.getInt("customerId"));
				resume.setBirth(rs.getString("birth"));
				resume.setEducation(rs.getString("education"));
				resume.setGraduate(rs.getString("graduate"));
				resume.setMajor(rs.getString("major"));
				resume.setExperiment(rs.getString("experiment"));
				resume.setResumeCont(rs.getString("resumeCont"));
				resume.setDeleted(rs.getBoolean("deleted"));
				return resume;
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
	public List<Resume> selectAll(){
		Connection conn = null;
		List<Resume> ret = new ArrayList<Resume>();
		try {
			conn = (Connection) DBHelper.getConnection();
			String sql = "select * from resume  where deleted=0;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Resume resume = new Resume();
				resume.setResumeId(rs.getInt("resumeId"));
				resume.setCustomerId(rs.getInt("customerId"));
				resume.setBirth(rs.getString("birth"));
				resume.setEducation(rs.getString("education"));
				resume.setGraduate(rs.getString("graduate"));
				resume.setMajor(rs.getString("major"));
				resume.setExperiment(rs.getString("experiment"));
				resume.setResumeCont(rs.getString("resumeCont"));
				resume.setDeleted(rs.getBoolean("deleted"));
				ret.add(resume);
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
	/*根据用户id查找*/
	public List<Resume> selectAllByCustomerId(int id){
		Connection conn = null;
		List<Resume> ret = new ArrayList<Resume>();
		try {
			conn = (Connection) DBHelper.getConnection();
			String sql = "select * from resume  where deleted=0 and customerId=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Resume resume = new Resume();
				resume.setResumeId(rs.getInt("resumeId"));
				resume.setCustomerId(rs.getInt("customerId"));
				resume.setBirth(rs.getString("birth"));
				resume.setEducation(rs.getString("education"));
				resume.setGraduate(rs.getString("graduate"));
				resume.setMajor(rs.getString("major"));
				resume.setExperiment(rs.getString("experiment"));
				resume.setResumeCont(rs.getString("resumeCont"));
				resume.setDeleted(rs.getBoolean("deleted"));
				ret.add(resume);
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
	public  void ResumeInsertTest()
	{
		Resume resume=new Resume();
		resume.setCustomerId(2);
		resume.setBirth("2018.1.15");
		resume.setEducation("霍格沃茨屋里哇啦中学");
		resume.setGraduate("逸仙魔法学院毕业");
		resume.setMajor("魔法学");
		resume.setExperiment("占卜");
		resume.setResumeCont("hhah");
		resume.setDeleted(false);
		ResumeDao rdao=new ResumeDao();
		rdao.insert(resume);
	}
	public  void ResumeDeleteTest()
	{
		
		ResumeDao rdao=new ResumeDao();
		rdao.delete(3);
	}
	public static void main(String[] args) throws SQLException {
		ResumeDao rDao=new ResumeDao();
//		Resume resume=new Resume();
		//resume=rDao.selectById(1);
//		System.out.print(resume.getBirth()+":"+resume.getExperiment());
		//rDao.ResumeInsertTest();
		//rDao.delete(4);
		//ResumeInsertTest();
		//ResumeDeleteTest();
//		List<Resume> ret=rDao.selectAll();
//				 for (int i = 0; i < ret.size(); i++) {
//					Resume re=ret.get(i);
//			         System.out.println(re.getCustomerId()+":"+re.getBirth()+":"+re.getEducation());
//			        }
				
		
	}

	
	
}
