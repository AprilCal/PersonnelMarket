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
	/*��ҵ�û�ע��*/
	public void register(Enterprise enterprise,String repassword) throws BusiException{
		//sign up
			//username,password,rePassword must not be null
		if(enterprise.getEnterpriseName()==null||enterprise.getEnterpriseName().trim().isEmpty())
		{
				
			throw new BusiException("�û���������Ϊ��");
		}
		if(enterprise.getEnterpriseName()==null||enterprise.getEnterpriseName().trim().isEmpty())
		{
				
			throw new BusiException("�û���������Ϊ��");
		}
	    if(enterprise.getPassword()==null||enterprise.getPassword().trim().isEmpty()) {
				throw new BusiException("���벻����Ϊ��");
			}
		if(repassword==null||repassword.trim().isEmpty()) {
				throw new BusiException("ȷ�����벻����Ϊ��");
			}
			//password equals rePassword
		if(!repassword.equals(enterprise.getPassword())) {
				throw new BusiException("�������벻һ��");
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
