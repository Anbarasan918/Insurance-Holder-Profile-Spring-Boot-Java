package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;
import com.example.service.UserService;


@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	private List<User> UserInObj;
	private List<User> userInObj;
	
	@GetMapping(value = {"/","/login"})
	public ModelAndView loginPage() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@GetMapping(value = {"/register"})
	public ModelAndView registerPage() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	@PostMapping(value = {"/register"})
	public ModelAndView saveUser(User data) {
		ModelAndView modelAndView=new ModelAndView();
		userService.save(data);
		modelAndView.setViewName("registerSucess");
		return modelAndView;
	}
	

	
	@PostMapping(value = {"/login"})
	public ModelAndView  loginUser(User data) {
		ModelAndView modelAndView=new ModelAndView();

		boolean userFound=userService.login(data);
		userService.findAllData();
		if(userFound==true) {
			modelAndView.setViewName("loginsucess");
			userInObj=userService.findAllData();
			modelAndView.addObject("users",userInObj);
			
			System.out.println(userService.findAllData());
			
		}else {
			modelAndView.setViewName("loginError");
		}
		return modelAndView;
	}
}
