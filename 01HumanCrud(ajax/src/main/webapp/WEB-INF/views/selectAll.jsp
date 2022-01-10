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
	
	
	$(document).ready(function() {
	//버튼
	var fObject =$(".form");
	$(".btnInsert").on("click",function() {
		fObject.attr("method","get");
		fObject.attr("action", "/ex/views/insert");
		fObject.submit();
		
	})
	$(".btnUpdate").on("click",function() {
		fObject.attr("method","get");
		fObject.attr("action","/ex/views/update");
		fObject.submit();
	})
	});
</script>
</head>
<body>
	select
	<form class="form" method="post">
	
	
	
	
	</form>
	<table class ='customers' width=100% border="1">
		<tr>
			<th style="width: 80px">이름</th>
			<th style="width: 80px">나이</th>
			<th style="width: 100px">키</th>
			<th style="width: 40px">생일</th>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.name}</a></td>
				<td>${dto.age}</td>
				<td>${dto.height}</td>
				<td><fmt:formatDate value="${dto.birthday}" pattern="yyyy-MM-dd HH:mm"/></td>
			</tr>
		</c:forEach>

</table>
	<button type="submit" class="btnInsert">사람 추가</button>
	<button type="submit" class="btnUpdate">사람 추가</button>
</body>
</html>