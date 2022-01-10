package com.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.CommentDAO;
import com.board.dto.CommentDTO;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired //DI(의존주입): 외부에서 미리 만들어서 사용, xml
	private SqlSession sqlSession;
	
	@Override
	public int getMaxNum() throws Exception {
		CommentDAO dao = sqlSession.getMapper(CommentDAO.class);
		return dao.commNumMax();
	}

	@Override
	public void insertData(CommentDTO dto) throws Exception {
		CommentDAO dao = sqlSession.getMapper(CommentDAO.class);
		dao.commInsertData(dto);
		
	}

	@Override
	public List<CommentDTO> getList(int start, int end, int boardNum) throws Exception {
		CommentDAO dao = sqlSession.getMapper(CommentDAO.class);
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("start", start);
		params.put("end", end);
		params.put("boardNum", boardNum);
		
		return dao.commListData(params);
	}

	@Override
	public int getDataCount(int boardNum) throws Exception {
		CommentDAO dao = sqlSession.getMapper(CommentDAO.class);
		return dao.commDataCount(boardNum);
	}

	@Override
	public void deleteData(int commentNum) throws Exception {
		CommentDAO dao = sqlSession.getMapper(CommentDAO.class);
		dao.commDeleteData(commentNum);
	}

}
