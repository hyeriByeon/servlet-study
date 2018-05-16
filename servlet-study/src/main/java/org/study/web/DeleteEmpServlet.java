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

@WebServlet("/DeleteServlet")
public class DeleteEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService service = new EmployeeDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			List<Employee> list = service.listEmployee();
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			if (!service.deleteEmployee(id)) {
				request.setAttribute("error", "Delete 실패");
			}
			
			request.getRequestDispatcher("/WEB-INF/views/ListPageEmp.jsp?page=1").forward(request, response);
			
		}

}
