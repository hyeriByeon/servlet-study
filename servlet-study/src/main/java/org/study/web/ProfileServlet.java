package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.dao.Profile;
import org.study.dao.User;
import org.study.dao.UserService;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserService();
//		Cookie[] cookies = request.getCookies();
//		
//		if(cookies == null) {
//			request.setAttribute("error", "최초 로그인이 필요합니다.");
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//			
//			return;
//		}
//		
//		
//		for(Cookie cookie : cookies) {
//			if(cookie.getName().equals("id")) {
//				//아이디에 해당하는 이름을 가져오셔야 합니다
//				Profile profile = service.getProfile(cookie.getValue());
//				request.setAttribute("profile", profile);
//				request.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(request, response);
//				
//				return;
//			}
//		}
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if(user != null) {
			Profile pro = service.getProfile(user.getUserId());
			
			request.setAttribute("profile", pro);
			request.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(request, response);
		} 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
