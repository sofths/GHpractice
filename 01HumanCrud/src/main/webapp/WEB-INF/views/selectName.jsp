<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	select
	
	<table class ='customers' width=100% border="1">
		<tr>
		<th style="width: 80px">선택</th>
			<th style="width: 80px">이름</th>
			<th style="width: 80px">나이</th>
			<th style="width: 100px">키</th>
			<th style="width: 40px">생일</th>
		</tr>
			<tr>
			<td><a href="/ex/delete?name=${dto.name }">삭제</a></td>
				<td>${dto.name}</td>
				<td>${dto.age}</td>
				<td>${dto.height}</td>
				<td><fmt:formatDate value="${dto.birthday}" pattern="yyyy-MM-dd"/></td>
			</tr>

	
</table>

	<fmt:formatDate value="${dto.birthday}" pattern="yyyy-MM-dd HH:mm"/>
	<fmt:formatDate pattern="yyyy-MM-dd'T' HH:mm" value = "${dto.birthday }"/>
	<a href = '/ex/update?name=${dto.name }&age=${dto.age}&height=${dto.height}
	&birthday=<fmt:formatDate pattern="yyyy-MM-dd\'T\' HH:mm" value = "${dto.birthday }"/>'>수정</a>
<a href= '/ex/selectAll'>메인으로!</a>
</body>
</html>