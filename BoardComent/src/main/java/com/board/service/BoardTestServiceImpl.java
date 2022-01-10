package com.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.BoardTestDAO;
import com.board.dto.BoardTestDTO;

@Service
public class BoardTestServiceImpl implements BoardTestService{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int getMaxNum() throws Exception {
		BoardTestDAO dao = sqlSession.getMapper(BoardTestDAO.class);
		return dao.maxBoardNum();
	}

	@Override
	public void insertData(BoardTestDTO dto) throws Exception {
		BoardTestDAO dao = sqlSession.getMapper(BoardTestDAO.class);	
		dao.insertData(dto);
	}

	@Override
	public List<BoardTestDTO> getList(int start, int end, String searchKey, String searchValue) throws Exception {
		BoardTestDAO dao = sqlSession.getMapper(BoardTestDAO.class);
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("start", start);
		params.put("end", end);
		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);
		return dao.listData(params);
	}

	@Override
	public int getDataCount(String searchKey, String searchValue) throws Exception {
		BoardTestDAO dao = sqlSession.getMapper(BoardTestDAO.class);
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);
		return dao.dataCount(params);
	}

	@Override
	public void updateHitCount(int boardNum) throws Exception {
		BoardTestDAO dao = sqlSession.getMapper(BoardTestDAO.class);
		dao.hitCountUpdate(boardNum);
	}

	@Override
	public BoardTestDTO getReadData(int boardNum) throws Exception {
		BoardTestDAO dao = sqlSession.getMapper(BoardTestDAO.class);
		return dao.readData(boardNum);
	}

	@Override
	public BoardTestDTO getPreReadData(Map<String, Object> hmap) throws Exception {
		BoardTestDAO dao = sqlSession.getMapper(BoardTestDAO.class);
		return dao.preReadData(hmap);
	}

	@Override
	public BoardTestDTO getNextReadData(Map<String, Object> hmap) throws Exception {
		BoardTestDAO dao = sqlSession.getMapper(BoardTestDAO.class);
		return dao.nextReadData(hmap);
	}

	@Override
	public void deleteData(int boardNum) throws Exception {
		BoardTestDAO dao = sqlSession.getMapper(BoardTestDAO.class);
		dao.deleteData(boardNum);
	}

	@Override
	public void updateData(BoardTestDTO dto) throws Exception {
		BoardTestDAO dao = sqlSession.getMapper(BoardTestDAO.class);
		dao.updateData(dto);
	}

	@Override
	public void orderNoUpdate(int groupNum, int orderNo) throws Exception {
		BoardTestDAO dao = sqlSession.getMapper(BoardTestDAO.class);
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("groupNum", groupNum);
		params.put("orderNo", orderNo);
		dao.orderNoUpdate(params);
	}

}
