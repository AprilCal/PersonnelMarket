package market.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market.busi.CustomerBusi;
import market.vo.Customer;

/**
 * create by yxw on 2018/1/13
 */
@WebServlet("/LoadUserMainPage")
public class LoadCustomerMainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	CustomerBusi cBusi = new CustomerBusi();
	
    public LoadCustomerMainPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = (Customer) request.getAttribute("customer");
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
