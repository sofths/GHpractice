package com.board.service;

import java.util.List;


import com.board.dto.CommentDTO;

public interface CommentService {
	//1.num의 최대값
		public int getMaxNum() throws Exception;

		//입력
		public void insertData(CommentDTO dto) throws Exception;

		//전체데이터 검색
		public List<CommentDTO> getList(int start, int end, int boardNum) throws Exception;

		//전체 데이터수 구하기
		public int getDataCount(int boardNum) throws Exception;


		//삭제
		public void deleteData(int commentNum) throws Exception;

}
