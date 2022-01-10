<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.human.dao.HumanDao" %>
<%@ page import="com.human.dto.HumanDto" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

메뉴
<a href='insert.do'>입력</a>
<a href='update.do'>수정</a>
<a href='select.do'>검색</a>
<a href='delete.do'>삭제</a>
<br>
검색데이터<br>

<c:if test= "${result eq 1}" >
	성공
</c:if>
<c:if test= "${result ne 1}" >
	실패
</c:if>
</body>
</html>




