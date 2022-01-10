<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Jsp파일 
<a href="home.html">home</a>
<p> <% 
	String str="world";
for(int i=0;i<10;i++)
	out.println("hello"+str); 
	%>
</body>
</html>