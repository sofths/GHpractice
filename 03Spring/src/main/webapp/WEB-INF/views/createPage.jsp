<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
	String conPath = request.getContextPath();
	System.out.println(conPath);
%>
<%=conPath %>
<!--form action="student/create"-->
<form action="<%=conPath%>/student/create">
	이름:<input type="text" name="name" value="${student.name }"><br>
	아이디:<input type="text" name="id" value="${student.id}"><br>
	<input type="submit" value="전송"><br>
</form>
<!-- 에러 발생시 사용자가 입력한 값을 가지고 돌아와서 화면에 보여주기 위해서 다음과 같이 작성한다. 
${student.name }-->
</body>
</html>