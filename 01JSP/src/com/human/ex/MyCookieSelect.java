package com.human.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyCookieSelect
 */
@WebServlet("/MyCookieSelect")
public class MyCookieSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCookieSelect() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");   
		PrintWriter out=response.getWriter();
		   String cookie=request.getHeader("Cookie");
	System.out.println(cookie);
	if(cookie!=null) {
		Cookie cookies[]=request.getCookies();
		for(int i=0; i<cookies.length;i++) {
			String name=cookies[i].getName();
			String value=cookies[i].getValue();
			out.println("<br>이름"+name+"값:"+value);
			if(name.equals("p3")) {
				out.println("<br>p3찾음"+value);
			}
		}
		out.println("<br><a href='Cookie.jsp'>home</a>");
	}
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
