<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.main{
border: 1px solid black;
width: 1200px;
height: auto;
text-align: center;
}

</style>
</head>
<body>
<div class = "main">
<h1>조회</h1>
	<a href='/ex/human/insert'>입력</a>
		<a href='/ex/human/update'>수정</a>
		<a href='/ex/human/select'>검색</a>
		<a href='/ex/human/delete'>삭제</a>
		<a href='/ex'>리스트</a>
<form action="/ex/human/select" method="post" >
	name:<input type="text" name="name"><br>
	<input type="submit" value="제출"><br>
</form>
</div>
</body>
</html>