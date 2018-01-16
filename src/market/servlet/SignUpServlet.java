package market.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market.busi.CustomerBusi;
import market.dao.CustomerDao;
import market.dao.EnterpriseDao;
import market.vo.Customer;
import market.vo.Enterprise;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerBusi cBusi = new CustomerBusi();
    private EnterpriseDao eDao = new EnterpriseDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String identity = request.getParameter("identity");
		String time=new Timestamp(System.currentTimeMillis()).toString(); 
		
		if(identity.equals("customer")) {
			Customer customer = new Customer();
			customer.setCustomerName(request.getParameter("customerName"));
			customer.setTime(time);
			customer.setPassword(request.getParameter("password"));
			customer.setTel(request.getParameter("tel"));
			customer.setMail(request.getParameter("mail"));
			customer.setMessageNum(11);
			customer.setDeleted(false);
			try {
				cBusi.register(customer, request.getParameter("rePassword"));
			} catch (Exception e) {
				request.setAttribute("msg", "！！！！！！！");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
				e.printStackTrace();
			}
		}
		
		if(identity.equals("enterprise")) {
			Enterprise enterprise = new Enterprise();
			enterprise.setEnterpriseName(request.getParameter(""));
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
