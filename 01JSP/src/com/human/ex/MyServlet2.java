package com.human.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet2
 */
@WebServlet("/MyServlet2")
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out1=response.getWriter();
		out1.println("<html>");
		out1.println("<body>");
		out1.println("doGet"+id+pw);
		out1.println("</body>");
		out1.println("</html>");
		out1.println("<a href='NewFile.html'>홈으로</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out1=response.getWriter();
		out1.println("<html>");
		out1.println("<body>");
		out1.println("doPost"+id+pw);
		out1.println("</body>");
		out1.println("</html>");
		out1.println("<a href='NewFile.html'>홈으로</a>");
	}

}
