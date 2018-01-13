package market.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market.busi.BusiException;
import market.busi.CustomerBusi;
import market.busi.EnterpriseBusi;
import market.vo.Customer;
import market.vo.Enterprise;


/**
 * 
 * completed by AprilCal on 2018.1.13
 *
 */
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private CustomerBusi cBusi = new CustomerBusi();
	private EnterpriseBusi eBusi = new EnterpriseBusi();
	
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
					request.getRequestDispatcher("CustomerMainPage.jsp").forward(request, response);
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
					request.getRequestDispatcher("EnterpriseMainPage.jsp").forward(request, response);
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
	
	
	/*protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		User user = busi.login(name, pwd);
		if(user != null) {
			Cookie cookie = new Cookie("loginedUser", name);
			switch(request.getParameter("saveNameFlag")){
			case "month":
				cookie.setMaxAge(60*60*24*30);
				break;
			case "week":
				cookie.setMaxAge(60*60*24*7);
				break;
			case "day":
				cookie.setMaxAge(60*60*24);
				break;
			case "none":
				cookie.setMaxAge(0);
			}
			response.addCookie(cookie);
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("lyQuery.servlet").forward(request, response);
		} else {
			//request.setAttribute("msg", "�û������������");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}*/
}
