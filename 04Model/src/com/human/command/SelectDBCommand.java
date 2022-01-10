package com.human.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.HumanDao;
import com.human.dto.HumanDto;

public class SelectDBCommand implements ICommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HumanDao dao=new HumanDao();
		ArrayList<HumanDto> dtos = 
				dao.select(request.getParameter("name"));
		
		request.setAttribute("dtos", dtos);
		
	}

}
