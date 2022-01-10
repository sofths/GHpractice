package com.human.execute;

import javax.xml.ws.Response;

import org.omg.CORBA.Request;




public interface Execute {
	default public void execute (Request request,Response response) {
		inputView(request,response);
		businessLogic(request,response);
		outputView(request,response);
	};
	
	public void businessLogic(Request request, Response response);

	public void inputView(Request request, Response response);
	
	public void outputView(Request request, Response response);


}
