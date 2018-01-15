package market.busi;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import market.dao.RecruitmentDao;
import market.dao.SubmitDao;
import market.vo.ResumeBoxItem;
import market.vo.Submit;

public class ResumeBoxItemBusi {
	
	SubmitDao sDao = new SubmitDao();
	RecruitmentDao rDao = new RecruitmentDao();

	public List<ResumeBoxItem> getList(int enterpriseId) throws SQLException{
		List<ResumeBoxItem> list = new ArrayList<ResumeBoxItem>();
		
		List<Submit> submitList = sDao.getAllSubmitByEnterpriseId(enterpriseId);
		for(Submit s : submitList) {
			if(!s.getState().equals("refused")){
				ResumeBoxItem item = new ResumeBoxItem();
				item.setRecruitmentTitle(rDao.selectById(enterpriseId).getTitle());
				item.setResumeId(s.getResumeId());				
				list.add(item);
			}
		}
		
		return list;
	}
	public static void main(String[] args) {

	}

}
