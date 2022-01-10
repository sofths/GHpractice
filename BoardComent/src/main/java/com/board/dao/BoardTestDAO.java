package com.board.dao;

import java.util.List;
import java.util.Map;


import com.board.dto.BoardTestDTO;



public interface BoardTestDAO {


	//1.num의 최대값
		public int maxBoardNum() throws Exception;

		//입력(created.jsp->created_ok.jsp)
		public void insertData(BoardTestDTO dto) throws Exception;

		//전체데이터 리스트
		public List<BoardTestDTO> listData(Map<String, Object> params) throws Exception;

		//전체 데이터수 구하기
		public int dataCount(Map<String, Object> params) throws Exception;


		//조회수증가
		public void hitCountUpdate(int boardNum) throws Exception;

		//한명의 데이터 출력
		public BoardTestDTO readData(int boardNum) throws Exception;

		//이전글
		public BoardTestDTO preReadData(Map<String, Object> hmap) throws Exception;


		//다음글
		public BoardTestDTO nextReadData(Map<String, Object> hmap) throws Exception;

		//삭제
		public void deleteData(int boardNum) throws Exception;

		//수정
		public void updateData(BoardTestDTO dto) throws Exception;
		
		public void orderNoUpdate(Map<String, Object> params) throws Exception;

}
