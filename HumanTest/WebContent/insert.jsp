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
<a href='insert.jsp'>입력</a>
<a href='update.jsp'>수정</a>
<a href='select.jsp'>검색</a>
<a href='delete.jsp'>삭제</a>


<form action="insertDB.jsp" method="get" >
	name:<input type="text" name="name"><br>
	age:<input type="text" name="age"><br>
	tall:<input type="text" name="tall"><br>
	birth:<input type="datetime-local" name="birth"><br>
	<input type="submit" value="제출"><br>
</form>

</body>
</html>