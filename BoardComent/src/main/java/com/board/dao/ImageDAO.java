package com.board.dao;

import java.util.List;
import java.util.Map;

import com.board.dto.ImageDTO;


public interface ImageDAO {
	

public void insertData(ImageDTO dto) throws Exception;
	
	public int maxNum() throws Exception;
	
	public int dataCount() throws Exception;
	
	
	public List<ImageDTO> listData(Map<String, Object> params) throws Exception;
	
	//하나의 데이터 불러오기
	public ImageDTO readData(int num) throws Exception;
	
	//삭제
	public void deleteData(int num) throws Exception;
}
