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
input{
 width:200px;
}
.input_box{
position:relative;
left:200px;
width: 500px;
height: auto;
text-align: right;
}
textarea{
width:200px;
height:200px;
}

</style>
</head>
<body>
<div class="main">
<h1>입력</h1>
	<a href='/ex/human/insert'>입력</a>
		<a href='/ex/human/update'>수정</a>
		<a href='/ex/human/select'>검색</a>
		<a href='/ex/human/delete'>삭제</a>
		<a href='/ex'>리스트</a>

<form action="/ex/human/insert" method="post" >
	<div class ="input_box">
	name:<input type="text" name="name"><br>
	age:<input type="text" name="age"><br>
	memo:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;
	<br><textarea name="memo"></textarea></p>
	<input type="submit" value="제출"><br>
</div>
</form>
</div>
</body>
</html>