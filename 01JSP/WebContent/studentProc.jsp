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
		
		if (major.equals("�����а�")){
			depart="�����а�";
		} else if (major.equals("�����а�")){
			depart="�����а�";
		} else if(major.equals("���а�")){
			depart="���а�";
		}else if(major.equals("��ġ�а�")){
			depart="��ġ�а�";
		}else depart="ü���а�";
		
	%>
	<table border = " 11" style="width:800px;">
	<th colspan="2"><h1>�л� ����</h1></th>
	<tr>
		<td>�̸�</td>
		<td width="700px"><%=name %></td>
	</tr>
	<tr>
		<td>���� </td>
		<td><%=Gender %></td>
	</tr>
	<tr>
		<td>����</td>
		<td><%=depart %></td>
	</tr>
		<tr>
		<td>���</td>
		<td><% for(String s: hobby) out.print(s + " "); %>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="ȸ������ ������"> &nbsp;&nbsp;&nbsp;
			<inptu type="reset" value="�ٽ� ����">
		</td>
	</tr>
	</table>
</body>
</html>