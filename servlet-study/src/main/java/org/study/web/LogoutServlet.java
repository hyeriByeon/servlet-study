package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.dao.User;
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		Cookie[] cookies = request.getCookies();
//		Cookie cc;
//		
//		if(cookies == null) {
//			request.setAttribute("error", "최초 로그인이 필요합니다.");
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//			return;
//		}
//		
//		
//		for(Cookie cookie : cookies) {
//			System.out.println(cookie.getName());
//			if(cookie.getName().equals("id")) {
//				cc = new Cookie("id", null);
//				cc.setMaxAge(0);
//				
//				response.addCookie(cc);
//			
//				response.sendRedirect("/index.jsp");
//				
//				return;
//			}
//		}
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user != null) {
			session.invalidate();
			response.sendRedirect("/index.jsp");
		}else {
			request.setAttribute("error", "최초 로그인이 필요합니다.");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
			
	}

}
