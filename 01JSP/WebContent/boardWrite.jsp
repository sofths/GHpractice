<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="bordjs.jsp" method="get">
<h1>게시판 글쓰기</h1><br>
작성자<input type="text" name="name"><br>
비밀번호<input type="text" name="pw"><p>(게시물 수정 삭제시 필요합니다.)</p><br>
이메일<input type="text" name="mail"><br>
글제목<input type="text" name="title"><br>
글내용<input type="text" name="content" width="100px" height = "100px"><br>
<input type="submit" value="전송">
</form>
</body>
</html>