package market.busi;

import java.util.List;

import market.dao.RecruitmentDao;
import market.vo.Recruitment;

public class RecruitmentBusi {

	private RecruitmentDao rDao = new RecruitmentDao();
	
	public void release(Recruitment recruitment) throws BusiException{
		//各属性不可以为空
		rDao.insert(recruitment);
	}
	
	public void delete(int id) throws BusiException{
		//准备工作
		rDao.delete(id);
	}
	
	public List<Recruitment> getAllRecruitment(){
		return rDao.selectAll();
	}
	
	public List<Recruitment> getRecruitmentByPosition(String position) throws BusiException{
		//判断职位是否合法 待定
		return rDao.selectByPosition(position);
	}
	
	//public List<Recruitment> getRecruitmentByLocation
	public static void main(String[] args) {

	}

}
