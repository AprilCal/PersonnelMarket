package market.dao;

import java.sql.*;
import java.util.List;

import market.vo.Customer;
import market.vo.Enterprise;
import market.vo.Recruitment;
import market.vo.Submit;

public class Test {
	
	public static void CustomerInsertTest() {
		try {
			Connection connection = DBHelper.getConnection();
			if(connection!=null) {
				System.out.print("connect success");
			}
			Customer customer = new Customer();
			customer.setCustomerName("czy");
			customer.setPassword("123");
			customer.setTime("2018/1/11");
			customer.setTel("15527358829");
			customer.setMail("747998045@qq.com");
			customer.setMessageNum(17);
			customer.setDeleted(false);

			CustomerDao cDao=new CustomerDao();
			cDao.insert(customer);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void CustomerDeleteTest() {
		try {
			Connection connection = DBHelper.getConnection();
			if(connection!=null) {
				System.out.print("connect success");
			}
			
			CustomerDao cDao=new CustomerDao();
			cDao.delete(1);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void CustomerUpdateTest() {
		try {
			Connection connection = DBHelper.getConnection();
			if(connection!=null) {
				System.out.print("connect success");
			}
			Customer customer = new Customer();
			customer.setCustomerID(1);
			customer.setCustomerName("yxw");
			customer.setPassword("123");
			customer.setTime("2018/1/12");
			customer.setTel("15527358829");
			customer.setMail("747998045@qq.com");
			customer.setMessageNum(16);

			CustomerDao cDao=new CustomerDao();
			cDao.update(customer);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void CustomerSelectByIdTest() {
		CustomerDao cDao=new CustomerDao();
		System.out.println(cDao.selectById(1).toString());
	}
	
	public static void CustomerSelectByNameTest() {
		CustomerDao cDao=new CustomerDao();
		System.out.println(cDao.selectByName("yxw").toString());
	}

	public static void RecruitmentInsertTest() {
		
		Recruitment recruitment = new Recruitment();
		recruitment.setTitle("毒狼网吧招扫地大妈");
		recruitment.setDepartment("技术");
		recruitment.setPosition("C++");
		recruitment.setTime("2018/1/11");
		recruitment.setEnterpriseId(1);
		recruitment.setSalary_low(10000);
		recruitment.setSalary_high(20000);
		recruitment.setExperiment("两年开发经验");
		recruitment.setPositionDescription("本职位要求会上网");
		recruitment.setProvince("山东");
		recruitment.setCity("威海");
		recruitment.setTechStack("c++/c");
		recruitment.setPositionRequirment("要求会使用c++");
		recruitment.setDeleted(false);
		RecruitmentDao rDao=new RecruitmentDao();
		
		rDao.insert(recruitment);
	}
	
	public static void RecruitmentSelectByPosition() {
		RecruitmentDao rDao = new RecruitmentDao();
		List<Recruitment> list = rDao.selectByPosition("C++");
		for(Recruitment re : list) {
			System.out.println(re);
		}
	}
	
	public static void RecruitmentSelectAll() {
		RecruitmentDao rDao = new RecruitmentDao();
		List<Recruitment> list = rDao.selectAll();
		for(Recruitment re : list) {
			System.out.println(re);
		}
	}
	
	public static void RecruitmentDeleteTest() {
		RecruitmentDao rDao = new RecruitmentDao();
		rDao.delete(2);
		rDao.delete(3);
	}
	
	public static void EnterpriseInsert() {
		Enterprise enterprise = new Enterprise();
		enterprise.setEnterpriseName("汉中万钢洗脚店");
		enterprise.setTel("15071436169");
		enterprise.setMail("15171436169@163.com");
		enterprise.setMessageNum(16);
		enterprise.setResumeRecv(17);
		enterprise.setPassword("123");
		enterprise.setDeleted(false);
		EnterpriseDao eDao = new EnterpriseDao();
		eDao.insert(enterprise);
	}
	
	public static void EnterpriseDelete() {
		
	}
	
	public static void SubmitInsert() {
		SubmitDao sDao = new SubmitDao();
		Submit submit = new Submit();
		submit.setResumeId(1);
		submit.setEnterpriseId(2);
		submit.setRecruitmentId(3);
		submit.setReadOrNot(true);
		submit.setDeleted(false);
		submit.setState("refused");
		
		sDao.insert(submit);
	}
	public static void main(String[] args) throws SQLException {
		//CustomerInsertTest();
		//CustomerDeleteTest();
		//CustomerUpdateTest();
		//CustomerSelectByIdTest();
		//CustomerSelectByNameTest();
		//RecruitmentInsertTest();
		//RecruitmentSelectByPosition();
		//RecruitmentSelectAll();
		//RecruitmentDeleteTest();
		//EnterpriseInsert();
		//SubmitInsert();
	}

}
