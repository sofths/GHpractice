
package com.human.ex;

import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.human.dto.BoardDTO;
import com.human.service.BoardService;
import com.human.vo.PageMaker;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {
	@Inject
	private BoardService bm;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(PageMaker pm, Model model) throws Exception {
		logger.info("listPage");
		System.out.println(pm);
		// PageMaker [page=2, perPageNum=10, searchType=t, keyword=888, totalCount=0,
		// startPage=0, endPage=0, prev=false, next=false]
		model.addAttribute("list", bm.listSearchCriteria(pm));
		pm.setTotalCount(bm.listSearchCount(pm));
		// model.addAttribute("pageMaker",pm);
		// return "sboard/list";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void writeGet() throws Exception {
		// return "/sboard/write
		
		
	}
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePost(BoardDTO board, RedirectAttributes rttr) throws Exception {
		bm.write(board);
		// rttr.addAttribute("msg","success");
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/sboard/list";
	}
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("titleNum") int titleNum, PageMaker pm, Model model) throws Exception {
		System.out.println(pm);
		model.addAttribute(bm.read(titleNum));
		// return "/sboard/read
	}
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("titleNum") int titleNum, PageMaker pm, Model model, RedirectAttributes rttr)
			throws Exception {
		bm.remove(titleNum);
		rttr.addAttribute("page", pm.getPage());
		rttr.addAttribute("perPageNum", pm.getPerPageNum());
		rttr.addAttribute("searchType", pm.getSearchType());
		rttr.addAttribute("keyword", pm.getKeyword());
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/sboard/list";
	}
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGet(@RequestParam("titleNum") int titleNum, PageMaker pm, Model model) throws Exception {
		System.out.println(pm);
		model.addAttribute(bm.read(titleNum));
	}
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPost(BoardDTO board, PageMaker pm, Model model, RedirectAttributes rttr) throws Exception {
		bm.modify(board);
		System.out.println(pm);
		rttr.addAttribute("page", pm.getPage());
		rttr.addAttribute("perPageNum", pm.getPerPageNum());
		rttr.addAttribute("searchType", pm.getSearchType());
		rttr.addAttribute("keyword", pm.getKeyword());
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/sboard/list";
	}
	@RequestMapping(value = "/faqtop", method = RequestMethod.GET)
	public void faqtopGet() throws Exception {

	}

}