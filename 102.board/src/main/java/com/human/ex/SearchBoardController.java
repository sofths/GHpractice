
package com.human.ex;

import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		@Autowired
	  private BoardService bm;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(PageMaker pm,Model model) throws Exception {
		logger.info("listPage");
		System.out.println(pm);
		//PageMaker [page=2, perPageNum=10, searchType=t, keyword=888, totalCount=0, startPage=0, endPage=0, prev=false, next=false]
		model.addAttribute("list",bm.listSearchCriteria(pm));
		pm.setTotalCount(bm.listSearchCount(pm));
		//model.addAttribute("pageMaker",pm);
		//return "sboard/list";
	}
}
