<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<% 

	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();

 %>
 
 <c:if test="${totalDataCount!=0}">
 	<table width="600" border="0" cellpadding="0" cellspacing="0"
 	style="margin: 0 auto;">

	 <c:forEach var="cdto" items="${lists}">
	 
	 	<tr><td colspan="2" height="1" bgcolor="#999999" align="center"></td></tr>
	 	<tr height="30">
	 		<td width="300" style="padding-left: 10px;">
	 		<b>No ${cdto.listNum}</b>.${cdto.name}
	 			&nbsp;&nbsp;
	 			${cdto.ipAddr}
	 		</td>
			<td width="300" align="right" style="padding-right: 10px;">
				${cdto.created}&nbsp;		
				<a href="javascript:deleteData('${cdto.boardNum}','${cdto.commentNum}','${pageNO}')">삭제</a>
			</td>
	 	
	 	</tr>
	 	<tr>
	 		<td height="30" style="padding-left: 10px;" colspan="2">
	 			${cdto.content}
	 		</td>
	 	</tr>
	 </c:forEach>
	 <tr>
   <td colspan="2" bgcolor="#dbdbdb" height="2"></td>
</tr>

<tr height="30">
   <td align="center" colspan="2">${pageIndexList}</td>
</tr>

</table>
 </c:if>
