<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script>
localhost.href="selectDB.jsp";
</script> -->
</head>
<body>
메뉴
<a href='insert.jsp'>입력</a>
<a href='update.jsp'>수정</a>
<a href='select.jsp'>검색</a>
<a href='delete.jsp'>삭제</a>

<form action="selectDB.jsp" method="get" >
	name:<input type="text" name="name"><br>
	<input type="submit" value="제출"><br>
</form>
</body>
</html>