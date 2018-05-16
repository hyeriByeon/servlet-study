package org.study.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.dao.Country;
import org.study.dao.Employee;
import org.study.dao.EmployeeDaoImpl;
import org.study.dao.EmployeeService;

/**
 * Servlet implementation class SavaServlet
 */
@WebServlet("/SaveServlet")
public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeService service = new EmployeeDaoImpl();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee e = new Employee();
		
		e.setName(request.getParameter("name"));
		e.setPassword(request.getParameter("password"));
		e.setEmail(request.getParameter("email"));
		System.out.println(request.getParameter("email"));
		e.setCountry(request.getParameter("country"));
		
		if(service.saveEmployee(e)) {
			System.out.println("addSucceess");
			response.sendRedirect("/ListServlet");
//			request.getRequestDispatcher("/ListServlet").forward(request, response);
		}else {
			request.setAttribute("error", "직원추가에 실패했습니다.");
			request.getRequestDispatcher("/WEB-INF/views/addEmp.jsp").forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/addEmp.jsp").forward(request, response);
	}

}
