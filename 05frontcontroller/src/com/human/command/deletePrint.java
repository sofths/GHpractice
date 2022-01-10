package com.human.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deletePrint implements IDBPrint {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("delete 작업완료");
	}

}
