<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../../js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="../../js/add.js"></script>
<title>Insert title here</title>
</head>
<style>

	input{
		height: 20px;
		margin: 10px 0;
	}
	
	.sub{
		width: 247px;
		height: 30px;
		background-color:#3d3d3d;	
		border: 1px solid #3d3d3d;
		color:#fff;
	}
	
	.wrap2{
		overflow:hidden;
		width: 69%;
		margin: 0 auto;
	}
	
	.add{
		margin-top:20px;
		text-align:center;
	}
	.addfor{
		width:320px;
		margin:30px auto 0 auto;
	}
	table{
		width: 320px;
	}
</style>
<jsp:include page ="/link.html" flush="false" />
<body>
${error}
<div class="wrap2">
	<h1 class="add">Add New Employee</h1>
	<div class="addfor">
	<form action="SaveServlet" method="post" name="addInfor" onsubmit="return checkInput()">
	
		<table>
			<tr>
				<td>Name:</td><td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Password:</td><td><input type="password"  name="password" /></td>
			</tr>
			<tr>
				<td>Email:</td><td><input type="email"  name="email" /></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><select name="country" style="width:150px;height:28px;margin:10px 0">
						<option value="KOR">한국</option>
						<option value="USA">USA</option>
						<option value="UK">UK</option>
						<option value="ETC">기타</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="sub" value="직원추가" /></td>
			</tr>
		</table>
	</form>
	</div>
</div>
</body>
</html>