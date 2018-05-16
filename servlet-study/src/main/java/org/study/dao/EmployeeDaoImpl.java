package org.study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import sec.PasswordAuthentication;

public class EmployeeDaoImpl implements EmployeeService {
	
	private static final String URL =  "jdbc:mysql://192.168.0.211/test_db?useSSL=no&characterEncoding=utf8";
	private static final String USER_NAME = "hyeri";
	private static final String PASSWORD = "bha11530";
	
	public static Connection getConn() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
	
	@Override
	public boolean saveEmployee(Employee e) {
		int status = 0;
		try {
//			해싱을 정의해둔 클래스
			PasswordAuthentication passAuth = new PasswordAuthentication();
			
			Connection conn = getConn();
			String sql = "insert into user (name, password, email, country) values (?, ?, ?, ?)";
			PreparedStatement pre = conn.prepareStatement(sql);
			
			pre.setString(1, e.getName());
//			hashing 
			String token = passAuth.hash(e.getPassword().toCharArray());
			pre.setString(2, token);
			pre.setString(3, e.getEmail());
			pre.setString(4, e.getCountry());
			
			status = pre.executeUpdate();
			
			conn.close();
			pre.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return status == 1? true: false;
	}

	@Override
	public List<Employee> listEmployee() {
		List<Employee> list = null;
		ResultSet set;
		try {
			Connection conn = getConn();
			list = new ArrayList<>();
			Statement state = conn.createStatement();
			
			set = state.executeQuery("select * from user");
			
			while(set.next()) {
				Employee e = new Employee();
				e.setId(set.getInt("id"));
				e.setName(set.getString("name"));
				e.setPassword(set.getString("password"));
				e.setEmail(set.getString("email"));
				e.setCountry(set.getString("country").toUpperCase());
				
				list.add(e);
			}
			
			state.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean deleteEmployee(int id) {
		int status = 0;
		try {
			Connection conn = getConn();
	
			PreparedStatement pre = conn.prepareStatement("delete from user where id = ?");
			
			pre.setInt(1, id);
			
			status = pre.executeUpdate();
			
			conn.close();
			pre.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status == 1 ? true : false;
	}

	@Override
	public boolean updateEmployee(Employee e) {
		int status = 0;
		// 직원정보를 우선적으로 확인
		try {
			Connection conn = getConn();
	
			PreparedStatement pre = conn.prepareStatement("update user set name = ?, email = ?, country= ?  where id = ?");
			pre.setString(1, e.getName());
			pre.setString(2, e.getEmail());
			pre.setString(3, e.getCountry());
			pre.setInt(4, e.getId());
			
			status = pre.executeUpdate();
			
			conn.close();
			pre.close();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return status == 1 ? true : false;
	}

	@Override
	public Employee listEmployee(int id) {
		Employee e = new Employee();
		int status = 0;
		try {
			Connection conn = getConn();
			String sql = "select name, password, email, country from user where id = ?";
			
			PreparedStatement pre = conn.prepareStatement(sql);
			
			pre.setInt(1, id);
			
			ResultSet set = pre.executeQuery();
			
			while (set.next()) {
				e = new Employee();
				

				String name = set.getString(1);
				String password = set.getString(2);
				String email = set.getString(3);
				String country = set.getString(4);
				
				e.setId(id);
				e.setName(name);
				e.setPassword(password);
				e.setEmail(email);
				e.setCountry(country);
			}
			
			set.close();
			conn.close();
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		
		return e;
	}

	@Override
	public List<Employee> listEmployeeByPage(int page) {
		List<Employee> list = null;
		int status = 0;
		try {
			Connection conn = getConn();
			String sql = "select id, name, password, email, country from user limit ?, ?";
			
			PreparedStatement pre = conn.prepareStatement(sql);
			
			if(page <= 0) {
				page = 1;
			}
			
			list = new ArrayList<>();
			
			pre.setInt(1, (page - 1) * EmployeeService.pager );
			pre.setInt(2, EmployeeService.pager);
			
			ResultSet set = pre.executeQuery();
			
			while (set.next()) {
				Employee e = new Employee();
				
				int id = set.getInt(1);
				String name = set.getString(2);
				String password = set.getString(3);
				String email = set.getString(4);
				String country = set.getString(5);
				
				e.setId(id);
				e.setName(name);
				e.setPassword(password);
				e.setEmail(email);
				e.setCountry(country);
				
				list.add(e);
			}
			
			set.close();
			conn.close();
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int maxPage() {
	
      int count=0;
	      try {
	         

		Connection conn = getConn();
	         
	         if (conn != null) {
	            } else {
	                System.out.println("DB연결 실패 - maxpage");
	            }

	         PreparedStatement pstmt = conn.prepareStatement("SELECT count(*) FROM user");
	         
	         ResultSet rs = pstmt.executeQuery();
	         while (rs.next()) {
	            count = rs.getInt("count(*)");
	         }
	         
	         rs.close();
	         pstmt.close();
	         conn.close();
	      }  catch (SQLException e) {
	         // TODO �ڵ� ������ catch ���
	         e.printStackTrace();
	      }
	      int maxpage=count/pager;
	      if(count%pager!=0) {//나머지가 있으면
	         maxpage++;
	      }
	      return maxpage;
		   
	}

}
