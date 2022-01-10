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
String id = request.getParameter("id"); //파라미터를 html 에서받아옴
String pw = request.getParameter("pw");
out.println("["+id+"]");//아이디 출력

if (id != null &&id.equals("admin")&&pw.equals("123")){
	session.setAttribute("id",id);
	session.setAttribute("pw",pw);
	session.setMaxInactiveInterval(5);
	
	response.sendRedirect("member.jsp");
	
}else{
	out.println("<script></script>");
	response.sendRedirect("login.html");
}


%>
</body>
</html>