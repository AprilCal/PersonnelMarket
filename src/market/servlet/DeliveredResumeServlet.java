package market.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import market.busi.DeliveredBoxItemBusi;
import market.vo.DeliveredBoxItem;


public class DeliveredResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DeliveredBoxItemBusi dBusi = new DeliveredBoxItemBusi();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		System.out.println("customerId:"+customerId);
		
		List<DeliveredBoxItem> list = dBusi.getDeliveredResumeList(customerId);
		request.getSession().setAttribute("list", list);
		
		for(DeliveredBoxItem d:list) {
			System.out.println("item:"+d.getResumeId());
		}
		
		response.sendRedirect("DeliveredResume.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
