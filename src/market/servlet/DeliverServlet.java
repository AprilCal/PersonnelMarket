package market.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market.busi.EnterpriseBusi;
import market.busi.RecruitmentBusi;
import market.busi.ResumeBusi;
import market.busi.SubmitBusi;
import market.vo.Customer;
import market.vo.Recruitment;
import market.vo.Submit;

/**
 * Create by AprilCal 2018.1.15
 */
public class DeliverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RecruitmentBusi rBusi = new RecruitmentBusi();
	private SubmitBusi sBusi = new SubmitBusi();
	private EnterpriseBusi eBusi = new EnterpriseBusi();
	private ResumeBusi resumeBusi = new ResumeBusi();
	
	
    public DeliverServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("this is deliver servlet");
		int recruitmentId = Integer.parseInt(request.getParameter("recruitmentId"));
		
		Recruitment recruitment = (Recruitment)request.getSession().getAttribute("recruitment");
		//Recruitment recruitment = (Recruitment)rBusi.getRecruitmentById(recruitmentId);
		
		Submit submit = new Submit();
		
		int resumeId;
		int enterpriseId;
		enterpriseId = recruitment.getEnterpriseId();
		boolean readornot=false;
		boolean deleted=false;
		Customer customer = (Customer)request.getSession().getAttribute("customer");
		int customerId = customer.getCustomerID();
		
		submit.setResumeId(recruitmentId);
		submit.setEnterpriseId(enterpriseId);
		submit.setCustomerId(customerId);
		submit.setRecruitmentId(recruitmentId);
		submit.setDeleted(deleted);
		submit.setReadOrNot(readornot);
		submit.setState("unviewed");
		
		//try {
			//sBusi.deliver(submit);
			//eBusi.incResuemRecv(enterpriseId);
		//}catch (SQLException e) {
			//request.setAttribute("msg", "不可重复投递简历!");
		//}
		//finally {
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("msg", "简历投递成功!");
			request.getRequestDispatcher("RecruitmentDetailPage.jsp").forward(request, response);
		//}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
