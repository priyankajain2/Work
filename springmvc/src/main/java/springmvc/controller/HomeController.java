package springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		System.out.println("this is home url");
		return "index";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("name", "Priyanka Jain");
		model.addAttribute("edu", "Masters of Engineering");
		
		List<String> projects = new ArrayList<String>();
		projects.add("A Web Apllication: Catch-up");
		projects.add("A Optimzed Intsallation of Security Cameras");
		projects.add("A Investment Management System");
		
		model.addAttribute("project", projects);
		
		System.out.println("this is the about page");
		return "about";
	}
	
	@RequestMapping("/workexp")
	public ModelAndView workExp() {
		ModelAndView modal = new ModelAndView();
		
		modal.addObject("name", "Capgemini Technology Services");
		modal.addObject("duration", "Sept,2019 - Dec,2022");
		modal.addObject("designation", "Associate Consultant");
		
		modal.setViewName("workexp");
		
		System.out.println("Inside work Experience page");
		return modal;
	}
	
	@RequestMapping("/edu")
	public ModelAndView education() {
		ModelAndView modal = new ModelAndView();
		
		modal.addObject("Master", "MEng in Electrical and Computer Engineering");
		modal.addObject("Ugrad", "B.E in Electrical(Instrumentation and Control) Engineering");
		
		modal.setViewName("edu");
		
		return modal;
	}
	
	@RequestMapping("/certi")
	public ModelAndView certificates() {
		ModelAndView modal = new ModelAndView();
		
		List<String> certif = new ArrayList<String>();
		certif.add("Oracle Java SE 8 Programmer");
		certif.add("IBM Cybersecurity Analyst");
		certif.add("Database Management Essential");
		modal.addObject("certi", certif);
		modal.setViewName("certi");
		
		return modal;
	}
}
