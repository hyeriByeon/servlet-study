<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	${error}
	<form action="/ProfileServlet">
		ID: <input name ="userId" type="text" /><br />
		Password: <input name="userPw" type="password">
		<input type="submit" value="login" />
	</form>
</body>
</html>