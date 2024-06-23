package poly.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;




public class PageInfo {
	public static Map<PageType, PageInfo> pageRoute = new HashMap();
	
	static {
		//ADMIN
		pageRoute.put(PageType.USER_MANAGEMENT_PAGE, new PageInfo("User Management", "/web/admin/user.jsp", null));
		pageRoute.put(PageType.VIDEOS_MANAGEMENT_PAGE, new PageInfo("Videos Management", "/web/admin/videos.jsp", null));
		pageRoute.put(PageType.LISTALL_MANAGEMENT_PAGE, new PageInfo("List All Videos", "/web/admin/listall.jsp", null));
		
		//USER
		pageRoute.put(PageType.SITE_VIDEOS_PAGE, new PageInfo("Home", "/web/home/videos.jsp", null));
		pageRoute.put(PageType.SITE_VIDEO_INFO_PAGE, new PageInfo("List All Videos", "/web/home/video-infomation.jsp", null));
		pageRoute.put(PageType.SITE_VIDEO_LIKE_PAGE, new PageInfo("Like Videos", "/web/home/video-like.jsp", null));
		pageRoute.put(PageType.SITE_CHANGE_PASS_PAGE, new PageInfo("Change Password", "/web/home/changepassword.jsp", null));
		
		//REGISTER 
		pageRoute.put(PageType.SITE_REGISTER_PAGE, new PageInfo("REGISTER", "/web/sign-up/form-signup.jsp", null));
		
		//LOGIN
		pageRoute.put(PageType.SITE_LOGIN_PAGE, new PageInfo("LOGIN", "/web/sign-in/form-signin.jsp", null));
		
		//REPORT
		pageRoute.put(PageType.SITE_REPORT_PAGE, new PageInfo("REPORT", "/web/report/reportvideo.jsp", null));
		
		//SEND MAIL
		pageRoute.put(PageType.SITE_SEND_MAIL_PAGE, new PageInfo("SEND MAIL", "/web/home/sendmail.jsp", null));
		
	}
	//Page index ADMIN
	public static void prepareAndForward(HttpServletRequest request, HttpServletResponse respon, PageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/indexadmin.jsp").forward(request, respon);
	}
	//Page index USER
	public static void prepareAndForwardSite(HttpServletRequest request, HttpServletResponse respon, PageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/indexHome.jsp").forward(request, respon);
	}
	
	//Page LOGIN
	
	public static void prepareAndForwardSign(HttpServletRequest request, HttpServletResponse respon, PageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/indexSign.jsp").forward(request, respon);
	}
	
	private String title;
	private String contentUrl;
	private String scriptUrl;
	
	
	
	public PageInfo(String title, String contentUrl, String scriptUrl) {
		super();
		this.title = title;
		this.contentUrl = contentUrl;
		this.scriptUrl = scriptUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	public String getScriptUrl() {
		return scriptUrl;
	}
	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}
	
	
	
}
