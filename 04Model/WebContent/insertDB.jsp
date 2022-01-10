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

<table width="500" cellpadding="0" cellspacing="0" border="1">
<tr>
<td>이름</td><td>나이</td><td>키</td><td>생일</td>
</tr>
<tr>
<td>${dto.name }</td><td>${dto.age }</td>
<td>${dto.tall }</td><td>${dto.birth }</td>
</tr>
</table>
<c:if test= "${i eq 1}" >
	성공
</c:if>
<c:if test= "${i ne 1}" >
	실패
</c:if>
</body>
</html>




