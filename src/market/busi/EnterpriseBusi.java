package market.busi;

import market.dao.EnterpriseDao;
import market.vo.Enterprise;

/**
 * 
 * @author yxw
 *
 */

public class EnterpriseBusi {
	
	private  EnterpriseDao eDao = new EnterpriseDao();
	
	public void incResuemRecv(int id) {
		eDao.incResumeRecv(id);
	}
	
	public void decResumeRecv(int id) {
		eDao.decResumeRecv(id);
	}
	
	public Enterprise login(String username,String password) throws BusiException{
		Enterprise enterprise=null;
		enterprise=eDao.selectByUserName(username.trim());
		if(enterprise==null||!enterprise.getPassword().equals(password))
		{
			throw new BusiException("用户名或者密码错误！");
			
		}
		if(enterprise.getPassword().equals(password))
		{
			return enterprise;
		}
		return null;
		
		
	}
	/*注册*/
	public void register(Enterprise enterprise,String repassword) throws BusiException{
		//sign up
			//username,password,rePassword must not be null
		if(enterprise.getEnterpriseName()==null||enterprise.getEnterpriseName().trim().isEmpty())
		{
				
			throw new BusiException("用户名不能为空！");
		}
		
	    if(enterprise.getPassword()==null||enterprise.getPassword().trim().isEmpty()) {
				throw new BusiException("密码不可以为空！");
			}
		if(repassword==null||repassword.trim().isEmpty()) {
				throw new BusiException("确认密码不可以为空");
			}
			//password equals rePassword
		if(!repassword.equals(enterprise.getPassword())) {
				throw new BusiException("两次密码不一致");
			}
			//sign up success
		eDao.insert(enterprise);
		}
	
//	public void modifyPassword(Enterprise enterprise,String oldPassword,String newPassword,String reNewPassword) 
//		throws BusiException{
//		if(newPassword==null||newPassword.trim().isEmpty()) {
//			throw new BusiException("新密码不可以为空");
//		}
//		if(reNewPassword==null||reNewPassword.trim().isEmpty()){
//			throw new BusiException("确认密码不可以为空");
//		}
//		if(!oldPassword.equals(enterprise.getPassword())) {
//			throw new BusiException("密码错误");
//		}
//		if(!newPassword.equals(reNewPassword)) {
//			throw new BusiException("确认密码不一致");
//		}
//		
//		enterprise.setPassword(newPassword);
//		eDao.update(enterprise);
//	}
//	
	
	//test
	public static void main(String[] args) throws BusiException {
		EnterpriseBusi eBusi=new EnterpriseBusi();
//		Enterprise enterprise=new Enterprise();
//		enterprise.setEnterpriseId(1);
//		enterprise.setEnterpriseName("武汉独狼网吧");
//		enterprise.setTel("18721594283");
//		enterprise.setMessageNum(6);
//		enterprise.setResumeRecv(4);
//		enterprise.setMail("753662@163.com");
//		enterprise.setPassword("123");
//		enterprise.setDeleted(false);
//		
//		EnterpriseDao eDao = new EnterpriseDao();
//		eDao.updateById(enterprise,1);
		//incResuemRecv(1);
		eBusi.decResumeRecv(1);
		
		
	}

}
