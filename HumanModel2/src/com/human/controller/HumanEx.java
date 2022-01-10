package com.human.controller;

import com.human.execute.Execute;
import com.human.execute.HumanDelete;
import com.human.execute.HumanInsert;
import com.human.execute.HumanSelect;
import com.human.execute.HumanUpdate;
import com.human.utill.UserInput;
import com.human.vo.Request;
import com.human.vo.Response;

public class HumanEx {

	public static void main(String[] args) {
		Execute execute=null;
		boolean isFlag = true;
		while (isFlag) {
			Request request=new Request ();
			Response response = new Response ();
		System.out.println("humanTable 1.insert "+ "2.select 3.delete 4.update 5.exit");
			switch(UserInput.inputString(">>")) {
			case "1":
				execute = new HumanInsert();
				execute.execute(request, response);	
				break;
			case "2":
				execute = new HumanSelect();
				execute.execute(request, response);	
				break;
			case "3":
				execute = new HumanDelete();
				execute.execute(request, response);	
				break;
			case "4":
				execute = new HumanUpdate();
				execute.execute(request, response);	
				break;
			default:
				isFlag=false;
				break;
			}
		}
		System.out.println("프로그램 종료");

	}

}
