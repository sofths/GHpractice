<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("utf-8");
	String cp = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게 시 판(Spring)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<link rel="stylesheet" href="<%=cp%>/resources/css/style.css" type="text/css"/>
<link rel="stylesheet" href="<%=cp%>/resources/css/article.css" type="text/css"/>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>

<script type="text/javascript">

	$(function(){
		
		listPage(1);//1페이지 호출
		
	});
	
	
	//등록버튼
	$(document).ready(function(){
		
		$("#sendButton").click(function(){
			
			var params = "name=" + $("#name").val() +"&content=" + $("#content").val() + "&boardNum="+'${dto.boardNum}';
			//alert(params);
			$.ajax({
				
				type:"POST",
				url:"<%=cp%>/comm/created.action",
				data:params,
				success:function(args){
					
					$("#listData").html(args);
					
					//데이터 삭제
					$("#name").val("");
					$("#content").val("");
					
				},beforeSend:showRequest,
				error:function(e){
					alert(e.responseText);
				}
			});
		});
	});


	function showRequest(){

		var name = $.trim($("#name").val());
		var content = $.trim($("#content").val());
		
		if(!name){
			alert("\n이름을 입력하세요!");
			$("#name").focus();
			return false;
		}
	
		
		if(!content){
			alert("\n내용을 입력하세요!");
			$("#content").focus();
			return false;
		}
		if(content.length>200){
			alert("\n내용은 200자까지만 가능합니다!");
			$("#content").focus();
			return false;
		}
		
		return true;

	}

	function listPage(page){
		
		var url = "<%=cp%>/comm/list.action";
		

		$.post(url,{boardNum:'${dto.boardNum}', pageNO:page},function(args){
			
			$("#listData").html(args);
			
		});
		
		$("#listData").show();
		
	}
	
	function deleteData(boardNum,num,page){
		
		var url = "<%=cp%>/comm/deleted.action";
		

		$.post(url,{boardNum:boardNum, commentNum:num, pageNO:page},function(args){
			
			$("#listData").html(args);
			
		});
	}


	function sendData(value){
		var boardNum = "${dto.boardNum}";
		var url = "<%=cp%>/bbs/";
		var pwd ='${dto.pwd}';
		if(value=="deleted"){
			url += "deleted.action?";
		}else if(value=="updated"){
			var password = prompt('패스워드를 입력해주세요.');
			if (pwd === password){
			url += "updated.action?";
			}
		}
		url += "${params}";
		url += "&boardNum=" + boardNum;
		location.replace(url);
	}
</script>

</head>

<body>

<div id="bbs">
	<div id="bbs_title">
	게 시 판(스프링)
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
				<a href="<%=cp%>/bbs/article.action?${params}&boardNum=${preBoardNum}">${preSubject}</a>
			</c:if>
			<c:if test="${empty preSubject}">
				이전글이 없습니다.
			</c:if>
		</div>
		<div class="bbsArticle_noLine">
			다음글 : 
			<c:if test="${!empty nextSubject}">
				<a href="<%=cp%>/bbs/article.action?${params}&boardNum=${nextBoardNum}">${nextSubject}</a>
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
               
               <input type="button" value=" 수정 " class="btn2" 
                onclick="sendData('updated')">
                
               <input type="button" value=" 삭제 " class="btn2" 
                onclick="sendData('deleted')">
		</div>
		<div id="rightFooter">
               <input type="button" value=" 리스트 " class="btn2" 
                     onclick="javascript:location.href='<%=cp%>/bbs/list.action?${params}';"/>
		</div>
	</div>

</div>

<br/>&nbsp;<br/>

<!-- 출력 -->
	
<span id="listData" style ="display: none"></span>

<div id="bbs">
	<div id="bbsArticle">
		<div class="bbsArticle_bottomLine">
			<dl>
				<dt >작성자</dt>
				<dd style="padding-top: 5px;height: 20px;">
				<input type="text" id="name" size="20" maxlength="20" class="boxTF"></dd>
			</dl>
		</div>
		<div class="bbsArticle_bottomLine2">
			<dl>
				<dt style="height: 50px;">내용</dt>
				<dd><textarea rows="3" cols="60" class="boxTA" style="height: 40px;  width:450px; margin-top: 3px; " id="content"></textarea></dd>
				<dd style="float: right;width: 70px; margin-top: 3px;">
				<input type="button" value="댓글등록" class="btn2" id="sendButton" style="height: 44px;">
				</dd>
			</dl>
		</div>
	</div>
</div>
<br/>
<br/>
<br/>

</body>

</html>