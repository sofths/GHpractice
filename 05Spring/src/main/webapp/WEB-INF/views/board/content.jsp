<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
td,tr{
border:1px solid black;

</style>
<script>
function listAll(){
	self.location = "/ex/board/list";
	
}
function update(){
	var userpw='${boardVO.password}';
	var pw =document.getElmentById('pwd').value;
	if(userpw==pw){
	f=document.getElemnetById('pwd').value;
	f.action="/ex/board/modify";
	f.submit();
	}else{
		alert("패스워드가 틀렸습니다. 다시입력해주세여")
	}
}
function remove() {
	var userpw='${boardVo.password}';
	var pw = document.getElementById('pwd').value;
	if(userpw==pw){
	f.document.myForm;
	f.action="/ex/board/remove";
	f.submit();
	}else{
		alert("패스워드가 틀렸습니다. 다시 입력해 주세요.")}
	}
}
</script>
</head>
<body>
<form name="myForm" action="" method="post">
<h1>학생정보등록</h1><br>
<table style="border:1px solid black">
<tr>
<td>아이디</td>
<td><input type = "text" name="id" value="${boardVO.id }" readonly="readonly">
<p>* 아이디는 변경 불가능 합니다</p></td>
</tr>
<tr>
<td>학번</td>
<td><input type="text" name="snum" value="${boardVO.name }"></td>
</tr>
<tr>
<td>입학년도</td>
<td><input type="text" name="year" value="${boardVO.name }"></td>
</tr>
<tr>
<td>전공</td>
<td><input type="text" name="major" value="${boardVO.name }"></td>
</tr>
<tr>
<td>전화번호</td>
<td><input type="text" name="tel" value="${boardVO.name }"></td>
</tr>
<tr>
<td>주소</td>
<td><input type="text" name="address" value="${boardVO.name }"></td>
</tr>
<tr>
<td>이메일</td>
<td><input type="text" name="email" value="${boardVO.name }"></td>
</tr>
<tr>
<td>비밀번호</td>
<td><input type="password" id="pwd" name="apssword" value="${boardVO.name }"></td>
</tr>
</table>
<input type="button" onclick="update()" value="수정">
<input type="button" onclick="remove()" value="삭제">
<input type="button" onclick="listAll()" value="학생목록보기">
</form>
</body>
</html>