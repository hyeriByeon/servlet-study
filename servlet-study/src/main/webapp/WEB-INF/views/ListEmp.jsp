<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, minimum-scale=1.0, initial-scale=1.0, maximum-scale=2.0, minimum-scale=1.0" />
<title>Insert title here</title>
</head>
<jsp:include page ="/link.html" flush="false" />
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
		margin-top: 40px;
		border: 1px solid #3d3d3d;
	}
	
	tr{
		border: 1px solid #3d3d3d;
	}
	
	.ha{
		width: 50px;
	}
</style>
<body>
	<div class="wrapList">
		<table>
		<caption>직원 리스트</caption>
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
</body>
</html>