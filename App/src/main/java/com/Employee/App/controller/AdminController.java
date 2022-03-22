package com.Employee.App.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Employee.App.model.Admin;
import com.Employee.App.service.AdminService;

@Controller
public class AdminController {
  

    	
    	@Autowired
        private AdminService adminService;
     
        @InitBinder
        public void intiBinder(WebDataBinder dataBinder) {
        	StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        	dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
        	
        }
        @GetMapping("/administrator")      
        public ModelAndView login() {
         ModelAndView mav = new ModelAndView("Administrator");
            mav.addObject("admin", new Admin());
            return mav;
        }
     
        @PostMapping("/administratorCheck")
        public String login(@ModelAttribute("admin") Admin admin ) {
        
         Admin oauthUser = adminService.admin(admin.getUsername(), admin.getPassword());
        
     
         System.out.print(oauthUser);
         if(Objects.nonNull(oauthUser))
         {
      
         return "redirect:/admin";
        
        
         } else {
         return "redirect:/administrator";
        
        
         }
     
    }
        

    

}
