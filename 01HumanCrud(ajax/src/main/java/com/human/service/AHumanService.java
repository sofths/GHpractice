package com.human.service;

import java.util.ArrayList;

import com.human.dto.AHumanDto;



public interface AHumanService {

		public void insert(AHumanDto dto) throws Exception;
		public void update(AHumanDto dto) throws Exception;
		public void delete(String name) throws Exception;
		public ArrayList<AHumanDto> selectAll() throws Exception;
		public AHumanDto selectName(String name) throws Exception;
		


}
