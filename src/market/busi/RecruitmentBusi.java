package market.busi;

import java.util.ArrayList;
import java.util.List;

import market.dao.RecruitmentDao;
import market.vo.Recruitment;

public class RecruitmentBusi {

	private RecruitmentDao rDao = new RecruitmentDao();
	
	
	public List<Recruitment> getRecruitmentByTitle(String title){
		return rDao.selectByVagueTitle(title);
	}
	
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
		//返回查找的职位
		return rDao.selectByPosition(position);		
	}
	
	public List<Recruitment> getRecruitmentByDepartment(String department){
		return null;
	}
	
	public List<Recruitment> getRecruitmentByLocation(String location) throws BusiException{
		List <Recruitment> list1 = new ArrayList<Recruitment>();
		List <Recruitment> list2 = new ArrayList<Recruitment>();
		
		list1 = rDao.selectByProvince(location);
		list2 = rDao.selectByCity(location);
		
		if(!list1.isEmpty()){
			return list1;
		}else{
			return list2;
		}
	}
	
	public Recruitment getRecruitmentById(int id){
		Recruitment recruitment = rDao.selectById(id);
		return recruitment;
	}
	//public List<Recruitment> getRecruitmentByLocation
	public static void main(String[] args) {
		RecruitmentBusi rBusi = new RecruitmentBusi();
		try {
			List<Recruitment> list = rBusi.getRecruitmentByPosition("C++");
			for(Recruitment recruitment :list) {
				System.out.println(recruitment);
			}
		} catch (BusiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
