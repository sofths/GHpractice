<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
여기는 s1

<%
	pageContext.setAttribute("test1", "text1");
	request.setAttribute("test2","test2");
	session.setAttribute("test3","test3");
	application.setAttribute("test4","test4");
	
%>
<%
	out.println(pageContext.getAttribute("test1"));
	out.println(request.getAttribute("test2"));
	out.println(session.getAttribute("test3"));
	out.println(application.getAttribute("test4"));
%>
<%-- <jsp:forward page="s2.jsp"/> --%>
</body>
</html>