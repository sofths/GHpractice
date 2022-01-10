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
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
%>
받은 데이터<br>
<%
	out.println(id); out.println(pw);
%>

<%!
int i = 10;
String str = "ABCDE";
public int sum(int j,int k){
	return j+k;
}
%>

<% out.println("i="+i+"<br/>");
out.println("str="+str+"<br/>");
out.println("sum="+sum(1,5)+"<br/>");
	
%>
<%!
public int sumEx(int j,int k){
	return j*k;
}
	%>
Expression
<h2><%=str%>은 <%=sum(12,22)%></h2>
<h2><%=str %>에 3을 곱하면<%=sum(12,22)*3 %></h2>
<h2><%=str %>을 1000으로 나누면 <%=sum(12,22)/1000. %></h2>
매개변수
<h2><%=str %>은 <%=sumEx(0,100) %></h2>
<h2><%=str %>에 3을곱하면<%=sumEx(0,100)*3 %></h2>
<h2><%=str %>을 1000으로 나누면 <%=sumEx(0,100)/1000. %></h2>

</body>
</html>