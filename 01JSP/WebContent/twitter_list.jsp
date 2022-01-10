<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<%
//한글 캐릭터셋 변환
request.setCharacterEncoding("UTF-8");
//html 폼에서 username 으로 전달된 값을 가지고 옴
String username= request.getParameter("username");

// username이 null 이 아닌경우 세션에 값을 저장
if(username!=null){
	session.setAttribute("user",username);
}

%>


<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align=center>
<h3>My Simple Twitter!!</h3>
<HR>
<form action="twitter.jsp" method="post">
<%//메시지에 를 입력받아 tweet.jsp 로 보내준다. %>
@<%=session.getAttribute("user")%><input type="text" name="msg"><input type="submit" value="Tweet">
</form>
<hr>
<div align="left">
<ul>
<%
	//application 내장 객체를 통해 msgs 이름으로 저장된 array lit 를 가지고온다
	ArrayList<String>msgs = (ArrayList<String>)application.getAttribute("msgs");
	//msgs 가 null 이 아닌 경우에만 목록 출력
	if (msgs !=null){
		for (String msg:msgs){
			out.println("<LI>"+msg+"</LI>");
		}
	}
%>
<
</ul>
</div>
</div>
</body>
</html>