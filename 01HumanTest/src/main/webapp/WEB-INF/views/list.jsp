<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0;
	padding: 0;
}

.main {
	width: 1000px;
	text-align: center;
}

table {
	width: 1000px;
	border: 1px solid #444444;
	border-collapse: collapse;
	font-size: 13px;
}

#top {
	padding: 10px 0 10px 0;
	border-bottom: 1px solid #444444;
}

#bottom {
	padding: 10px 0 10px 0;
}

#btn {
	padding: 10px 0 10px 0;
	float: right;
}

#foot {
	padding-top: 10px;
}

th, tr, td {
	border: 1px solid #444444;
}

th {
	background-color: #E7EAED;
}
</style>


</head>

<body>
	<div class="main">
		<a href='/ex/human/insert'>입력</a>
		<a href='/ex/human/update'>수정</a>
		<a href='/ex/human/select'>검색</a>
		<a href='/ex/human/delete'>삭제</a>
		<a href='/ex'>리스트</a>
		</div>
		
		<table id='humanInfo'>
			<tr>
				<th style="width: 80px">이름</th>
				<th style="width: 80px">나이</th>
				<th style="width: 80px">키</th>
				<th style="width: 100px">생일</th>
			</tr>

			
					<c:forEach items="${list}" var="manDTO">
						<tr>
							<td>${manDTO.name}</td>
							<td>${manDTO.age}</td>
							<td>${manDTO.height}</td>
							<td>${manDTO.birthday}</td>
						</tr>
					</c:forEach>
		</table>
</body>
</html>