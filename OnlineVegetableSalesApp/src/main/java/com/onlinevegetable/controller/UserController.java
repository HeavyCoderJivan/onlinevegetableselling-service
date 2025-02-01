package com.onlinevegetable.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinevegetable.model.User;
import com.onlinevegetable.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
@Controller
public class UserController
{
	@Autowired
	private UserService userSer;
	@GetMapping("/")
	public String signUp(@Valid Model model) 
	{
		User user=new User(); 
		model.addAttribute("userr", user);
		return "signup";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@Valid  @ModelAttribute("use") User user ) 
	{
		userSer.addUser(user);
		return "login";		
	}
	
    @GetMapping("/loginp")
	public String logigPage() 
	{
		   return "login";
	}
   @GetMapping("/verify")
   public String verifyUser(@Valid @RequestParam("email") String email, @RequestParam("password") String pass,Model model,HttpSession session  ) 
   {
	   try {
		   if(!email.contains("admin@gmail.com") && !pass.contains("admin@123") )
		   {
			   User user=userSer.getUserByEmail(email);
			   if(user.getEmailId().equals(email) && user.getPassword().equals(pass)) 
			   {
				   session.setAttribute("user", user.getUserId());
				   session.setAttribute("userName", user.getUserName());
				   model.addAttribute("user", session.getAttribute("user"));
	               return "Userhtml";  
			   }      
		    }
		   else 
		   {
			   return "Adminpage";
		   }
	      }
	   catch(Exception e) 
	      {
		      return "redirect:/";    
	      }
	   return "redirect:/";
   }
   
}
