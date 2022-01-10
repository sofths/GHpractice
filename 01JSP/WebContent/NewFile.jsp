<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! String str1= "hello";
	public String gugudan(int dan){
		String str="";
		for (int i=1;i<10;i++){
			str+=dan+"*"+i+"="+dan*i;
		}
		return str;
	}
%>
<% String str2= "hello"; %>
<% str1= str1+"1"; 
 str2= str2+"1"; %>
<%
out.println(str1+"<br>");
out.println(str2);
%>
5단출력
<%=gugudan(5) %>
</body>
</html>