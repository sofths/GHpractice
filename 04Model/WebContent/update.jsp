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
<a href='insert.do'>입력</a>
<a href='update.do'>수정</a>
<a href='select.do'>검색</a>
<a href='delete.do'>삭제</a>
<form action="updateDB.do" method="get" >
	name:<input type="text" name="name"><br>
	age:<input type="text" name="age"><br>
	<input type="submit" value="제출"><br>
</form>
</body>
</html>

