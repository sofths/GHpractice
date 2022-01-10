<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="com.board.dto.board" %>
<jsp:useBean id="board" class="com.board.dto.board" scope="page"/>
<jsp:setPropertty name="board" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
<jsp:getProperty property="name" name="board1" />
<jsp:getProperty property="content" name="board1" />
<jsp:getProperty property="mail" name="board1" />
<jsp:getProperty property="pw" name="board1" />
</body>
</html>