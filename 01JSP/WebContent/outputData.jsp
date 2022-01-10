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
String str = request.getParameter("str");
int count = Integer.parseInt(request.getParameter("count"));
for (int i=1;i<=count+1;i++){
	for(int j=0;j<i;j++){
		out.println(str);
	}
}
out.println("<br>");

%>

</body>
</html>