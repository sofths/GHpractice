package com.human.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.dao.BoardDAO;
import com.human.dto.BoardDTO;
import com.human.vo.PageMaker;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void write(BoardDTO board) throws Exception {
		System.out.println(sqlSession);
		BoardDAO dao=sqlSession.getMapper(BoardDAO.class);
		dao.create(board);

	}
	@Override
	public BoardDTO read(int titleNum) throws Exception {
		BoardDAO dao=sqlSession.getMapper(BoardDAO.class);
		return dao.read(titleNum);
	}
	@Override
	public void modify(BoardDTO board) throws Exception {
		BoardDAO dao=sqlSession.getMapper(BoardDAO.class);
		dao.update(board);
	}
	@Override
	public void remove(int titleNum) throws Exception {
		BoardDAO dao=sqlSession.getMapper(BoardDAO.class);
		dao.delete(titleNum);
	}
	@Override
	public List<BoardDTO> listSearchCriteria(PageMaker pm) throws Exception {
		BoardDAO dao=sqlSession.getMapper(BoardDAO.class);
		return dao.listSearch(pm);
	}
	@Override
	public int listSearchCount(PageMaker pm) throws Exception {
		BoardDAO dao=sqlSession.getMapper(BoardDAO.class);
		return dao.listSearchCount(pm);
	}
}
