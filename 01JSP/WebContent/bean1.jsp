<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.human.dto.Student" %>
<jsp:useBean id="student" class="com.human.dto.Student" scope="page"/>
<jsp:useBean id="student1" class="com.human.dto.Student" scope="page"/>
<jsp:setPropertty name="student1" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:setProperty property="name" name="student" value="홍길동"/>
<jsp:getProperty property="name" name="student" />
<%
	Student student2 = new Student();
	student2.setAge(10);
	out.println(student2.getAge());
	out.println(student.getName());
	
%>
<br>
<jsp:getProperty property="name" name="student1" />
<jsp:getProperty property="age" name="student1" />
<jsp:getProperty property="grade" name="student1" />
<jsp:getProperty property="studentNum" name="student1" />
</body>
</html>