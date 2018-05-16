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
		width:200px;
		margin: 0 auto;
	}
	.page li{
		background-color:#fff;
		width: 18px;
		height:18px;
	}
	
	.page a{
		color:#3d3d3d;
	}
	
	h1{
		margin-top: 10px;
		text-align:center;
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
	<div>
		<ul class="clearfix page">
		<c:forEach begin="1" end="10" var="p">
			<li><a href="/ListPage?page=${p } ">${p}</a></li>
		</c:forEach>
		</ul>
	</div>
</body>
</html>