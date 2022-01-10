package com.human.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IDBPrint {
	void execute(HttpServletRequest request,
			HttpServletResponse response);
}
