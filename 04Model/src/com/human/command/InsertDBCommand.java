package com.human.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.HumanDao;
import com.human.dto.HumanDto;

public class InsertDBCommand implements ICommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HumanDto dto=new HumanDto();
		dto.setName(request.getParameter("name"));
		dto.setAge(Integer.parseInt(request.getParameter("age")));
		dto.setTall(Double.parseDouble(request.getParameter("tall")));
		// "yyyy-MM-dd'T'hh:mm"
		dto.setBirthString(request.getParameter("birth"));
		
		HumanDao dao =new HumanDao();
		int i=dao.insert(dto);
		
		request.setAttribute("dto", dto);
		request.setAttribute("i", i);
			
	}

}
