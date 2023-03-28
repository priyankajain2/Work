package com.cg.ibs.investment.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InvestmentController {
	
	@RequestMapping({"/","/home"})
	public String showHome(){
		return "homePage";
	}

	@RequestMapping("/menu")
	public String showMenu(){
		return "menuPage";
	}
	
	@RequestMapping({"/custLogOut","/bankLogOut"})
	public ModelAndView logOut(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.invalidate();
		mv.setViewName("homePage");
		mv.addObject("message","You are Successfully logged out !!");
		return mv;
	}
}
