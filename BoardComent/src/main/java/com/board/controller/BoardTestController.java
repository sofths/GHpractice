package com.board.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.dto.BoardTestDTO;
import com.board.service.BoardTestService;
import com.jdbc.util.MyUtil;

@Controller("rboard.boardTestController")
public class BoardTestController {
	
	@Autowired
	private BoardTestService btservice;
	
	@Autowired
	MyUtil myUtil;
	
	/*@RequestMapping(value="/rboard/created.action", method={RequestMethod.GET,RequestMethod.POST})
	public String created(HttpServletRequest request, HttpServletResponse response){
		////if(dto==null || dto.getMode()==null || dto.getMode().equals("")){

			//mode 값에 따라서 다르게 함
			request.setAttribute("mode", "created");

			return "board/created";
		//}
		
	}*/

	@RequestMapping(value="/rboard/created.action", method={RequestMethod.GET,RequestMethod.POST})
	public String created_ok(BoardTestDTO dto,HttpServletRequest request, HttpServletResponse response) throws Exception {

		//System.out.println("이름qqq:" + dto.getName());
		
		//게시물 입력
		
		if(dto==null || dto.getMode()==null || dto.getMode().equals("")){

				//mode 값에 따라서 다르게 함
				request.setAttribute("mode", "created");

				return "board/created";
		}
		
		//BoardTestDTO dto = new BoardTestDTO();
		
	//	String name = request.getParameter("name");
	//	String content = request.getParameter("content");
		
		//System.out.println("이름: " + dto.getName());

		//게시물 저장
		//CommonDAO dao = CommonDAOImpl.getInstance();

		int maxBoardNum = btservice.getMaxNum();

		dto.setBoardNum(maxBoardNum+1);
		dto.setIpAddr(request.getRemoteAddr());


		dto.setGroupNum(dto.getBoardNum());
		dto.setDepth(0);
		dto.setOrderNo(0);
		dto.setParent(0);

		btservice.insertData(dto);


		return "redirect:/rboard/list.action";
	}

	@RequestMapping(value="/rboard/list.action", method={RequestMethod.GET,RequestMethod.POST})
	public String list(BoardTestDTO dto,HttpServletRequest request, HttpServletResponse response) throws Exception {

		//게시물 리스트
		String cp = request.getContextPath();
		
		String pageNum = request.getParameter("pageNum");

		int numPerPage = 10;
		int totalPage = 0;
		int totalDataCount = 0;

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
		/*Map<String, Object> hMap = new HashMap<String, Object>();

		hMap.put("searchKey", dto.getSearchKey());
		hMap.put("searchValue", dto.getSearchValue());*/
		
		//전체데이터갯수
		totalDataCount = btservice.getDataCount(searchKey, searchValue);
		
		if(totalDataCount!=0)
			totalPage = myUtil.getPageCount(numPerPage, totalDataCount);

		if(currentPage > totalPage)
			currentPage = totalPage;

		int start = (currentPage-1)*numPerPage+1;
		int end = currentPage*numPerPage;


		List<BoardTestDTO> lists = 
				(List<BoardTestDTO>)btservice.getList(start, end, searchKey, searchValue);

		int listNum, n=0;

		ListIterator<BoardTestDTO> it = lists.listIterator();

		while(it.hasNext()){

			dto = (BoardTestDTO)it.next();

			listNum = totalDataCount-(start+n-1);
			dto.setListNum(listNum);
			n++;

		}

		String param = "";
		String urlList = "";
		String urlArticle = "";
		
		if(!searchValue.equals("")){
			param = "searchKey=" + searchKey;
			param+= "&searchValue=" 
				+ URLEncoder.encode(searchValue, "UTF-8");
		}

		//사용자정의-----------------------------------------------------
		urlList = cp + "/rboard/list.action";
		urlArticle = cp + "/rboard/article.action?pageNum=" + currentPage;

		if(!param.equals("")){

			urlList+= "?" + param;
			urlArticle+= "&" + param;

		}//--------------------------------------------------------------

		request.setAttribute("lists", lists);
		request.setAttribute("totalDataCount", totalDataCount);
		request.setAttribute("pageIndexList", 
				myUtil.pageIndexList(currentPage, totalPage, urlList));
		request.setAttribute("urlArticle", urlArticle);


		return "board/list";
	}

	@RequestMapping(value="/rboard/article.action", method={RequestMethod.GET,RequestMethod.POST})
	public String article(BoardTestDTO dto,HttpServletRequest request, HttpServletResponse response) throws Exception {

		//글보기

		String pageNum = request.getParameter("pageNum");
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		int boardNum = dto.getBoardNum();

		if(searchKey==null || searchKey.equals("")){ //dto로 할수 있다
			searchKey = "subject";
			searchValue = "";
		}

		if(request.getMethod().equalsIgnoreCase("GET"))
			searchValue = URLDecoder.decode(searchValue,"UTF-8");

		//조회수 증가
		btservice.updateHitCount(boardNum);

		dto = (BoardTestDTO)btservice.getReadData(boardNum);

		if(dto==null)
			return "read-error";

		int lineSu = dto.getContent().split("\r\n").length;

		dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));

		//이전글 다음글
		Map<String , Object> hMap = new HashMap<String, Object>();

		hMap.put("searchKey", searchKey);
		hMap.put("searchValue", searchValue);
		hMap.put("groupNum", dto.getGroupNum());
		hMap.put("orderNo", dto.getOrderNo());

		//이전글
		BoardTestDTO preDTO = (BoardTestDTO)btservice.getPreReadData(hMap);
		int preBoardNum = 0;
		String preSubject = "";
		if(preDTO!=null){
			preBoardNum = preDTO.getBoardNum();
			preSubject = preDTO.getSubject();
		}

		//다음글
		BoardTestDTO nextDTO = (BoardTestDTO)btservice.getNextReadData(hMap);
		int nextBoardNum = 0;
		String nextSubject = "";
		if(nextDTO!=null){
			nextBoardNum = nextDTO.getBoardNum();
			nextSubject = nextDTO.getSubject();
		}

		String params = "pageNum=" + pageNum;
		if(!searchValue.equals("")){
			params+= "&searchKey=" + searchKey;
			params+= "&searchValue=" + URLEncoder.encode(searchValue,"UTF-8");
		}

		request.setAttribute("preBoardNum", preBoardNum);
		request.setAttribute("preSubject", preSubject);
		request.setAttribute("nextBoardNum", nextBoardNum);
		request.setAttribute("nextSubject", nextSubject);
		request.setAttribute("dto", dto);
		request.setAttribute("params", params);
		request.setAttribute("lineSu", lineSu);
		request.setAttribute("pageNum", pageNum);

		return "board/article";
	}

	@RequestMapping(value="/rboard/deleted.action", method={RequestMethod.GET,RequestMethod.POST})
	public String deleted(BoardTestDTO dto,HttpServletRequest request, HttpServletResponse response) throws Exception {

		//삭제
		String pageNum = request.getParameter("pageNum");
		btservice.deleteData(dto.getBoardNum());

		return "redirect:/rboard/list.action?pageNum=" + pageNum;

	}

	@RequestMapping(value="/rboard/updated.action", method={RequestMethod.GET,RequestMethod.POST})
	public String updated(BoardTestDTO dto,HttpServletRequest request, HttpServletResponse response) throws Exception {

		//게시물 수정 화면 표시
		
		String pageNum = request.getParameter("pageNum");
		
		if(dto.getMode()==null || dto.getMode().equals("")){

			

			dto = (BoardTestDTO)btservice.getReadData(dto.getBoardNum());

			if(dto==null)
				return "read-error";

			request.setAttribute("mode", "updated");
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("dto", dto);

			return "board/created";
		}
		
		//게시물 수정
		btservice.updateData(dto);

		return "redirect:/rboard/list.action?pageNum=" + pageNum;
		
	}
	@RequestMapping(value="/rboard/reply.action", method={RequestMethod.GET,RequestMethod.POST})
	public String reply(BoardTestDTO dto,HttpServletRequest request, HttpServletResponse response) throws Exception {//공부!!!!!!!

		//답변화면
		
		String pageNum = request.getParameter("pageNum");

		if(dto==null || dto.getMode()==null || dto.getMode().equals("")){

			dto = (BoardTestDTO)btservice.getReadData(dto.getBoardNum());

			if(dto==null)
				return "read-error";

			String temp = "\r\n\r\n---------------------------------------\r\n\r\n";

			temp += "[답변]\r\n";
			dto.setContent(dto.getContent() + temp);

			dto.setName("");
			dto.setEmail("");
			dto.setPwd("");

			request.setAttribute("mode", "reply");
			request.setAttribute("dto", dto);
			request.setAttribute("pageNum", pageNum);

			return "board/created";
		}

		//답변

		//orderNo수정
		btservice.orderNoUpdate(dto.getGroupNum(),dto.getOrderNo());

		//답변입력
		int maxBoardNum = btservice.getMaxNum();
		System.out.println(dto.getBoardNum());
		//dto.setParent(dto.getBoardNum());
		dto.setBoardNum(maxBoardNum + 1);
		dto.setIpAddr(request.getRemoteAddr());
		dto.setDepth(dto.getDepth() + 1);
		dto.setOrderNo(dto.getOrderNo() + 1);

		btservice.insertData(dto);

		return "redirect:/rboard/list.action?pageNum=" + pageNum;

	}

}
