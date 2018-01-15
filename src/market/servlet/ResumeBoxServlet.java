package market.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market.busi.ResumeBoxItemBusi;
import market.vo.ResumeBoxItem;

public class ResumeBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ResumeBoxItemBusi rBusi = new ResumeBoxItemBusi();
    public ResumeBoxServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("this is resumebox");
		
		int enterpriseId = Integer.parseInt(request.getParameter("enterpriseId"));
		System.out.println("enterpriseId:"+enterpriseId);
		try {
			List<ResumeBoxItem> list = rBusi.getList(enterpriseId);
			request.getSession().setAttribute("list", list);
			
			for(ResumeBoxItem r:list) {
				System.out.println(r.getRecruitmentTitle());
			}
			response.sendRedirect("ResumeBox.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
