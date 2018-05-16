package org.study.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.dao.Employee;
import org.study.dao.EmployeeDaoImpl;
import org.study.dao.EmployeeService;

/**
 * Servlet implementation class ListServlet
 */

@WebServlet("/ListPage")
public class ListEmpPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService service = new EmployeeDaoImpl();
	
@Override	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	
			int page = Integer.parseInt(request.getParameter("page"));
			List<Employee> list = service.listEmployeeByPage(page);
			
			request.setAttribute("list", list);
			request.setAttribute("page", page);
			try {
				request.getRequestDispatcher("/WEB-INF/views/ListPageEmp.jsp").forward(request, response);
				
			} catch (ServletException se) {
				
			} catch (IOException ioe) {
				
			}
		}


}
