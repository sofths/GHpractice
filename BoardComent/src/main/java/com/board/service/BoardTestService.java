package com.board.service;

import java.util.List;
import java.util.Map;

import com.board.dto.BoardTestDTO;

public interface BoardTestService {
	//1.num의 최대값
		public int getMaxNum() throws Exception;

		//입력(created.jsp->created_ok.jsp)
		public void insertData(BoardTestDTO dto) throws Exception;

		//전체데이터 리스트
		public List<BoardTestDTO> getList(int start, int end,
				String searchKey, String searchValue) throws Exception;

		//전체 데이터수 구하기
		public int getDataCount(String searchKey,String searchValue) throws Exception;


		//조회수증가
		public void updateHitCount(int boardNum) throws Exception;
		
		//한명의 데이터 출력
		public BoardTestDTO getReadData(int boardNum) throws Exception;

		//이전글
		public BoardTestDTO getPreReadData(Map<String, Object> hmap) throws Exception;

		//다음글
		public BoardTestDTO getNextReadData(Map<String, Object> hmap) throws Exception;

		//삭제
		public void deleteData(int boardNum) throws Exception;

		//수정
		public void updateData(BoardTestDTO dto) throws Exception;
		
		public void orderNoUpdate(int groupNum, int orderNo) throws Exception;
}
