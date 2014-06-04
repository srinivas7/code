<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

 HttpSession session1 = request.getSession(false); 
out.println(session.getAttribute("fname"));
out.println(session.getAttribute("lname"));
out.println(session.getAttribute("email"));
out.println(session.getAttribute("vehicle"));
out.println(session.getAttribute("country"));

%>
<form action="logoutservlet" method="post" name="logoutform" >
	<center>
	<input type="submit" value="logout!"  name="logout" >
	</center>
	</form>
</body>
</html>