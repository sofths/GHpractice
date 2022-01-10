<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
여기는 s2 
<%

out.println(pageContext.getAttribute("test1"));
out.println(request.getAttribute("test2"));
out.println(session.getAttribute("test3"));
out.println(application.getAttribute("test4"));
	
%>
</body>
</html>