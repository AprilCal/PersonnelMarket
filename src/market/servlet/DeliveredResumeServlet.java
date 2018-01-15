package market.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import market.busi.RecruitmentBusi;
import market.busi.SubmitBusi;


public class DeliveredResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SubmitBusi sBusi = new SubmitBusi();
	RecruitmentBusi rBusi = new RecruitmentBusi();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		System.out.println("customerId:"+customerId);
		
		
		response.sendRedirect("DeliveredResume.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
