package market.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market.busi.EnterpriseBusi;
import market.busi.SubmitBusi;

/**
 * Create by AprilCal on 2018.1.16
 */
public class RefuseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnterpriseBusi eBusi = new EnterpriseBusi();
    private SubmitBusi sBusi = new SubmitBusi();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefuseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Enterprise enterprise = (Enterprise)request.getSession().getAttribute("enterprise");
			String primaryKey = request.getParameter("primaryKey");
			
			String[] array = primaryKey.split("_");
			int resumeId = Integer.parseInt(array[0]);
			int enterpriseId = Integer.parseInt(array[1]);
			int recruitmentId = Integer.parseInt(array[2]);
			
			sBusi.refuseResume(resumeId, enterpriseId, recruitmentId);
			eBusi.decResumeRecv(enterpriseId);
			
			request.setAttribute("msg", "已拒绝!");
			request.getRequestDispatcher("ResumeBox.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
