package market.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market.busi.RecruitmentBusi;
import market.vo.Recruitment;

/**
 * create by AprilCal on 2018.1.15
 */
public class RecruitmentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RecruitmentBusi rBusi = new RecruitmentBusi();
    public RecruitmentDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("this is recuritment detail.");
		int recruitmentId = Integer.parseInt(request.getParameter("recruitmentId"));
		
		Recruitment recruitment = rBusi.getRecruitmentById(recruitmentId);
		request.getSession().setAttribute("recruitment", recruitment);
		
		response.sendRedirect("RecruitmentDetailPage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
