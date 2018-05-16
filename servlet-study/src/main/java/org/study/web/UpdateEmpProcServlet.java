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

import sec.PasswordAuthentication;

/**
 * Servlet implementation class ListServlet
 */

@WebServlet("/Update2")
public class UpdateEmpProcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService service = new EmployeeDaoImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PasswordAuthentication passAuth = new PasswordAuthentication();

		int id = Integer.parseInt(request.getParameter("id"));
		
		Employee e = service.listEmployee(id);
		if(passAuth.authenticate(request.getParameter("password").toCharArray(), e.getPassword())) {
			//pass가 인증이 되면
			e.setId(id);
			e.setName(request.getParameter("name"));
			e.setEmail(request.getParameter("email"));
			e.setCountry(request.getParameter("country"));
			
			if(service.updateEmployee(e)) {
				response.sendRedirect("/ListPage?page=1");
			}else {
			request.setAttribute("error", "직원 정보 변경에 실패했습니다.");
			request.setAttribute("emp", e);
			request.getRequestDispatcher("/WEB-INF/views/updateEmp.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("error", "비밀번화가 일치하지 않습니다.");
			request.setAttribute("emp", e);
			request.getRequestDispatcher("/WEB-INF/views/updateEmp.jsp").forward(request, response);
		}
	
	}

}
