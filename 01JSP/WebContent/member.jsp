<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
boolean isMember =false;
String id = (String) session.getAttribute("id");
String pw = (String) session.getAttribute("pw");
if (id != null&&pw!= null){
	isMember = true;
}

if (!isMember)
response.sendRedirect("login.html");
%>
<%= id %> 님,당신은 회원이 맞습니다. <br>
<a href=login.html>로그아웃 </a>
</body>
</html>