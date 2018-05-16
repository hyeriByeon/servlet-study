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

@WebServlet("/UpdateServlet")
public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService service = new EmployeeDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Employee e = service.listEmployee(id);
		
		request.setAttribute("emp", e);
		
		request.getRequestDispatcher("/WEB-INF/views/updateEmp.jsp").forward(request, response);
		
//		e.setId(id);
//		e.setName(request.getParameter("name"));
//		e.setPassword(request.getParameter("password"));
//		e.setEmail(request.getParameter("email"));
//		e.setCountry(request.getParameter("country"));
//		
//		if(service.updateEmployee(e)) {
//			response.sendRedirect("/ListServlet");
//		}
//		request.setAttribute("error", "에러다잉");
//		response.sendRedirect("/ListServlet");
//		
	
	}

}
