<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="studentProc.jsp" method="post">
		<table border="1" style="width: 800px;">
			<th colspan="2"><h1>student info</h1>
			<tr>
				<td>�̸�</td>
				<td width="700px"><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="radio" name="Gender" value="����"> ���� <input
					type="radio" name="Gender" value="����"> ����</td>
			</tr>
			<tr>
				<td>����</td>
				<td><select name="major">
						<option value="�����а�" selected>�����а�</option>
						<option value="�����а�" selected>�����а�</option>
						<option value="���а�" selected>���а�</option>
						<option value="��ġ�а�" selected>��ġ�а�</option>
						<option value="ü���а�" selected>ü���а�</option>
				</select></td>
			</tr>
			<tr>
				<td>���</td>
				<td><input type="checkbox" name="hobby" value="����">���� <input
					type="checkbox" name="hobby" value="����">���� <input
					type="checkbox" name="hobby" value="����">���� <input
					type="checkbox" name="hobby" value="��ȭ����">��ȭ����</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="ȸ������ ������">%nbsp;%nbsp;%nbsp; <input type="reset"
					value="�ٽ� ����"></td>
			</tr>
		</table>
	</form>
</body>
</html>