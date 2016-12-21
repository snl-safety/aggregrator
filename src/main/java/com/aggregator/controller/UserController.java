package com.aggregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;

import com.aggregator.entity.User;
import com.aggregator.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public User construct(){
		return new User();
	}
	
	@RequestMapping("/users")
	public String users(Model model){
		model.addAttribute("users",userService.findAll());
		return "users";
	}
	
	@RequestMapping("users/{id}")
	public String userDetials(Model model, @PathVariable Integer id){
		model.addAttribute("user", userService.findUserWithBlogs(id));
		return "userDetails";
	}
	
	@RequestMapping("/register")
	public String showRegister(){
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@ModelAttribute("user")User user){
		userService.save(user);
		return "register";
	}
}
