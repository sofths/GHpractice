<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pagefile=request.getParameter("page");
if(pagefile==null){
	pagefile="newitem";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="960" border="1" color="gray" align="center">
	<tr>
		<td height="43" colspan="2">
		top.jsp 상단입니다.
		<jsp:include page="top.jsp"></jsp:include>
		</td>
		</tr>
		<tr>
			<td width="15%" align='right' valign='top'>
			left.jsp 왼쪽 메뉴입니다.
			<jsp:include page="left.jsp"></jsp:include>
			</td>
			<td height="150">
			content페이지입니다.(신상품 베스트상품)<br>
			<jsp:include page='<%=pagefile+".jsp"%>'></jsp:include>
			</td>
		</tr>
		<tr>
			<td height="43" colspan="2">
				bottom.jsp 하단.
				<jsp:include page="bottom.jsp"></jsp:include>
				</td>
			</tr>
</table>
</body>
</html>