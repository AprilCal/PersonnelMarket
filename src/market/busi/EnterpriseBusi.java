package market.busi;

import market.dao.EnterpriseDao;
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
	
	public void register(Enterprise enterprise) throws BusiException{
		
	}
	
	public void modifyPassword(Enterprise enterprise,String oldPassword,String newPassword,String reNewPassword) 
		throws BusiException{
		
	}
	
	
	//test
	public static void main(String[] args) {
		
	}

}
