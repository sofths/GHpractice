<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@include file="../include/header.jsp"%>
<div class="subpage_container">
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
				<scrpit href="/css/layout.js"></scrpit>
			</div>

			<div class="subpage_container">
				<div class="title_container">
					<h2>상품 문의</h2>
				</div>
				<!-- /.box-header -->
				<!-- action에 경로가 없으면 현재 페이지 주소로 이동한다.-->
				<div id="bbsview">
					<form role="form" method="post">
						<div class="table_top_line1"></div>
						<table id="boradDetailTable " class="table_row_a v2 Thc"
							width="100%" cellpadding="0" cellspacing="0">
							<colgroup>
								<col class="size_b">
								<col>
							</colgroup>
							<tbody>
								<tr>
									<th>
										<p>분류</p>
									</th>
									<td><select name="questionType">
											<option value selected="selected">- 분류 선택</option>
											<option value="불량품문의">불량품문의</option>
											<option value="상품문의">상품문의</option>
											<option value="재고문의">재고문의</option>
											<option value="기타문의">기타문의</option>
									</select></td>
								</tr>
								<tr>
									<th>
										<p>작성자</p>
									</th>
									<td><input type="text" name="userID" redonly="readonly">
									</td>
								</tr>
								<tr>
									<th>
										<p>제목</p>
									</th>
									<td><input type="text" name='faqTitle' id="subject" value
										class="Wmax" title="제목을 입력해주세요" placeholder="제목을 입력해 주세요">
									</td>
								</tr>

							</tbody>
						</table>

						<textarea name="faqContent" rows="8" class="size3"
							title="내용을 입력하세요" placeholder="내용을 입력하세요"></textarea>

						<!-- /.box-body -->
						<div class="board_detail_btns2">
							<button type="submit"
								class="data_save_btn btn_resp size_c color2" class="btn">
								<span designelement="text" textindex="11">확인</span>
							</button>
							<button type="button" class="btn_resp size_c"
								onclick="document.location.herf=/ex/sboard/list">
								<span designelement="text" textindex="12">취소</span>
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../include/footer.jsp"%>