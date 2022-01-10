<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	com.human.dao.HumanDao dao=new com.human.dao.HumanDao();
	int result=dao.delete(request.getParameter("name"));
	if(result==1){
		out.println("성공");		
	}else{
		out.println("실패");
	}
%>
메뉴
<a href='insert.jsp'>입력</a>
<a href='update.jsp'>수정</a>
<a href='select.jsp'>검색</a>
<a href='delete.jsp'>삭제</a>


</body>
</html>