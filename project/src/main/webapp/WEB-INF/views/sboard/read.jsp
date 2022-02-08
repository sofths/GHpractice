<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="/ex/resources/css/faqread.css" />
<style>
#modDiv {
	width: 400px;
	height: 150px;
	background-color: gray;
	position: fixed;
	top: 20%;
	left: 50%;
	margin-top: -50px;
	margin-left: -150px;
	padding: 10px;
	z-index: 1000;
}
</style>

<script>
	var bno = "${boardDTO.titleNum}";
	var page = 1;
	$(document).ready(function() {

		$("#replies").on("click", ".replyLi button", function() {
			var reply = $(this).parent();
			var rno = reply.attr("data-rno");
			var replytext = reply.text();
			$(".modal-title").html(rno);
			$("#replytext").val(replytext);
			$("#modDiv").show("slow");
		});

		//리플작업시작
		//read페이지는 특정글을 읽을때 들어와서 bno정보를 가지고 있다.
		//처음 read페이지에 들어 왔을때 page는 1이 된다.
		//bno page

		getPageList(page);
		$("#replyModBtn").on("click", function() {
			var rno = $(".modal-title").html();
			var replytext = $("#replytext").val();
			$.ajax({
				type : 'put',
				url : '/ex/replies/' + rno,
				headers : {
					"Content-Type" : "application/json"
				},
				data : JSON.stringify({
					replytext : replytext
				}),
				dataType : 'text',
				success : function(result) {
					console.log("result: " + result);
					if (result == 'SUCCESS') {
						alert("수정 되었습니다.");
						$("#modDiv").hide("slow");
						//getAllList();
						getPageList(page);
					}
				}
			});
		});
		$("#closeBtn").on("click", function() {
			$("#modDiv").hide("slow");
		});

		$("#replyDelBtn").on("click", function() {
			var rno = $(".modal-title").html();
			//var replytext = $("#replytext").val();
			$.ajax({
				type : 'delete',
				url : '/ex/replies/' + rno,
				headers : {
					"Content-Type" : "application/json"
				},
				dataType : 'text',
				success : function(result) {
					console.log("result: " + result);
					if (result == 'SUCCESS') {
						alert("삭제 되었습니다.");
						$("#modDiv").hide("slow");
						//getAllList();
						getPageList(page);
					}
				}
			});
		});

		$(".pagination").on("click", "a", function(event) {
			event.preventDefault();
			page = $(this).attr("href");
			getPageList(page);
		})

		$("#replyAddBtn").on("click", function() {
			var replyer = $("#newReplyWriter").val();
			var replytext = $("#newReplyText").val();
			$.ajax({
				type : 'post',
				url : '/ex/replies',
				headers : {
					"Content-Type" : "application/json"
				},
				dataType : 'text',
				data : JSON.stringify({
					bno : bno,
					replyer : replyer,
					replytext : replytext
				}),
				success : function(result) {
					if (result == 'SUCCESS') {
						alert("등록 되었습니다.");
						//getAllList();
						getPageList(page);
						//1번페이지를 보여줄 예정

					}
				}
			});
		});

		//리플작업종료
		var fObject = $(".form");

		$(".btnList").on("click", function() {

			fObject.attr("method", "get");
			fObject.attr("action", "/ex/sboard/list");
			fObject.submit();

		})
		$(".btnRemove").on("click", function() {
			fObject.attr("action", "/ex/sboard/remove");
			fObject.submit();
		})
		$(".btnModify").on("click", function() {
			fObject.attr("method", "get");
			fObject.attr("action", "/ex/sboard/modify");
			fObject.submit();
		})

	});
	/* private Integer rno;
	private Integer bno;
	private String replytext;
	private String replyer;

	private Date regdate;
	private Date updatedate; */

	function getPageList(page) {
		$.getJSON("/ex/replies/" + bno + "/" + page, function(data) {
			console.log(data.list.length);
			var str = "";
			$(data.list).each(
					function() {
						str += "<li data-rno='"+this.rno+"' class='replyLi'>"
								+ this.rno + " " + this.replyer + ":"
								+ this.replytext + " <button>Mod</button></li>"
					})
			$("#replies").html(str);
			printPaging(data.pageMaker)
		})
	}
	function printPaging(pageMaker) {

		var str = "";

		if (pageMaker.prev) {
			str += "<a href='" + (pageMaker.startPage - 1) + "'> << </a>";
		}

		for (var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
			var strClass = pageMaker.page == i ? 'class=active' : '';
			str += "<a  "+strClass+" href='"+i+"'>" + i + "</a>";
		}

		if (pageMaker.next) {
			str += "<a href='" + (pageMaker.endPage + 1) + "'> >> </a>";
		}
		$('.pagination').html(str);

	}
</script>
<div class="layout_body">
	<div class="subpage_wrap">
		<div class="subpage_lnb">
			<div id="boardLnbCommon" class="boardLnbCommon">
				<h2 class="title1">
					<a href="#">CS CENTER</a>
				</h2>
				<ul>
					<li><a href="#">공지사항</a></li>
					<li><a href="#">자주 하는 질문</a></li>
					<li><a href="#">상품 문의</a></li>
					<li><a href="#">상품 후기</a></li>
				</ul>
			</div>
		</div>
		<div class="subpage_container">
			<div class="title_container">
				<h2>상품문의</h2>
			</div>
			<div id="bbsview">
				<div class="form" method="post">
					<input type='hidden' name='titleNum' value="${boardDTO.titleNum}">
					<input type='hidden' name='page' value="${pageMaker.page}">
					<input type='hidden' name='perPageNum'
						value="${pageMaker.perPageNum}"> <input type='hidden'
						name='searchType' value="${pageMaker.searchType}"> <input
						type='hidden' name='keyword' value="${pageMaker.keyword}">
					<div class="board_detail_title">${boardDTO.faqTitle}</div>
					<table class="table_row_a Thc" data-responsive="yes" width="100%"
						cellpadding="0" cellspacing="0">
						<colgroup>
							<col class="size_b">
							<col>
							<col class="size_b">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th>
									<p designelement="text" textindex="1">분류</p>
								</th>
								<td>"[${boardDTO.questionType}]"</td>
								<th>
									<p designelement="text" textindex="1">작성자</p>
								</th>
								<td>${boardDTO.userID}</td>
							</tr>
							<tr>
								<th>
									<p designelement="text" textindex="1">등록일</p>
								</th>
								<td>${boardDTO.inquiryDate}</td>
							</tr>
						</tbody>
					</table>
					<div class="board_detail_contents">
						${boardDTO.faqContent} <br> <br>
					</div>
					<div class="board_sns_link">
						<span class="snsbox hand"> &nbsp; <span class="snsbox hand"></span>
							&nbsp; <span class="snsbox hand"></span> &nbsp; 
					</div>
					<div class="board_comment_area" id="comment_container">
						<div class="cmt_division v2">
							<div class="content title_area">
								<span class="title" designelement="text" textindex="1">답글</span>
								<string class="num pointcolor">0</string>
								&nbsp; <input type="button" name="board_comment_btn"
									id="board_comment_btn_261" seq="261" value="답글 등록하기▼"
									class="board_comment_btn btn_resp size_b isopen"
									onclick="openCloseToc()">
							</div>
						</div>
						<div id="cwrite" class>
							<div id="cmt_insert_261" class="cmt_insert_hide">
								<script>
									function openCloseToc() {
										var element = document.getElementById('board_comment_btn_261');
										if (document.getElementById('cmt_insert_261').style.display === 'block') {
											document.getElementById('cmt_insert_261').style.display = 'none';
											element.value = "답글 등록하기▼"
										} else {
											document.getElementById('cmt_insert_261').style.display = 'block';
											element.value = "답글 닫기▲"
										}
									}
								</script>
								<table class="cmt_box" cellpadding="0" cellspacing="0">
									<tbody>
										<tr>
											<td class="its-td"><input type="hidden" name="name"id="cmtname" class="requiredline" size="20" value="">
												<input type="text" value="사용자아이디" readonly="readonly"class="required line"></td>
										</tr>
										<tr>
											<td class="its-td"><textarea name="replytext"id="newReplyText" class="size1 requiredline"title="답글을 입력해 주세요." placeholder="댓글을 입력해 주세요.">
                                        </textarea></td>
										</tr>
										<td class="its-td">
											<button id="replyAddBtn" class="replyAdd">답글등록</button>
										</td>
									</tbody>
								</table>
							</div>
						</div>
						<div class="cmt_division v3">
							<table class="cmt_tbl" cellpadding="0" border="0" width="100%">
								<tbody>
									<tr>
										<td class="cmt_area cmt_cont_head"><strong>${replyDTO.userID}</strong>
											<span class="desc">&nbsp; ${replyDTO.replyDate}</span></td>
									</tr>
									<tr>
										<td class="cmt_area cmt_contents" style="font-weight: normal;">
											<div
												style="left: 0; word-wrap: break-word; word-break: break-all;">
												<span board_weq="13" board_id="goods_qna">${replyDTO.replyContent}</span>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div id="prenextlist" class="board_prev_next_list">
						<ul>
							<li><span class="pnl_desc">다음글</span> <span
								class="pnl_title"> <span
									class="hand highlight-link boad_view_btn_mbno sbj"> <a>다음글
											태그</a>
								</span>
							</span></li>
							<li><span class="pnl_desc">이전글</span> <span
								class="pnl_title"> <span
									class="hand highlight-link boad_view_btn_mbno sbj"> <a>이전글
											태그</a>
								</span>
							</span></li>
						</ul>
					</div>
					<ul class="board_detail_btns">
						<li class="left">
							<button type="button" name="boardviewclose"
								class="btn_resp size_b color5">
								<span designelement="text" textindex="8">목록</span>
							</button>
						</li>
						<li class="right">
							<button type="button" id="goods_boad_write_btn"
								board_id="goods_qna" class="btn_resp size_b color2">
								상품문의<span designelement="text" textindex="12">쓰기</span>
							</button>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../include/footer.jsp"%>