package com.human.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class selectPrint implements IDBPrint {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	System.out.println("셀렉트 작업완료");
	}

}
