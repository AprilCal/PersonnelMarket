package market.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market.busi.RecruitmentBusi;
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
	
	
    public DeliverServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int recruitmentId = Integer.parseInt(request.getParameter("recruitmentId"));
		
		Recruitment recruitment = (Recruitment)rBusi.getRecruitmentById(recruitmentId);
		Submit submit = new Submit();
		
		
		
		int enterpriseId;
		enterpriseId = recruitment.getEnterpriseId();
		boolean readornot=false;
		boolean deleted=false;
		Customer customer = (Customer)request.getSession().getAttribute("customer");
		int customerId = customer.getCustomerID();
		
		//submit.setResumeId();
		submit.setEnterpriseId(enterpriseId);
		submit.setCustomerId(customerId);
		submit.setRecruitmentId(recruitmentId);
		submit.setDeleted(deleted);
		submit.setReadOrNot(readornot);
		submit.setState("unviewed");
		
		sBusi.deliver(submit);
		
		submit.setEnterpriseId(enterpriseId);
		submit.setDeleted(false);
		submit.setCustomerId(customerId);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
