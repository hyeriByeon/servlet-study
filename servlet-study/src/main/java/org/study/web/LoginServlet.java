package org.study.web;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.study.dao.User;
import org.study.dao.UserService;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	UserService service = new UserService();
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String orgPath = request.getParameter("orgPath");
		
		System.out.println("여긴 로그인 servlet :" + request.getParameter("orgPath"));
		
		User user = new User(userId, userPw);
		
		if(service.isValidUser(user)) {
//			Cookie cookie = new Cookie("id", userId); 
			HttpSession session = request.getSession();
			//세션을 통해 전달.
			session.setAttribute("user", user);
		
			request.setAttribute("name", user.getName());
			
//			request.setAttribute("id", userId);
//			response.addCookie(cookie);
			if(orgPath.equals("/ListPage?page=1")) {
				response.sendRedirect(orgPath);
//				request.getRequestDispatcher(orgPath).forward(request, response);

			}else {
			request.getRequestDispatcher("/ProfileServlet").forward(request, response);
			}
			
		}else {
			request.setAttribute("error", "당신의 아이디/비밀번호가 일치하지 않습니다.");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
		
		
//		request.getRequestDispatcher("link.html").include(request, response);
		
//		if(userPw.equals("servlet")) {
//			Cookie cookie = new Cookie("name", URLEncoder.encode(userName, "UTF-8"));
//			cookie.setMaxAge(60*1);
//			out.print("You are successfully logged in!");
//			out.print("<br>Welcome " + userName);
//			
//			response.addCookie(cookie);
//		}else {
//			out.print("Sorry UserName or Password Error!");
//			RequestDispatcher rd = request.getRequestDispatcher("login.html");
//			rd.include(request, response);// 포함해서 ..
//		}
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	
}
