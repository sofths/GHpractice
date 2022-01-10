<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	update
	<form action="/ex/update" method="post">
		이름<input type="text" name='name' value="${humanDto.name }" readonly>
		나이<input type="text" name='age' value="${humanDto.age }"> 
		키<input	type="text" name='height' value="${humanDto.height }"> 
		
		<input type="datetime-local" name='birthday' 
		value= '<fmt:formatDate pattern="yyyy-MM-dd\'T\' HH:mm" value="${humanDto.birthday}" />'>
		<input type="submit" value="수정">
	</form>
</body>
</html>