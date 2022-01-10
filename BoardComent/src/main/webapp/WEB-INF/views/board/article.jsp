<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
	String cp = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게 시 판</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<link rel="stylesheet" href="<%=cp%>/resources/css/style.css" type="text/css"/>
<link rel="stylesheet" href="<%=cp%>/resources/css/article.css" type="text/css"/>

<script type="text/javascript">
	
	function sendData(value){
		//스크립트에서 el 받아줄때 ""로 받는다
		var boardNum = "${dto.boardNum}";
		var pageNum = "${pageNum}";
		
		var url = "<%=cp%>/rboard/";
		
		if(value=="deleted")
			url += "deleted.action?";
		else if(value=="updated")
			url += "updated.action?";
		else if(value=="reply")
			url += "reply.action?";
		
		url += "boardNum=" + boardNum;
		url += "&pageNum=" + pageNum;
		
		location.replace(url);
	}

</script>

</head>

<body>

<div id="bbs">
	<div id="bbs_title">
	게 시 판(스프링리플)
	</div>
	<div id="bbsArticle">
		<div id="bbsArticle_header">
			${dto.subject}
		</div>
		<div class="bbsArticle_bottomLine">
			<dl>
				<dt>작성자</dt>
				<dd>${dto.name}</dd>
				<dt>줄수</dt>
				<dd>${lineSu}</dd>
			</dl>
		</div>
		<div class="bbsArticle_bottomLine">
			<dl>
				<dt>등록일</dt>
				<dd>${dto.created}</dd>
				<dt>조회수</dt>
				<dd>${dto.hitCount}</dd>
			</dl>
		</div>
		<div id="bbsArticle_content">
			<table width="600" border="0">
			<tr><td style="padding: 20px 80px 20px 62px;" valign="top" height="200">
			${dto.content}
			</td></tr>
			</table>
		</div>
		<div class="bbsArticle_bottomLine">
			이전글 :
			<c:if test="${!empty preSubject}">
				<a href="<%=cp%>/rboard/article.action?${params}&boardNum=${preBoardNum}">${preSubject}</a>
			</c:if>
			<c:if test="${empty preSubject}">
				이전글이 없습니다.
			</c:if>
		</div>
		<div class="bbsArticle_noLine">
			다음글 : 
			<c:if test="${!empty nextSubject}">
				<a href="<%=cp%>/rboard/article.action?${params}&boardNum=${nextBoardNum}">${nextSubject}</a>
			</c:if>
			<c:if test="${empty nextSubject}">
				다음글이 없습니다.
			</c:if>
		</div>
	</div>
	<div class="bbsArticle_noLine" style="text-align:right">
		    From : ${dto.ipAddr}
	</div>
	<div id="bbsArticle_footer">
		<div id="leftFooter">
			   <input type="button" value=" 답변" class="btn2" 
			   onclick="sendData('reply');"/>
               <input type="button" value=" 수정 " class="btn2" 
               onclick="sendData('updated');"/>
               <input type="button" value=" 삭제 " class="btn2" 
               onclick="sendData('deleted')"/>
		</div>
		<div id="rightFooter">
               <input type="button" value=" 리스트 " class="btn2" onclick="javascript:location.href='<%=cp%>/rboard/list.action?${params}';"/>
		</div>
	</div>

</div>

<br/>&nbsp;<br/>
</body>

</html>