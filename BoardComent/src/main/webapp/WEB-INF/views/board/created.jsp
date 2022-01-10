<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
	String cp = request.getContextPath();
%>

<link rel="stylesheet" href="<%=cp%>/resources/css/created.css" type="text/css"/>

<script type="text/javascript" src="<%=cp%>/resources/js/util.js"></script>
<script type="text/javascript">
    function sendIt() {
        f = document.myForm;

    	str = f.subject.value;
    	str = str.trim();
        if(!str) {
            alert("\n제목을 입력하세요. ");
            f.subject.focus();
            return;
        }
    	f.subject.value = str;

	    str = f.name.value;
    	str = str.trim();
        if(!str) {
            alert("\n이름을 입력하세요. ");
            f.name.focus();
            return;
        }
		/*
        if(!isValidKorean(str))  {
            alert("\n이름을 정확히 입력하세요");
            f.name.focus();
            return;
        }
		*/
	    f.name.value = str;

        if(f.email.value) {
	    	if(!isValidEmail(f.email.value)) {
                alert("\n정상적인 E-Mail을 입력하세요. ");
                f.email.focus();
                return;
	    	}
        }

    	str = f.content.value;
	    str = str.trim();
        if(!str) {
            alert("내용을 입력하세요. ");
            f.content.focus();
            return;
        }
    	f.content.value = str;

    	str = f.pwd.value;
	    str = str.trim();
        if(!str) {
            alert("\n패스워드를 입력하세요. ");
            f.pwd.focus();
            return;
        }
    	f.pwd.value = str;
    	
    	//alert(f.subject.value + f.content.value + f.name.value);
    	
    	
    	if(f.mode.value=="created"){
    		f.action = "<%=cp%>/rboard/created.action";
    	}else if(f.mode.value=="updated"){
    		f.action = "<%=cp%>/rboard/updated.action";
    	}else{
    		f.action = "<%=cp%>/rboard/reply.action?pageNum=${pageNum}";
    	}
    	
        f.submit();
    }

</script>


<div id="bbs">
	<div id="bbs_title">
	게 시 판(스프링리플)
	</div>

	<form name="myForm" method="post" action="">
	<div id="bbsCreated">
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>제&nbsp;&nbsp;&nbsp;&nbsp;목</dt>
				<dd>
				      <input type="text" name="subject" value="${dto.subject}" size="74" maxlength="100"  class="boxTF" />
				</dd>
			</dl>
		</div>

		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>작성자</dt>
				<dd>
				      <input type="text" name="name" value="${dto.name}" size="35" maxlength="20" class="boxTF" />
				</dd>
			</dl>
		</div>

		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>E-Mail</dt>
				<dd>
				      <input type="text" name="email" value="${dto.email}" size="35" maxlength="50" class="boxTF" />
				</dd>
			</dl>
		</div>

		<div id="bbsCreated_content">
			<dl>
				<dt>내&nbsp;&nbsp;&nbsp;&nbsp;용</dt>
				<dd>
				      <textarea name="content" cols="63" rows="12" class="boxTA">${dto.content}</textarea>
				</dd>
			</dl>
		</div>

		<div class="bbsCreated_noLine">
			<dl>
				<dt>패스워드</dt>
				<dd>
				      <input type="password" name="pwd" value="${dto.pwd}" size="35" maxlength="7" class="boxTF" />&nbsp;(게시물 수정 및 삭제시 필요 !!!)
				</dd>
			</dl>
		</div>
	</div>

	<div id="bbsCreated_footer">
	
		<c:if test="${mode=='updated'}">
		
	 		<input type="hidden" name="boardNum" value="${dto.boardNum}"/><!-- 수정 -->
			<input type="hidden" name="pageNum" value="${pageNum}"/>
		</c:if>
		<c:if test="${mode=='reply'}">
		
			<input type="hidden" name="groupNum" value="${dto.groupNum}"/>
			<input type="hidden" name="orderNo" value="${dto.orderNo}"/>
			<input type="hidden" name="depth" value="${dto.depth}"/>
			<input type="hidden" name="parent" value="${dto.boardNum}"/>
		</c:if>
		
		<input type="hidden" name="mode" value="${mode}"/>
		
        <input type="button" value=" 등록하기 " class="btn2" onclick="sendIt();"/>
        <input type="reset" value=" 다시입력 " class="btn2" onclick="document.myForm.subject.focus();"/>
        <input type="button" value=" 작성취소 " class="btn2" onclick="javascript:location.href='<%=cp%>/rboard/list.action?pageNum=${pageNum}';"/>
	</div>

    </form>
</div>
