<%@ page language="java"      pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="<%= request.getContextPath()%>/login.do" method="post">
		<input type="text" name="name" value=""/> 
		<input type="text" name="password" value=""/> 
		<input type="submit" /> 
	</form>

</body>
</html>