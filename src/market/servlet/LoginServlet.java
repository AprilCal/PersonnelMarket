package market.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import market.busi.BusiException;
import market.busi.CustomerBusi;
import market.vo.Customer;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	/* 
	 * 1.判断登陆的类型
	 * 2.get name password;
	 * 3.busi。login(name,password);
	 * 4.成功，alert(success)->LoadMainPageServlet
	 * 5。失败。。。。
	 */
	
	private CustomerBusi cBusi = new CustomerBusi();
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println("name:"+username+"  password:"+password);
		
		try {
			Customer customer = cBusi.login(username, password);
			if(customer!=null) {
				request.getSession().setAttribute("customer", customer);
				request.getRequestDispatcher("CustomerMainPage.jsp").forward(request, response);
			}
		} catch (BusiException e) {
			e.printStackTrace();
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
