<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(document).ready(function(){
	$("#insertAddBtn").on("click",function(){
		var name=$("#newName").val();
		var age=$("newAge").val();
		var height=$("newHeight").val();
		var birthday=$("newHeight").val();
		$.ajax({
		type : 'post',
		url :'/ex/'
		})
		
		
	})

	
	
	
})

</script>
</head>
<body>
	insert
		이름<input type="text" name='name' id='newName'>
		나이<input type="text" name='age' id = "newAge">
		키<input type="text" name='height' id = "newHeight">
		생년월일<input type="datetime-local" name='birthday' id = "newBirthday">
		<%-- <a href="/ex/insert?name=${dto.name}&age=${dto.age }&height=${dto.height }&birthday=${dto.birthday } ">등록</a> --%>
		<button id="insertAddBtn">등록</button>
	
	</body>
</html>