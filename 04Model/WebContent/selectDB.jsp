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
 <c:forEach items="${requestScope.dtos }" var="dto">
<tr>
<td>${dto.name }</td><td>${dto.age }</td>
<td>${dto.tall }</td><td>${dto.birth }</td>
</tr>
</c:forEach>

</table>

<%--
	HumanDao dao=new HumanDao();
	ArrayList<HumanDto> dtos = 
			dao.select(request.getParameter("name"));
	if(dtos!=null){
		for(HumanDto dto:dtos){
			out.println(dto);
			out.println("<br>");
			
		
		}
	}
	System.out.println("end");

--%>

</body>
</html>




