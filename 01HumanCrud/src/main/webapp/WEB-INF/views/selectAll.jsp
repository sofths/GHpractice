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
<script>
var result ='${msg}';
	
	if(result =='success') {
		alert("처리가 완료 되었습니다.")
	}
</script>
</head>
<body>
	select
	<table class ='customers' width=100% border="1">
		<tr>
			<th style="width: 80px">이름</th>
			<th style="width: 80px">나이</th>
			<th style="width: 100px">키</th>
			<th style="width: 40px">생일</th>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td><a href = "/ex/selectName?name=${dto.name}">${dto.name}</a></td>
				<td>${dto.age}</td>
				<td>${dto.height}</td>
				<td><fmt:formatDate value="${dto.birthday}" pattern="yyyy-MM-dd HH:mm"/></td>
			</tr>
		</c:forEach>

</table>
	<a href="/ex/insert">사람 추가</a>
	
</body>
</html>