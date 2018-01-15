package market.busi;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import market.dao.RecruitmentDao;
import market.dao.SubmitDao;
import market.vo.DeliveredBoxItem;
import market.vo.Recruitment;
import market.vo.Submit;

public class DeliveredBoxItemBusi {
	
	SubmitDao sDao = new SubmitDao();
	RecruitmentDao rDao=new RecruitmentDao();
	
	
	public List<DeliveredBoxItem> getDeliveredResumeList(int customerId) throws SQLException{
		
		List<DeliveredBoxItem> list = new ArrayList<DeliveredBoxItem>();
		List<Submit> submitList = sDao.getAllSubmitBycustomerId(customerId);
		/*根据customerId获取*/
		for(Submit s : submitList) {
			if(!s.isDeleted()){
				DeliveredBoxItem item=new DeliveredBoxItem();
				//获取招聘表的s.getRecruitmentId()
				Recruitment rment=rDao.selectById(s.getRecruitmentId());
				//item.setRecruitmentTitle();
				item.setResumeId(s.getResumeId());
				item.setRecruitmentTitle(rment.getTitle());
				item.setState(s.getState());
				list.add(item);
			}
		}
		
		
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
