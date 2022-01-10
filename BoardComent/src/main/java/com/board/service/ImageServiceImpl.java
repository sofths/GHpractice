package com.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.ImageDAO;
import com.board.dto.ImageDTO;

@Service
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertData(ImageDTO dto) throws Exception {
		ImageDAO dao = sqlSession.getMapper(ImageDAO.class);
		dao.insertData(dto);
	}

	@Override
	public int getMaxNum() throws Exception {
		ImageDAO dao = sqlSession.getMapper(ImageDAO.class);
		return dao.maxNum();
	}

	@Override
	public int getDataCount() throws Exception {
		ImageDAO dao = sqlSession.getMapper(ImageDAO.class);
		return dao.dataCount();
	}

	@Override
	public List<ImageDTO> getList(int start, int end) throws Exception {
		ImageDAO dao = sqlSession.getMapper(ImageDAO.class);
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("start", start);
		params.put("end", end);
	
		return dao.listData(params);
	}

	@Override
	public ImageDTO getReadData(int num) throws Exception {
		ImageDAO dao = sqlSession.getMapper(ImageDAO.class);
		return dao.readData(num);
	}

	@Override
	public void deleteData(int num) throws Exception {
		ImageDAO dao = sqlSession.getMapper(ImageDAO.class);
		dao.deleteData(num);
	}

}
