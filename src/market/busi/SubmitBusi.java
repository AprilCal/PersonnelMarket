package market.busi;

import market.dao.SubmitDao;
import market.vo.Submit;

public class SubmitBusi {

	private SubmitDao sDao = new SubmitDao();
	
	//投递简历
	public void deliver(Submit submit) {
		//submit
		sDao.insert(submit);
	}
	
	//接受简历
	public void admitResume(Submit submit) {
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
		Submit submit = new Submit();
		submit.setResumeId(1);
		submit.setEnterpriseId(2);
		submit.setRecruitmentId(3);
		submit.setReadOrNot(true);
		submit.setDeleted(false);
		submit.setState("unknown");
		submit.setCustomerId(2);
		//SubmitBusi sBusi = new SubmitBusi();
		//sBusi.admitResume(submit);
		//sBusi.refuseResume(submit);
		//sDao.update(submit);

	}

}
