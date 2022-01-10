<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
	var result = '${msg }';
	if (result == 'success') {
		alert("처리가 완료되었습니다.")
	}
</script>
</head>
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
<script>
	function insert() {
	}
	self.location = "/ex/board/insertForm";
</script>
<body>
	<div class="main">
		<div id="top">
			<h1>학생 조회 프로그램</h1>
		</div>
		<div id="bottom">
			<h2>학생 정보리스트</h2>
		</div>
		<div id="btn">
			<input type="button" onclick="insert()" value="학생정보등록">
		</div>
		<table id='studentInfo'>
			<tr>
				<th style="width: 80px">아이디</th>
				<th style="width: 80px">이름</th>
				<th style="width: 80px">학번</th>
				<th style="width: 100px">입학년도</th>
				<th style="width: 150px">전공</th>
				<th style="width: 150px">전화번호</th>
				<th style="width: 150px">주소</th>
				<th style="width: 150px">이메일</th>
			</tr>
			<c:forEach items="${list}" var="studnetDTO">
				<tr>
					<td><a href='/ex/board/content?id =${studetnDTO.id}'>${studentDTO.id }</a></td>
					<td>${studentDTO.name }</td>
					<td>${studnetDTO.snum }</td>
					<td>${studnetDTO.year }</td>
					<td>${studnetDTO.major }</td>
					<td>${studnetDTO.tel }</td>
					<td>${studnetDTO.address }</td>
					<td>${studnetDTO.email }</td>
		</tr>
		</c:forEach>
		</table>
		<div id = "foot">
			<p>등록된 학생 수는 ${count } 명 입니다.</p>
		</div>
	</div>
</body>
</html>