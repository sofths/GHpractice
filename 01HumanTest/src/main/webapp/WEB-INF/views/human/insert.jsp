<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
메뉴
	<a href='/ex/human/insert'>입력</a>
		<a href='/ex/human/update'>수정</a>
		<a href='/ex/human/select'>검색</a>
		<a href='/ex/human/delete'>삭제</a>
		<a href='/ex'>리스트</a>

<form action="/ex/human/insert" method="post" >
	name:<input type="text" name="name"><br>
	age:<input type="text" name="age"><br>
	height:<input type="text" name="height"><br>
	birth:<input type="datetime-local" name="birthday"><br>
	<input type="submit" value="제출"><br>
</form>

</body>
</html>