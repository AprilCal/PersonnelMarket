package market.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market.busi.EnterpriseBusi;
import market.busi.SubmitBusi;

/**
 * Create by AprilCal on 2018.1.16
 */
@WebServlet("/AdmitServlet")
public class AdmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EnterpriseBusi eBusi = new EnterpriseBusi();
    private SubmitBusi sBusi = new SubmitBusi();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Enterprise enterprise = (Enterprise)request.getSession().getAttribute("enterprise");
		String primaryKey = request.getParameter("primaryKey");
		String[] array = primaryKey.split(",");
		int resumeId = Integer.parseInt(array[0]);
		int enterpriseId = Integer.parseInt(array[1]);
		int recruitmentId = Integer.parseInt(array[2]);
		sBusi.delete(resumeId, enterpriseId, recruitmentId);
		eBusi.decResumeRecv(enterpriseId);
		
		request.setAttribute("msg", "删除成功!");
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
