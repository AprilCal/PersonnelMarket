package market.busi;

import java.sql.SQLException;
import java.util.List;

import market.dao.SubmitDao;
import market.vo.Submit;

public class SubmitBusi {

	private SubmitDao sDao = new SubmitDao();
	
	//投递简历
	public boolean deliver(Submit submit) throws SQLException{
		//submit
		int resumeId=submit.getResumeId();
		int enterpriseId=submit.getEnterpriseId();
		int recruitmentId=submit.getRecruitmentId();
		List<Submit> rlist=sDao.getAllSubmitBycustomerId(resumeId);
		 for (int i = 0; i < rlist.size(); i++) 
		 {
			Submit sub=rlist.get(i);
			if((sub.getEnterpriseId()==enterpriseId)&&(sub.getRecruitmentId()==recruitmentId))
			{
				return false;
			}
	        
	     }
		
		sDao.insert(submit);
		return true;
	}
	
	//接受简历
	public void admitResume(Submit submit) {
		//TODO:
		submit.setState("admitted");
		sDao.update(submit);
	}
	
	//拒绝简历
	public void refuseResume(Submit submit) {
		submit.setState("refused");
		sDao.update(submit);
	}
	
	public void delete(int resumeId,int enterpriseId,int recruitmentId) {
		sDao.delete(resumeId, enterpriseId, recruitmentId);
	}
	
	public static void main(String[] args) {
//		Submit submit = new Submit();
//		submit.setResumeId(1);
//		submit.setEnterpriseId(2);
//		submit.setRecruitmentId(3);
//		submit.setReadOrNot(true);
//		submit.setDeleted(false);
//		submit.setState("unknown");
//		submit.setCustomerId(2);
//		SubmitBusi sBusi = new SubmitBusi();
//		try {
//			boolean flag=sBusi.deliver(submit);
//			System.out.println(flag);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//sBusi.admitResume(submit);
		//sBusi.refuseResume(submit);
		//sDao.update(submit);

	}

}
