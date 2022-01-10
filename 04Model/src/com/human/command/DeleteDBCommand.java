package com.human.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteDBCommand implements ICommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		com.human.dao.HumanDao dao=new com.human.dao.HumanDao();
		int result=dao.delete(request.getParameter("name"));
		request.setAttribute("result",result);
//		if(result==1){
//			out.println("성공");		
//		}else{
//			out.println("실패");
//		}
	}

}
