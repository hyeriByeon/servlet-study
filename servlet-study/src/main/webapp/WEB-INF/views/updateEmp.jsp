<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/add.js"></script>
<title>Insert title here</title>
</head>
<body>

	<h1>직원 정보 수정</h1>

	<form action="/Update2" method="post" onsubmit="return checkInput()">
	<input type="hidden" name="id" value="${emp.id }" />
		<table>
			<tr>
				<td>Name:</td><td><input type="text" name="name" value="${emp.name }" /></td>
			</tr>
			<tr>
				<td>Password:</td><td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Email:</td><td><input type="email" name="email" value="${emp.email } "/></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><select name="country" id="con" style="width:150px;height:28px;margin:10px 0">
						<option value="KOR">한국</option>
						<option value="USA">USA</option>
						<option value="UK">UK</option>
						<option value="ETC">기타</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="sub" value="정보변경" /></td>
			</tr>
		</table>
	</form>
	<script>
		$("#con").val("${emp.country}").prop("selected", true);
	</script>
</body>
</html>