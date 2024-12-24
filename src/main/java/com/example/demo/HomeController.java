package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Details;
import com.example.demo.service.DetailsService;

@Controller
public class HomeController {
	
	@Autowired
	private DetailsService detailsService;
	
	@GetMapping("/")
	public String show() {
		return "home";
	}
	

	@GetMapping("/index")
	public ModelAndView home(@RequestParam("Firstname") String FName,@RequestParam("Lastname") String Lname)
	{
		// String FName=request.getParameter("Firstname");
		ModelAndView mv=new ModelAndView();
		Details details = new Details();
		details.setFirstName(FName);
		details.setLastName(Lname);
		Details d = detailsService.createDetails(details);
		mv.addObject("Fname",FName);
		mv.addObject("Lname",Lname);
		mv.addObject("Id",d.getId());
		mv.setViewName("index");
		return mv;
	}
	
	
}
