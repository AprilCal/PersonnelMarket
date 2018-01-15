package market.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import market.busi.BusiException;
import market.busi.EnterpriseBusi;
import market.busi.RecruitmentBusi;
import market.vo.Enterprise;
import market.vo.Recruitment;

/**
 * Create by AprilCal on 2018.1.15
 */
public class ReleaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	RecruitmentBusi rBusi = new RecruitmentBusi();
	EnterpriseBusi eBusi = new EnterpriseBusi();
	
    public ReleaseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		Recruitment recruitment = new Recruitment();
		Enterprise enterprise = (Enterprise)request.getSession().getAttribute("enterprise");
		
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String department = request.getParameter("department");
		String position = request.getParameter("position");
		String time=new Timestamp(System.currentTimeMillis()).toString(); 
		int enterpriseId = enterprise.getEnterpriseId();
		int salary_low = Integer.parseInt(request.getParameter("salary_low"));
		int salary_high = Integer.parseInt(request.getParameter("salary_high"));
		String experiment = "";
		String positionDescription = request.getParameter("positionDescription");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		boolean deleted = false;
		String techStack = request.getParameter("techStack");
		String positionRequirement = request.getParameter("positionRequirement");
		
		recruitment.setTitle(title);
		recruitment.setDepartment(department);
		recruitment.setPosition(position);
		recruitment.setTime(time);
		recruitment.setEnterpriseId(enterpriseId);
		recruitment.setSalary_low(salary_low);
		recruitment.setSalary_high(salary_high);
		recruitment.setExperiment(experiment);
		recruitment.setPositionDescription(positionDescription);
		recruitment.setProvince(province);
		recruitment.setCity(city);
		recruitment.setDeleted(deleted);
		recruitment.setTechStack(techStack);
		recruitment.setPositionRequirment(positionRequirement);
		
		try {
			rBusi.release(recruitment);
		} catch (BusiException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("EnterpriseMainPage.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
