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
				<td>이름</td>
				<td width="700px"><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="radio" name="Gender" value="남자"> 남자 <input
					type="radio" name="Gender" value="여자"> 여자</td>
			</tr>
			<tr>
				<td>전공</td>
				<td><select name="major">
						<option value="국문학과" selected>국문학과</option>
						<option value="영문학과" selected>영문학과</option>
						<option value="수학과" selected>수학과</option>
						<option value="정치학과" selected>정치학과</option>
						<option value="체육학과" selected>체육학과</option>
				</select></td>
			</tr>
			<tr>
				<td>취미</td>
				<td><input type="checkbox" name="hobby" value="수영">수영 <input
					type="checkbox" name="hobby" value="여행">여행 <input
					type="checkbox" name="hobby" value="독서">독서 <input
					type="checkbox" name="hobby" value="영화감상">영화감상</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="회원정보 보내기">%nbsp;%nbsp;%nbsp; <input type="reset"
					value="다시 쓰기"></td>
			</tr>
		</table>
	</form>
</body>
</html>