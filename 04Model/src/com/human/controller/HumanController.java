package com.human.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.command.DeleteCommand;
import com.human.command.DeleteDBCommand;
import com.human.command.ICommand;
import com.human.command.InsertCommand;
import com.human.command.InsertDBCommand;
import com.human.command.SelectDBCommand;
import com.human.command.UpdateCommand;
import com.human.command.UpdateDBCommand;

/**
 * Servlet implementation class HumanController
 */
@WebServlet("*.do")
public class HumanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HumanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		System.out.println(uri);///jsp10frontController/insert.do
		String conPath=request.getContextPath();///jsp10frontController
		
		String command=uri.substring(conPath.length());
		String viewPage="view.jsp";
		
		ICommand ic=null;
		
		if(command.equals("/insert.do")){
			System.out.println("insert.do");
			viewPage="insert.jsp";
		}else if(command.equals("/insertDB.do")){
			System.out.println("select.do");
			viewPage="insertDB.jsp";
			ic=new InsertDBCommand();
			ic.execute(request, response);
			
		}else if(command.equals("/select.do")){
			System.out.println("select.do");
			viewPage="select.jsp";
		}else if(command.equals("/selectDB.do")){
			System.out.println("selectDB.do");
			viewPage="selectDB.jsp";
			
			ic= new SelectDBCommand();
			ic.execute(request,response);
			
		}else if(command.equals("/delete.do")){
			viewPage="delete.jsp";
			
		}else if(command.equals("/deleteDB.do")){
			viewPage="deleteDB.jsp";
			ic= new DeleteDBCommand();
			ic.execute(request,response);
			
			
		}else if(command.equals("/update.do")){
			viewPage="update.jsp";
			
		}else if(command.equals("/updateDB.do")){
			viewPage="updateDB.jsp";
			ic= new UpdateDBCommand();
			ic.execute(request,response);
			
		}
		
		
		//
		RequestDispatcher dispatcher=
				request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
