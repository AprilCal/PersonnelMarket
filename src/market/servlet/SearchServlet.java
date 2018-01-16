package market.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market.busi.BusiException;
import market.busi.RecruitmentBusi;
import market.vo.Recruitment;

/**
 * create by AprilCal on 2018/1/16
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RecruitmentBusi rBusi = new RecruitmentBusi();
	
    public SearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identity = request.getParameter("identity");
		String scope = request.getParameter("scope");
		String keyword = request.getParameter("keyword");
		if(identity.equals("customer")) {
			if(scope.equals("position")) {
				try {
					List<Recruitment> list = (List<Recruitment>)rBusi.getRecruitmentByPosition(keyword);
					request.getSession().setAttribute("list", list);
					response.sendRedirect("CustomerMainPage.jsp");
				} catch (BusiException e) {
					e.printStackTrace();
				}
			}
			if(scope.equals("department")) {
				
			}
			if(scope.equals("title")) {
				try {
					List<Recruitment> list = (List<Recruitment>)rBusi.
					request.getSession().setAttribute("list", list);
					response.sendRedirect("CustomerMainPage.jsp");
				} catch (BusiException e) {
					e.printStackTrace();
				}
			}
			if(scope.equals("location")) {
				
			}
			
		}
		if(identity.equals("enterprise")) {
			
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
