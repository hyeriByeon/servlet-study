<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.*" %>
<%@ page import="org.study.dao.Employee" %>
<%@ page import="org.study.dao.EmployeeDaoImpl" %>
<%@ page import="org.study.dao.EmployeeService" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, minimum-scale=1.0, initial-scale=1.0, maximum-scale=2.0, minimum-scale=1.0" />
<title>Insert title here</title>
</head>
<jsp:include page ="/link.html" flush="false" />
<% EmployeeService service = new EmployeeDaoImpl(); %>
<style>
	body{
		width: 100%;
	}
	.wrapList{
		width: 89%;
		margin: 0 auto;
	}
	
	.wrapList a{
		color:#3d3d3d;
	}
	
	caption{
		margin-bottom: 30px;
	}
	
	table{
		width: 600px;
		margin: 40px auto 0 auto;
		border: 1px solid #3d3d3d;
		text-align:center;
	}
	
	tr{
		height:30px;
	}
	
	.ha{
		width: 50px;
	}
	.page{
		width:600px;
		
		position: absolute;
		left: 36%;
		text-align:center;
		margin: 10px auto 0 auto;
	}
	.page li{
		background-color:#fff;
		width: 25px;
		height:25px;
	}
	
	.page a{
		color:#3d3d3d;
	}
	
	h1{
		margin-top: 10px;
		text-align:center;
	}
	
	.btn{
		background-color:#3d3d3d;
		border:0;
		color:#fff;
	}
</style>
<body>
	<div class="wrapList">
	<h1>직원 정보</h1>
		<table>
			<tr>
				<th class="ha">Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Country</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items='${list }' var = 'emp'>
			<tr>
				<td class="ha">${emp.id} </td>
				<td>${emp.name} </td>
				<td>${emp.email} </td>
				<td>${emp.country} </td>
				<td><a href="/UpdateServlet?id=${emp.id }">Edit</a></td>
				<td><a href="/DeleteServlet?id=${emp.id }">Delete</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div class="page">
<% 
	int a=Integer.parseInt(request.getParameter("page"));
	int pagestart=1+((a-1)/10)*10;
	if(pagestart!=1){%>
		<ul>
			<li><a href="/ListPage?page=<%=pagestart-1%>">
			<input type="button" value="<<" class="btn btn-sm btn-info"></a></li>
<%}
	for(int i=pagestart;i<pagestart+10&&i<=service.maxPage();i++){ %>
	   <li>
	   <a href="/ListPage?page=<%=i%>" class="pageidx"><%=i%></a></li>
	<%} 
if(pagestart+10<service.maxPage()){%>
		<li>
		<a href="/ListPage?page=<%=pagestart+10%>">
		<input type="button" value=">>" class="btn btn-sm btn-info"></a>
		</li>
<%} %>
		</ul>
	</div>
</body>
</html>