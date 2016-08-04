package com.phi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.phiintegration.ws.controller.SMTP;

@Controller
public class Home {
	String message = "Welcome to your 1st Maven Spring project !";

	@RequestMapping("/asik")
	public ModelAndView showMessage() {
		String message = "Dari controller";
		System.out.println("from controller");
		return new ModelAndView("hello", "message", message);
	}
	
	@RequestMapping("/hello2")
	public ModelAndView showMessage2() {
		String message = "Dari controller yang kedua";
		System.out.println("from controller");
		return new ModelAndView("hello", "message", message);
	}
	
	@RequestMapping("/confirm/**")
	public @ResponseBody ModelAndView konfirmasi(@RequestParam String token){
		SMTP s = new SMTP();
		s.confirmToken(token);
		return new ModelAndView("confirmed");
		
	}
}