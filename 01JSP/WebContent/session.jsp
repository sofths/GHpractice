<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
세션 생성하기<br>
<form action="MySession" mathod="get">
	세션이름<input type="text" name=name >
	세션값<input type="text" name=value >
	<input type="submit" value="전송">
</form>
세션 찾기<br>
<form action="MySessionSelect" mathod="get">
	세션이름<input type="text" name=name >
	<input type="submit" value="전송">
</form>
세션 삭제
<a href="MySessionDelete">세션 삭제</a>
</body>
</html>