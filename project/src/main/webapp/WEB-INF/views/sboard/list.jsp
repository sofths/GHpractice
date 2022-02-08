  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <%@include file="../include/header.jsp"%>
  <script>
  var result = '${msg}';
	if (result == 'success') {
		alert("처리가 완료되었습니다.");
	}
  $(document).ready(function(){
	  $('#searchBtn').on("click",function(event){
		/*   alert("list"+'${pageMaker.makePage(1)}'
				  +'&searchType='+$("select option:selected").val()
				  +"&keyword="+$('#keywordInput').val()); */
		  self.location="list"+'${pageMaker.makePage(1)}'
		  +'&searchType='+$("select option:selected").val()
		  +"&keyword="+$('#keywordInput').val(); 
	  })
	  $('.writeBtn').on("click",function(event){
		  location.href="/ex/sboard/write";
	  });
  });
/* 
  function faqTop() { 
		let f=documnet.createElement('form');
		f.setAttribute('method','post');
		f.setAttribute('action','goPost.do');
		document.body.appendChild(f);
		f.submit();
	} */
  </script>
<div class="layout_body">
    <div class="subpage_wrap">
        <div class ="subpage_lnb">
            <div id="boardLnbCommon" class = "boardLnbCommon">
                <h2 class="title1">
                    <a href="#">CS CENTER</a>
                </h2>
               <ul>
                   <li><a href="#">공지사항</a></li>
                   <li><a href="faqtop">자주 하는 질문</a></li>
                   <li><a href="#">상품 문의</a></li>
                   <li><a href="#">상품 후기</a></li>
               </ul>
            </div>
            <scrpit href="/css/layout.js"></scrpit>
        </div>
        <div class = "subpage_container">
            <a id="subAllButton" class = "btn_sub_all" >
            </a>
            <div class = "title_container">
                <h2>상품 문의</h2>
            </div>
            <div id="bbslist">
            <div class="bbs_top_wrap">
                <div class="left">
                    <select name="searchType">
                        <option value="t" <c:out value="${pageMaker.searchType==null?'selected':'' }"/>>--전체--</option>
                        <!-- <option value="n" selected>----</option>
                        <option value="n">----</option> -->
                        <option value="c" <c:out value="${pageMaker.searchType eq 'c'?'selected':'' }"/>>불량품문의</option>
                        <option value="w" <c:out value="${pageMaker.searchType eq 'w'?'selected':'' }"/>>상품문의</option>
                        <option value="tc" <c:out value="${pageMaker.searchType eq 'tc'?'selected':'' }"/>>재고문의</option>
                        <option value="cw" <c:out value="${pageMaker.searchType eq 'cw'?'selected':'' }"/>>기타문의</option>
                    </select>
                </div>
                <div class="right">
                    <input type="text" name="keyword" 
                    id="keywordInput" value="${pageMaker.keyword}">
                    <button class="sear_btn" id="searchBtn"> 검색하기</button>   	
                </div>
            </div>
            <div class="res_table">
                <ul class="thead"> 
                    <li style="width: 10px">번호</li>
                    <li style="width: 100px">분류</li>
                    <li style="width: 100px">문의</li>
                    <li style="width: 30px">작성자</li>
                    <li style="width: 40px">등록일</li>
            </ul>
                <c:forEach items="${list}" var="dto">	
                    <ul class="tbody_complete">
                        <li style="width: 10px">${dto.titleNum }</li>
                        <li style="width: 100px">${dto.questionType }</li>
                        <li><a href="/ex/sboard/read${pageMaker.makeSearch()}&titleNum=${dto.titleNum}">${dto.faqTitle }</a></li>
                        <li style="width: 100px">${dto.userID }</li>
                        <li style="width: 200px">
                        <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value= "${dto.inquiryDate }"/></li>
                    </ul>
                      </c:forEach>
            </div>
            <div id="pagingDisplay" class="paging_navigation">
                <c:if test="${pageMaker.page !=1}">
    		<a class="on_red" href='list${pageMaker.makeSearch(1)}'>&laquo;</a>
    	</c:if>
    	<c:if test="${pageMaker.prev }">
    		<a href='list${pageMaker.makeSearch(pageMaker.startPage-1)}'>&lt;</a>
    	</c:if>
    	
    	<c:forEach begin="${pageMaker.startPage }" end="${ pageMaker.endPage}" var="idx">
    		<a href='list${pageMaker.makeSearch(idx)}' 
    		 <c:out value="${pageMaker.page==idx?' class=active ':'' }"/> >
    		 ${idx}</a>
    	</c:forEach>
    	<%--<a href='#'>1</a>
    	 <a href='list${pageMaker.makeSearch(2)}'>2</a>
    	<a href='#' class="active">3</a> --%>
    	<c:if test="${pageMaker.next }">
    		<a href='list${pageMaker.makeSearch(pageMaker.endPage+1)}'>&gt;</a>
    	</c:if>
    	<c:if test="${pageMaker.page != pageMaker.totalEndPage}">
    		<a id="pageselect" href='list${pageMaker.makeSearch(pageMaker.totalEndPage)}'>&raquo;</a>
    	</c:if>
            </div>
            <ul class="bbs_bottom_wrap">
            <li class="right2">
                <button class='writeBtn'>상품 문의 쓰기</button>
            </li>
            </ul>    
        </div>
        </div> 
    </div>

</div>

  <%@include file="../include/footer.jsp"%>
  
  
  
  
  
  
  
  
  
  
  
  
