package poly.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import poly.common.PageInfo;
import poly.common.PageType;
import poly.servlet.HomePageServlet;
/**
 * Servlet implementation class SendMailServlet
 */
@MultipartConfig()
@WebServlet("/SendMail")
public class SendMailServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		if(method.equalsIgnoreCase("POST")) {
			request.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			
			
			
			
			String username = "Kuidndjj@gmail.com";
			String password = "titg fmga vgkq bfpk";
			//Tạo Properties để thiết lập cài đặt cấu hình kết nối với SMTP
			Properties props = new Properties();
			props.setProperty("mail.smtp.auth", "true"); //Đặt thành "true" để yêu cầu xác thực khi kết nối với máy chủ SMTP.
			props.setProperty("mail.smtp.starttls.enable", "true"); //Đặt thành "true" để yêu cầu xác thực khi kết nối với máy chủ SMTP.
			props.setProperty("mail.smtp.host", "smtp.gmail.com"); //Địa chỉ của máy chủ SMTP (trong trường này, là "smtp.gmail.com" cho Gmail).
			props.setProperty("mail.smtp.port", "587"); //Cổng kết nối SMTP (trong trường này, là cổng 587).
			
			
			
			//Kết nối Smtp Serve
			//Tạo Authenticator để xác thực với máy chủ SMTP
			Authenticator auth = new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					//cung cấp thông tin xác thực
					return new PasswordAuthentication(username, password);
				}
			};
			//Session là một lớp trong thư viện Java Mail API, được sử dụng để tạo phiên làm việc để gửi và nhận email.
			Session session = Session.getInstance(props, auth);
			//props chứa các cài đặt cần thiết cho việc thiết lập kết nối SMTP
			//auth cung cấp thông tin xác thực cho kết nối SMTP
			
			
			//Lấy dữ liệu form input
			String mailTo = request.getParameter("mail_to");
			String mailSubjet = request.getParameter("mail_subject");
			String mailContent = request.getParameter("content");
			
			
			try {
				
				
				/*
				 * 
				 */
				
				//Thêm dữ liệu vào phần thân của email
				MimeBodyPart part = new MimeBodyPart();
				
				//DataHandler() được sử dụng để xử lý dữ liệu và làm cho nó có thể truyền qua mạng hoặc qua giao diện người dùng.
			
				part.setText(mailContent); // dùng MimeMessase.settext() hoặc MimeBodyPart.settext() để truyền nội dung 
				
				/*
				 * 
				 */
				
				//Tạo Multipart để thêm nhiều phần như file, văn bản, hình ảnh...
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(part); //Tạo phần thân và thêm dữ liệu từ part vào
			
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
				message.setSubject(mailSubjet);
				message.setText(mailContent); 
//				message.setContent(multipart);
					
//				message.saveChanges();
//				message.setReplyTo(message.getFrom());
				Transport.send(message);
				request.setAttribute("message", "Gửi mail thành công!");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "Gửi mail <b>không</b> thành công!");
				System.out.println(e);
			}
		}
		String watch = request.getParameter("watch");
		String URL = "http://localhost:8080/WebASMServlet/page-infomation?watch="+watch;
		request.setAttribute("link", URL);
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_SEND_MAIL_PAGE);
	}

}
