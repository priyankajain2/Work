package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class ContactController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/contact")
	public String contactUs() {
		return "contact";
	}
	
	
	//Way 1 using REQUESTPARAM
			//	@RequestMapping(path = "/processform", method = RequestMethod.POST)
			//	//the keyword email in requestparam needs to be same as (jsp file) the name tag used in form for email.
			//	//and the path = processform has to be same as the action keyword inside the form tag
			//	public String HandleConatct(@RequestParam("email") String anyKeywordForEmail,
			//								@RequestParam("name") String name,
			//								@RequestParam("phone") String phone,
			//								@RequestParam("info") String info, Model model) {
			//		
			//		
			//		model.addAttribute("name", name);
			//		
			//		//grab the details and can save in database
			//		//the fields in this user class should be same as fields in jsp file, under the name tag. 
			//		User user = new User();
			//		user.setEmail(anyKeywordForEmail);
			//		user.setName(name);
			//		user.setPhone(phone);
			//		user.setInfo(info);
			//		
			//		System.out.println(anyKeywordForEmail + " " + name + " " + phone);
			//		return "success";
			//	}
	
	//Way 2 using ModelAttribute
	//this @ModelAttribute is doing the task of 3 things together, first it is doing the task of @RequestParam
							//Secondly, It will set the values of parameters in the USer class into user field
							//Thirdly, it will add the attribute in the modal automatically. 
	@RequestMapping(path="/processform" , method = RequestMethod.POST)
	public String HandleContact(@ModelAttribute User user, Model modal) {
		int result = this.userService.saveUser(user);
		System.out.println(result);
		return "success";
	}
	
	//Other use of @ModelAttribute
	//using @ModelAttribute on the top of any function, will make this function 
	//first to be run before any other in the same controller class
	@ModelAttribute
	public void toolbar(Model modal) {
		modal.addAttribute("top", "Priyanka Jain Website");
	}

}
