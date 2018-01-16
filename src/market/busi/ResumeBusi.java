package market.busi;

import java.sql.SQLException;
import java.util.List;

import market.dao.ResumeDao;
import market.vo.Resume;

public class ResumeBusi {
	ResumeDao rDao=new ResumeDao();
	public Resume selectResumeByID(int id) {
		Resume resume=rDao.selectById(id);
		return resume;
	}
	
	public void insert(Resume resume) {
         rDao.insert(resume);
		
	}
	
	public void delete(int id) {
		rDao.delete(id);
	}
	
	public List<Resume> getAllResumeByCustomerId(int customerId){
		List<Resume> rlist=rDao.selectAllByCustomerId(customerId);
		return rlist;
		
	}
	public Resume getFirstResumeByCustomerId(int customerId){
		List<Resume> rlist=rDao.selectAllByCustomerId(customerId);
		Resume resume=new Resume();
	    resume=rlist.get(0);	
		return resume;
		
	}
	public static void main(String[] args) throws SQLException {
//		ResumeBusi rBusi=new ResumeBusi();
//		Resume re=rBusi.getFirstResumeByCustomerId(2);
       // System.out.println(re.getCustomerId()+":"+re.getBirth()+":"+re.getEducation());
	}
	

}
