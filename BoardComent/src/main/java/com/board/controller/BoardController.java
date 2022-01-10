package com.board.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;

import com.board.dto.BoardDTO;
import com.board.service.BoardService;
import com.board.service.CommentService;
import com.jdbc.util.MyUtil;

@Controller("bbs.boardController")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private CommentService cservice;
	
	@Autowired
	MyUtil myUtil;
	
	
	@RequestMapping(value="/bbs/created.action", method={RequestMethod.GET})
	public String created(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("mode", "insert");
		
		return "ibbs/created";
	}
	
	@RequestMapping(value="/bbs/created.action", method={RequestMethod.POST})
	public String created(BoardDTO dto, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int maxNum = service.getMaxNum();
		
		dto.setBoardNum(maxNum+1);
		dto.setIpAddr(request.getRemoteAddr());
		
		service.insertData(dto);
		
		return "redirect:/bbs/list.action";
		
		
	}
	
	@RequestMapping(value="/bbs/list.action", method={RequestMethod.GET,RequestMethod.POST})
	public String list(BoardDTO dto, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		
		String cp = request.getContextPath();
		
		
		String pageNum = request.getParameter("pageNum");
		
		System.out.println(pageNum); //null
		
		int currentPage = 1;
		
		if(pageNum != null)
			currentPage = Integer.parseInt(pageNum);
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		if(searchKey == null){			
			searchKey = "subject";
			searchValue = "";
			
		}else{
			
			if(request.getMethod().equalsIgnoreCase("GET"))
				searchValue =
					URLDecoder.decode(searchValue, "UTF-8");
			
		}
		System.out.println(searchKey);
		System.out.println(searchValue);
		
		//전체데이터갯수
		int dataCount = service.getDataCount(searchKey, searchValue);
		System.out.println("111111");
		System.out.println(dataCount);
		
		//전체페이지수
		int numPerPage = 10;
		int totalPage = myUtil.getPageCount(numPerPage, dataCount);
		
		System.out.println(totalPage);
		
		if(currentPage > totalPage)
			currentPage = totalPage;
		
		int start = (currentPage-1)*numPerPage+1;
		int end = currentPage*numPerPage;
		
		List<BoardDTO> lists = service.getList(start, end, searchKey, searchValue);
		
		int listNum,n=0;
		ListIterator<BoardDTO> it = lists.listIterator();
		
		while(it.hasNext()){
			
			BoardDTO data = (BoardDTO)it.next(); //한개의 데이터에 대한 객체생성?
			
			listNum = dataCount-(start+n-1);
			data.setListNum(listNum);
			//System.out.println("찍히냐?" + data.getBoardNum());
			data.setCommCount(cservice.getDataCount(data.getBoardNum()));
			n++;
			
		}
		
		//페이징 처리
		String param = "";
		if(!searchValue.equals("")){
			param = "searchKey=" + searchKey;
			param+= "&searchValue=" 
				+ URLEncoder.encode(searchValue, "UTF-8");
		}
		
		String listUrl = cp + "/bbs/list.action";
		if(!param.equals("")){
			listUrl = listUrl + "?" + param;				
		}
		
		String pageIndexList =
			myUtil.pageIndexList(currentPage, totalPage, listUrl);
		
		//글보기 주소 정리
		String articleUrl = 
			cp + "/bbs/article.action?pageNum=" + currentPage;
			
		if(!param.equals(""))
			articleUrl = articleUrl + "&" + param;
		
		//포워딩 될 페이지에 데이터를 넘긴다
		request.setAttribute("lists", lists);
		request.setAttribute("pageIndexList",pageIndexList);
		request.setAttribute("dataCount",dataCount);
		request.setAttribute("articleUrl",articleUrl);
		
		return "ibbs/list";
	}
	
	@RequestMapping(value="/bbs/article.action", method={RequestMethod.GET,RequestMethod.POST})
	public String article(HttpServletRequest request, HttpServletResponse response) throws Exception{
	//public ModelAndView article(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String cp = request.getContextPath();
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String pageNum = request.getParameter("pageNum");
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		
		if(searchKey != null){
			searchValue = URLDecoder.decode(searchValue, "UTF-8");
		}else {
			searchKey = "subject";
			searchValue = "";
		}
			
		//System.out.println("searchKey : " + searchKey);
		
		//조회수 증가
		service.updateHitCount(boardNum);
		
		//게시물 가져오기
		BoardDTO dto = service.getReadData(boardNum);
		
		if(dto==null){
			String url = cp + "/bbs/list.action";
			response.sendRedirect(url);
		}

		//System.out.println("searchKey : " + searchKey);
				//글 라인수
		int lineSu = dto.getContent().split("\n").length;
		
		dto.setContent(dto.getContent().replaceAll("\n", "<br/>"));
		
		//이전글
		BoardDTO preDTO = (BoardDTO)service.getPreReadData(boardNum, searchKey, searchValue);
		int preBoardNum = 0;
		String preSubject = "";

		if (preDTO != null) {
			preBoardNum = preDTO.getBoardNum();
			preSubject = preDTO.getSubject();
		}

		//System.out.println("searchKey : " + searchKey);
		//다음글
		BoardDTO nextDTO = (BoardDTO) service.getNextReadData(boardNum, searchKey, searchValue);
		int nextBoardNum = 0;
		String nextSubject = "";

		if (nextDTO != null) {
			nextBoardNum = nextDTO.getBoardNum();
			nextSubject = nextDTO.getSubject();
		}
		
		String param = "pageNum=" + pageNum;
		if(searchKey!=null){
			param += "&searchKey=" + searchKey;
			param += "&searchValue=" 
				+ URLEncoder.encode(searchValue, "UTF-8");
		}
		
		//System.out.println("이전글: "+ preSubject + ", 다음글: " + nextSubject);
		
		
		request.setAttribute("dto", dto);
		request.setAttribute("params",param);
		request.setAttribute("lineSu",lineSu);
		request.setAttribute("pageNum",pageNum);
		request.setAttribute("nextBoardNum", nextBoardNum);
		request.setAttribute("nextSubject", nextSubject);
		request.setAttribute("preBoardNum", preBoardNum);
		request.setAttribute("preSubject", preSubject);
		
		/*ModelAndView mav = new ModelAndView();
		mav.setViewName("bbs/article");
		
		mav.addObject("dto", dto);
		mav.addObject("params",param);
		mav.addObject("lineSu",lineSu);
		mav.addObject("pageNum",pageNum);*/
		
		//return mav;
		return "ibbs/article";
	}
	
	@RequestMapping(value="/bbs/updated.action", method={RequestMethod.GET,RequestMethod.POST})
	public String updated(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//String cp = request.getContextPath();
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String pageNum = request.getParameter("pageNum");
		
		BoardDTO dto = service.getReadData(boardNum);
		
		//System.out.println("여기까지 오는거?");
		/*if(dto == null){
			String url = cp + "/bbs/list.action";
			response.sendRedirect(url);
		}*/
		
		request.setAttribute("dto", dto);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("mode", "update");
		
		return "ibbs/created";
		
	}
	
	@RequestMapping(value="/bbs/updated_ok.action", method={RequestMethod.GET,RequestMethod.POST})
	public String updated_ok(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String pageNum = request.getParameter("pageNum");
		
		BoardDTO dto = new BoardDTO();
		
		dto.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));
		dto.setSubject(request.getParameter("subject"));
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setPwd(request.getParameter("pwd"));
		dto.setContent(request.getParameter("content"));
		
		service.updateData(dto);
		
		return "redirect:/bbs/list.action?pageNum=" + pageNum;
		
	}
	
	@RequestMapping(value="/bbs/deleted.action", method={RequestMethod.GET,RequestMethod.POST})
	public String deleted(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String pageNum = request.getParameter("pageNum");
		int boardNum =Integer.parseInt(request.getParameter("boardNum"));
		
		service.deleteData(boardNum);
		
		return "redirect:/bbs/list.action?pageNum=" + pageNum;
	}
}
