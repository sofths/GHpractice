<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	insert
	<form action="/ex/insert" method="post">
		이름<input type="text" name='name'>
		나이<input type="text" name='age'>
		키<input type="text" name='height'>
		생년월일<input type="datetime-local" name='birthday'>
		<input type="submit" value="제출">
		</form>
		<a href="/ex/insert?name=${dto.name}&age=${dto.age }&height=${dto.height }&birthday=${dto.birthday } ">등록</a>
	</body>
</html>