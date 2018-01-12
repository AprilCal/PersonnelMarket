package market.busi;

import market.dao.CustomerDao;
import market.vo.Customer;


public class CustomerBusi {
	private CustomerDao cDao = new CustomerDao();
	
	public void login() {
		
	}
	//sign up
	public void register(Customer customer,String rePassword) throws Exception {
		//username,password,rePassword must not be null
		if(customer.getCustomerName()==null||customer.getCustomerName().trim().isEmpty()) {
			throw new BusiException("用户名不可以为空");
		}
		if(customer.getPassword()==null||customer.getPassword().trim().isEmpty()) {
			throw new BusiException("密码不可以为空");
		}
		if(rePassword==null||rePassword.trim().isEmpty()) {
			throw new BusiException("确认密码不可以为空");
		}
		//password equals rePassword
		if(!rePassword.equals(customer.getPassword())) {
			throw new BusiException("两次密码不一致");
		}
		//sign up success
		cDao.insert(customer);
	}
	
	public void modifyPassword(Customer customer,String oldPassword,String newPassword,String reNewPassword) throws BusiException {
		if(newPassword==null||newPassword.trim().isEmpty()) {
			throw new BusiException("新密码不可以为空");
		}
		if(reNewPassword==null||reNewPassword.trim().isEmpty()){
			throw new BusiException("确认密码不可以为空");
		}
		if(!oldPassword.equals(customer.getPassword())) {
			throw new BusiException("密码错误");
		}
		if(!newPassword.equals(reNewPassword)) {
			throw new BusiException("确认密码不一致");
		}
		
		customer.setPassword(newPassword);
		cDao.update(customer);
	}
	
	//function test
	public static void main(String[] args) {
		/*Customer customer = new Customer();
		customer.setCustomerName("czy");
		customer.setPassword("123");
		customer.setTime("2018/1/11");
		customer.setTel("15527358829");
		customer.setMail("747998045@qq.com");
		customer.setMessageNum(17);
		customer.setDeleted(false);
		
		CustomerBusi cBusi=new CustomerBusi();
		try {
			cBusi.register(customer, "12");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		Customer customer = new Customer();
		customer.setCustomerID(2);
		customer.setCustomerName("czy");
		customer.setPassword("12345");
		customer.setTime("2018/1/11");
		customer.setTel("15527358829");
		customer.setMail("747998045@qq.com");
		customer.setMessageNum(17);
		customer.setDeleted(false);
		
		CustomerBusi cBusi=new CustomerBusi();
		try {
			cBusi.modifyPassword(customer, "124", "12345", "12345");
		} catch (BusiException e) {
			e.printStackTrace();
		}
	}
}
