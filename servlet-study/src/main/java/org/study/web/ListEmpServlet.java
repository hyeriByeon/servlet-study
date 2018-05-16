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

@WebServlet("/ListServlet")
public class ListEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService service = new EmployeeDaoImpl();
	
@Override	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) {
			List<Employee> list = service.listEmployee();
			
			request.setAttribute("list", list);
			try {
				request.getRequestDispatcher("/WEB-INF/views/ListEmp.jsp").forward(request, response);
			} catch (ServletException se) {
				
			} catch (IOException ioe) {
				
			}
		}


}
