<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
if(<%=request.getParameter("fail")%>==true){
	alert("실패")
}
	</script>
<body>

</body>
</html>