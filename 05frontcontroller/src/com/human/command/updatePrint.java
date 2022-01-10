package com.human.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class updatePrint implements IDBPrint {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	System.out.println("업데이트 작업완료");

	}

}
