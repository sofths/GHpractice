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
 * Servlet implementation class MyCookieDelete
 */
@WebServlet("/MyCookieDelete")
public class MyCookieDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCookieDelete() {
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
			if(name.equals(request.getParameter("name"))) {
				cookies[i].setMaxAge(0);
				out.println("<br>삭제됨"+name);
				response.addCookie(cookies[i]);
				
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
