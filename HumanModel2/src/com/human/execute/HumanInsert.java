package com.human.execute;

import javax.xml.ws.Response;

import org.omg.CORBA.Request;

import com.human.dto.HumanDto;
import com.human.utill.UserInput;

public class HumanInsert implements Execute{
	@Override
	public void inputView(Request request, Response response) {
		//insert 작업
		System.out.println("human데이터 정보를 입력하세요.");
		String name = UserInput.inputString("이름을 입력하세요>>");
		int age = UserInput.inputInt("나이를 입력하세요 >");
		double height = UserInput.inputDouble("키를 입력하세요 >>");
		String birthday = UserInput.inputString("생일을 입력하세요 (yyyy/MM/dd)>>");
		HumanDto dto = new HumanDto (name,age,height,UserInput.stringToDate(birthday));
		request.setAttribute("dto",dto); 
	}

	@Override
	public void businessLogic(Request request, Response response) {
		HumanDto dto=(HumanDto)request.getAttribute("dto");
		
	}


	@Override
	public void outputView(Request request, Response response) {
		// TODO Auto-generated method stub
		
	}
	


}
