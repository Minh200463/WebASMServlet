package poly.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.DAO.FavoriteDAO;
import poly.DAO.UserDAO;
import poly.DAO.VideoDAO;
import poly.common.PageInfo;
import poly.common.PageType;
import poly.model.Favorite_TB;
import poly.model.User_TB;
import poly.model.Video_TB;
import poly.serve.SessionUtils;

/**
 * Servlet implementation class FavoriteServlet
 */
@WebServlet("/page-favorite")
public class FavoriteServlet extends HttpServlet {


	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User_TB user = SessionUtils.getUserFromSession(request, "user");
			VideoDAO vdao = new VideoDAO();
			List<Video_TB> list = vdao.findByUser(user.getId());
	
			for (Video_TB v : list) {
				System.out.println(v);
			}
			
			request.setAttribute("video", list);
			
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_VIDEO_LIKE_PAGE);
	}

}
