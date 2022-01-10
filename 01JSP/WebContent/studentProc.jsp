<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	String depart = "";
	%>
	<%
		request.setCharacterEncoding("EUC-KR");
	
		String name = request.getParameter("name");
		String Gender = request.getParameter("Gender");
		String major = request.getParameter("major");
		String hobby[] = request.getParameterValues("hobby");
		
		if (major.equals("국문학과")){
			depart="국문학과";
		} else if (major.equals("영문학과")){
			depart="영문학과";
		} else if(major.equals("수학과")){
			depart="수학과";
		}else if(major.equals("정치학과")){
			depart="정치학과";
		}else depart="체육학과";
		
	%>
	<table border = " 11" style="width:800px;">
	<th colspan="2"><h1>학생 정보</h1></th>
	<tr>
		<td>이름</td>
		<td width="700px"><%=name %></td>
	</tr>
	<tr>
		<td>성별 </td>
		<td><%=Gender %></td>
	</tr>
	<tr>
		<td>전공</td>
		<td><%=depart %></td>
	</tr>
		<tr>
		<td>취미</td>
		<td><% for(String s: hobby) out.print(s + " "); %>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="회원정보 보내기"> &nbsp;&nbsp;&nbsp;
			<inptu type="reset" value="다시 쓰기">
		</td>
	</tr>
	</table>
</body>
</html>