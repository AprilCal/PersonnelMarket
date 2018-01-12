package market.busi;

import market.dao.EnterpriseDao;
import market.vo.Customer;
import market.vo.Enterprise;

/**
 * 
 * @author yxw
 *
 */

public class EnterpriseBusi {
	
	private EnterpriseDao eDao = new EnterpriseDao();
	
	public void login(String name,String password) throws BusiException{
		
		
	}
	/*企业用户注册*/
	public void register(Enterprise enterprise,String repassword) throws BusiException{
		//sign up
			//username,password,rePassword must not be null
		if(enterprise.getEnterpriseName()==null||enterprise.getEnterpriseName().trim().isEmpty())
		{
				
			throw new BusiException("用户名不可以为空");
		}
		if(enterprise.getEnterpriseName()==null||enterprise.getEnterpriseName().trim().isEmpty())
		{
				
			throw new BusiException("用户名不可以为空");
		}
	    if(enterprise.getPassword()==null||enterprise.getPassword().trim().isEmpty()) {
				throw new BusiException("密码不可以为空");
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
	
	public void modifyPassword(Enterprise enterprise,String oldPassword,String newPassword,String reNewPassword) 
		throws BusiException{
		
	}
	
	
	//test
	public static void main(String[] args) {
		
	}

}
