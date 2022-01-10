package com.board.dao;


import java.util.List;
import java.util.Map;

import com.board.dto.CommentDTO;


public interface CommentDAO {

		//1.num의 최대값
		public int commNumMax() throws Exception;

		//입력
		public void commInsertData(CommentDTO dto) throws Exception;
		
		//전체데이터 검색
		public List<CommentDTO> commListData(Map<String, Object> params) throws Exception;
		
		//전체 데이터수 구하기
		public int commDataCount(int boardNum) throws Exception;

		//삭제
		public void commDeleteData(int commentNum) throws Exception;


}
