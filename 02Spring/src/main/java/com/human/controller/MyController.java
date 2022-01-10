package com.human.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {


	@RequestMapping("board/confirmid")
	public String confirmId(@RequestParam("id")String id,@RequestParam("pw") int pw,Model model,@RequestParam("hobby") List<String> hobby) {
		
			
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		return "home";
	}
	
	
	
//	@RequestMapping(value = "/mynew", method = RequestMethod.GET)
//	public String mynew(Model model) {
//		model.addAttribute("data", "mynewdata" );
//		return "mynew";
//	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("data", "mynewdata" );
		return "myview/home";
	}
	@RequestMapping(value = "/myview/home", method = RequestMethod.GET)
	public void home2(Model model) {
		model.addAttribute("data", "mynewdata" );
//		return "myview/myview/home";
	}
//	@RequestMapping(value="/board/reply",method=RequestMethod.GET)
//	public ModelAndView reply() {
//		ModelAndView mv=new ModelAndView();
//		mv.addObject("id",30);
//		mv.setViewName("myview/home");
//		return mv;
//	}	
}
