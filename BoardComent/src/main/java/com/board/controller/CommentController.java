package com.board.controller;

import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.dto.CommentDTO;
import com.board.service.CommentService;
import com.jdbc.util.MyUtil;


@Controller("comm.commentController")
public class CommentController {

	@Autowired
	private CommentService cservice;

	@Autowired
	MyUtil myUtil;

	@RequestMapping(value="/comm/created.action", method={RequestMethod.POST})
	public String created(String name,HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//System.out.println("이름: " + name);

		CommentDTO dto = new CommentDTO();
		
		int numMax = cservice.getMaxNum();
		
		dto.setName(name);
		dto.setContent(request.getParameter("content"));
		dto.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));
		dto.setCommentNum(numMax+1);
		dto.setIpAddr(request.getRemoteAddr());
		
		//System.out.println(dto.getBoardNum());
		
		//System.out.println("댓글번호: "+ dto.getCommentNum() + " 보드번호: " + dto.getBoardNum());

		cservice.insertData(dto);

		return "redirect:/comm/list.action?boardNum=" + dto.getBoardNum();
	}

	@RequestMapping(value="/comm/list.action", method={RequestMethod.GET,RequestMethod.POST})
	public String list(CommentDTO dto, HttpServletRequest request, HttpServletResponse response) throws Exception {

		//String cp = request.getContextPath();
		
		int numPerPage = 5;
		int totalPage=0;
		int totalDataCount = 0;
		//System.out.println("위에서 받는" + dto.getBoardNum());
		String pageNO = request.getParameter("pageNO");
		//int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		//System.out.println("찍히냐?" + boardNum);
		//System.out.println("pageNO이 뭐야 ? "+pageNO);
		
		//	String pageNO = dto.getPageNO();


		int currentPage = 1;
		//처음 실행하면 pageNum이 null, 한번실행 후 다른 페이지 클릭하면 !?
		if(pageNO  != null){
			currentPage = Integer.parseInt(pageNO);
		}
		else
			pageNO="1";
		
		
		//CommentDTO dto = new CommentDTO();
		
		
		//dto.setBoardNum(boardNum);
		
		totalDataCount = cservice.getDataCount(dto.getBoardNum());
		
		
		//전체 페이지수 구하기
		if(totalDataCount!=0)
			totalPage = myUtil.getPageCount(numPerPage, totalDataCount);

		//삭제에 의해서 이럴 경우
		if(currentPage > totalPage){
			currentPage = totalPage;
		}

		int start = (currentPage-1)* numPerPage+1;
		int end = currentPage * numPerPage;


		List<CommentDTO> lists = cservice.getList(start, end, dto.getBoardNum());

		ListIterator<CommentDTO> it = lists.listIterator();

		int listNum, n=0;

		while(it.hasNext()){
			
			CommentDTO ldto = (CommentDTO)it.next();
			listNum = totalDataCount - (start+n-1);
			ldto.setListNum(listNum);
			ldto.setContent(ldto.getContent().replaceAll("\n", "<br/>"));
			n++;			

		}			
		
		
		String pageIndexList = myUtil.pageIndexList(currentPage, totalPage);

		request.setAttribute("lists", lists);
		request.setAttribute("totalDataCount", totalDataCount);
		request.setAttribute("pageIndexList", pageIndexList);
		request.setAttribute("pageNO", currentPage);

		return "ibbs/commList";

	}
	@RequestMapping(value="/comm/deleted.action", method={RequestMethod.GET,RequestMethod.POST})
	public String delete(CommentDTO dto, HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		cservice.deleteData(dto.getCommentNum());

		return "redirect:/comm/list.action?boardNum=" + dto.getBoardNum();
	}

}
