package org.study.etc;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MySearcher")
public class MySearcher extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String search = URLEncoder.encode(req.getParameter("name"), "UTF-8");

		String searchURL = "https://www.google.com/search?q=" + search;
		
		res.sendRedirect(searchURL);
		
	}
	
}
