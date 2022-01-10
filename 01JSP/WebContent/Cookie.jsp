<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
쿠키 생성하기<br>
<form action="MyCookie" mathod="get">
	쿠키이름<input type="text" name=name >
	쿠키값<input type="text" name=value >
	<input type="submit" value="전송">
</form>
<br>쿠키 확인<br>
<a href=MyCookieSelect>쿠키확인</a>
<form action="MyCookieDelete" mathod="get">
	쿠키이름<input type="text" name=name >
	<input type="submit" value="전송">
</form>
</body>
</html>