package com.human.ex;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WeatherServlet
 */
@WebServlet("/googlenews")
public class googlenews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public googlenews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		 PrintWriter out=response.getWriter();
		 //http://apis.data.go.kr/B552061/jaywalking/getRestJaywalking?serviceKey=M8K3w2mpvRglskN45c0h%2Fo7ug7pmma3I9F7g6fpa1vhWYZXX8yPRtVYS0zuPtQ2z%2FL8jDdcSaKzOVBpdKMrRPQ%3D%3D&searchYearCd=2015&siDo=11&guGun=320&type=xml&numOfRows=10&pageNo=1
		 HttpURLConnection conn=null;
		 String str="https://news.google.com/news/feeds?ned=kr";
		 
		 //사이트연결 객체 생성
		 URL url=new URL(str);
		 //사이트 연결해서 결과값리턴
		 conn=(HttpURLConnection)url.openConnection();
		 
		 BufferedInputStream is
		 =new BufferedInputStream(conn.getInputStream());
		 byte[] b =new byte[4096];//2 4 8 16 1024 2048 4096
		 StringBuffer buffer=new StringBuffer();
		  int i;
		      while( (i = is.read(b)) != -1){ 
		        buffer.append(new String(b, 0, i)); 
		     }
		      String str2 = buffer.toString();
		      out.println(str2);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
