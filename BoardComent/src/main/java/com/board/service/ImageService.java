package com.board.service;

import java.util.List;

import com.board.dto.ImageDTO;

public interface ImageService {
	
	public void insertData(ImageDTO dto) throws Exception;
	
	public int getMaxNum() throws Exception;
	
	public int getDataCount() throws Exception;
	
	public List<ImageDTO> getList(int start, int end) throws Exception;
	
	//하나의 데이터 불러오기
	public ImageDTO getReadData(int num) throws Exception;
	
	//삭제
	public void deleteData(int num) throws Exception;
}
