package com.board.service;

import java.util.List;


import com.board.dto.BoardDTO;


public interface BoardService {
	
		//1.num의 최대값
		public int getMaxNum() throws Exception;

		//입력(created.jsp->created_ok.jsp)
		public void insertData(BoardDTO dto) throws Exception;

		//전체데이터
		public List<BoardDTO> getList(int start, int end, String searchKey, String searchValue) throws Exception;

		//전체 데이터수 구하기
		public int getDataCount(String searchKey,String searchValue) throws Exception;

		//조회수증가
		public void updateHitCount(int boardNum) throws Exception;
		//한명의 데이터 출력
		public BoardDTO getReadData(int boardNum) throws Exception;
		
		//이전글
		public BoardDTO getPreReadData(int boardNum,String searchKey,String searchValue) throws Exception;
		
		
		//다음글
		public BoardDTO getNextReadData(int boardNum,String searchKey,String searchValue) throws Exception;

		//삭제
		public void deleteData(int boardNum) throws Exception;

		//수정
		public void updateData(BoardDTO dto) throws Exception;
}
