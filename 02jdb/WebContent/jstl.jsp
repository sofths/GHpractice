<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:out value = "hello World"/>
	<c:out value = "hello world">기본값 </c:out>
	<c:out value = "hello world" default="기본값 "></c:out>
		
	<c:out value = "${null }" default="기본값 "></c:out>	
	<br>
	<c:out value = "${null }"></c:out>	
실행결과가 없을때 default 가 찍힌다.
</body>
</html>