package poly.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.DAO.VideoDAO;
import poly.common.PageInfo;
import poly.common.PageType;
import poly.model.Report_TB;
import poly.serve.SessionUtils;



/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/report")
public class ReportServlet extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
	
			if(method.equalsIgnoreCase("POST")) {
				//FIND VIDEO BY YEAR
				VideoDAO vdao = new VideoDAO();
				Integer year = Integer.valueOf(request.getParameter("year"));
				List<Report_TB> list = vdao.showByYear(year);	
				request.setAttribute("report", list);
			}
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_REPORT_PAGE);
	}
}
