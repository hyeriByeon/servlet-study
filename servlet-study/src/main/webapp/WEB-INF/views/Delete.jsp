<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<jsp:include page ="/link.html" flush="false" />
</head>
<body>
	${error}
	${delete}
	<h1>직원 삭제</h1>
	<form action="DeleteServlet" method="post">
		<input type="text" name="id" />
		<input type="submit" value="직원 삭제" />
	</form>
</body>
</html>