<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.human.dao.HumanDao" %>
<%@ page import="com.human.dto.HumanDto" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

메뉴
<a href='insert.jsp'>입력</a>
<a href='update.jsp'>수정</a>
<a href='select.jsp'>검색</a>
<a href='delete.jsp'>삭제</a>
<br>
검색데이터<br>
<%
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

%>

</body>
</html>




