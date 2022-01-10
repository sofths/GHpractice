<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.human.dao.HumanDao" %>
<%@ page import="com.human.dto.HumanDto" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	HumanDto dto=new HumanDto();
	dto.setName(request.getParameter("name"));
	dto.setAge(Integer.parseInt(request.getParameter("age")));
	dto.setTall(Double.parseDouble(request.getParameter("tall")));
	// "yyyy-MM-dd'T'hh:mm"

	dto.setBirthString(request.getParameter("birthday"));
	
	out.println(dto);
	
	HumanDao dao =new HumanDao();
	int i=dao.insert(dto);
	if(i==1){
		out.println("입력 성공");
	}else{
		out.println("문제 발생");
	}	

%>

<!-- <script>
alert("완료");
location.href="insert.jsp";
</script> -->

메뉴

<a href='insert.jsp'>입력</a>
<a href='update.jsp'>수정</a>
<a href='select.jsp'>검색</a>
<a href='delete.jsp'>삭제</a>

</body>
</html>



