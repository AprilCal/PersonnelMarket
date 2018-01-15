package market.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market.busi.BusiException;
import market.busi.RecruitmentBusi;
import market.vo.Enterprise;
import market.vo.Recruitment;

/**
 * Create by AprilCal on 2018.1.15
 */
public class ReleaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	RecruitmentBusi rBusi = new RecruitmentBusi();
	
    public ReleaseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		Recruitment recruitment = null;
		
		String title = request.getParameter("title");
		String department = request.getParameter("department");
		String positon = request.getParameter("position");
		
		System.out.print("title:"+title+"department:"+department);
		//recruitment.setTitle(" ");
		
		/*try {
			rBusi.release(recruitment);
		} catch (BusiException e) {
			e.printStackTrace();
		}*/
		
		response.sendRedirect("EnterpriseMainPage.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
