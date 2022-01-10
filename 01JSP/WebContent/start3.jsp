<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
방문자의 나이는 <%=out.println(request.getParameter("age")); %>
방문자의 나이는 <%= getParameter("age"); %>
</body>
</html>