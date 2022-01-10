<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
<function listAll(){
	self.location="/ex/board/list";
}
</script>
</head>
<body>
<form form = "myForm" method="post">
<h1>학생 정보 등록</h1> <br>
<table style ="border:1px solid black">
<tr>
<td> 아이디</td>
<td><input type="text" name= "id"></td>
</tr>
<tr>
<td>비밀번호</td>
<td><input type="password" name= "password"></td>
</tr>
<tr>
<td>이름</td>
<td><input type="text" name= "name"></td>
</tr>
<tr>
<td>학번</td>
<td><input type="text" name= "snum"></td>
</tr>
<tr>
<td>입학년도</td>
<td><input type="text" name= "year"></td>
</tr>
<tr>
<td>전공</td>
<td><input type="text" name= "major"></td>
</tr>
<tr>
<td>전화번호</td>
<td><input type="text" name= "tel"></td>
</tr>
<tr>
<td>주소</td>
<td><input type="text" name= "address"></td>
</tr>
<tr>
<td>이메일</td>
<td><input type="text" name= "email"></td>
</tr>
</table>
<input type="submit" value="등록">
<input type="reset" value="다시작성">
<input type="button" onclick="listAll()" value="학생목록보기">
</form>
</body>
</html>