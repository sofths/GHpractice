package com.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired // DI(의존주입): 외부에서 미리 만들어서 사용, xml
	private SqlSession sqlSession;

	@Override
	public int getMaxNum() throws Exception {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.maxBoardNum();
	}

	@Override
	public void insertData(BoardDTO dto) throws Exception {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.insertData(dto);
	}

	@Override
	public List<BoardDTO> getList(int start, int end, String searchKey, String searchValue) throws Exception {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("start", start);
		params.put("end", end);
		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);

		return dao.listData(params);
	}

	@Override
	public int getDataCount(String searchKey, String searchValue) throws Exception {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);

		return dao.dataCount(params);
	}

	@Override
	public void updateHitCount(int boardNum) throws Exception {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.hitCountUpdate(boardNum);

	}

	@Override
	public BoardDTO getReadData(int boardNum) throws Exception {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.readData(boardNum);
	}

	@Override
	public BoardDTO getPreReadData(int boardNum, String searchKey, String searchValue) throws Exception {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);
		params.put("boardNum", boardNum);
		return dao.preReadData(params);
	}

	@Override
	public BoardDTO getNextReadData(int boardNum, String searchKey, String searchValue) throws Exception {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);
		params.put("boardNum", boardNum);
		return dao.nextReadData(params);
	}

	@Override
	public void deleteData(int boardNum) throws Exception {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.deleteData(boardNum);

	}

	@Override
	public void updateData(BoardDTO dto) throws Exception {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.updateData(dto);
	}

}
