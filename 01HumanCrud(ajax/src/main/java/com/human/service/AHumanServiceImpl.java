package com.human.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.human.dto.AHumanDto;

public class AHumanServiceImpl implements AHumanService {

	@Autowired
	private SqlSession sqlSession;
	@Override
	public void insert(AHumanDto dto) throws Exception {


	}

	@Override
	public void update(AHumanDto dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String name) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<AHumanDto> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AHumanDto selectName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
