package market.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import market.busi.BusiException;
import market.busi.CustomerBusi;
import market.busi.EnterpriseBusi;
import market.busi.RecruitmentBusi;
import market.vo.Customer;
import market.vo.Enterprise;
import market.vo.Recruitment;


/**
 * 
 * completed by AprilCal on 2018.1.13
 *
 */

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private CustomerBusi cBusi = new CustomerBusi();
	private EnterpriseBusi eBusi = new EnterpriseBusi();
	
	private RecruitmentBusi rBusi = new RecruitmentBusi();
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		String identity = request.getParameter("identity");
		
		System.out.println("name:"+username+"  password:"+password+" identity:"+identity);
		
		//customer sign in
		if (identity.equals("customer")) {
			try {
				Customer customer = cBusi.login(username, password);
				if(customer!=null) {
					request.getSession().setAttribute("customer", customer);
					request.getSession().setAttribute("recruitmentList", rBusi.getAllRecruitment());
					
					for(Recruitment r:rBusi.getAllRecruitment()) {
						System.out.println(r);
					}
					
					response.sendRedirect("CustomerMainPage.jsp");
				}
				else {
					request.setAttribute("msg", "用户名或密码错误");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}
			} catch (BusiException e) {
				request.setAttribute("msg", "用户名或密码错误");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				e.printStackTrace();
			}			
		}
		
		//enterprise sign in
		if(identity.equals("enterprise")) {
			try {
				Enterprise enterprise = eBusi.login(username, password);
				if(enterprise!=null) {
					request.getSession().setAttribute("enterprise", enterprise);
					request.getSession().setAttribute("recruitmentList", rBusi.getAllRecruitment());
					response.sendRedirect("EnterpriseMainPage.jsp");
				}
				else {
					request.setAttribute("msg", "用户名或密码错误");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}
			} catch (BusiException e) {
				request.setAttribute("msg", "用户名或密码错误");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				e.printStackTrace();
			}		
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
