package com.Employee.App.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Employee.App.model.Employee;
import com.Employee.App.service.EmployeeService;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @InitBinder
    public void intiBinder(WebDataBinder dataBinder) {
    	StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    	dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    	
    }
    // display list of employees
    @GetMapping("/admin")
    public String viewAdminPage(Model model) {
        //model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "admin";
    }
    @GetMapping("/create.html")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") @Valid Employee employee,BindingResult bindingResult) {
        // save employee to database
//        employeeService.saveEmployee(employee);
//        return "succes";
    	if(bindingResult.hasErrors()) {
    		return "create";
    	}
    	employeeService.saveEmployee(employee);
    	return "succes";
    }

    @GetMapping("/display.html")
    public String Display(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "display";
    }
    
    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") Long id, Model model) {
     
     // get employee from the service
     Employee employee = employeeService.getEmployeeById(id);
     
     // set employee as a model attribute to pre-populate the form
     model.addAttribute("employee", employee);
     return "update";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") Long id) {
     
     // call delete employee method 
     this.employeeService.deleteEmployeeById(id);
     return "redirect:/display.html";
    }
    @GetMapping("/signup.html")
    public String signUpPage(Model model) {
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "signup";
    }
    @PostMapping("/saveSignUp")
    public String saveSignUp(@ModelAttribute("employee") @Valid Employee employee,BindingResult bindingResult) {

    	if(bindingResult.hasErrors()) {
    		return "signup";
    	}
    	employeeService.saveSignUp(employee);
    	return "SuccessfulSignup";
    }
    @GetMapping("/employee")
    public String viewEmployeePage(Model model) {
        //model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "employee";
    }

    @GetMapping("/login")
    public ModelAndView login() {
     ModelAndView mav = new ModelAndView("login");
        mav.addObject("employee", new Employee());
        return mav;
    }
 
    @PostMapping("/loginAuthorising")
    public String login(@ModelAttribute("employee") Employee employee ) {
    
     Employee oauthUser = employeeService.employee(employee.getEmail(), employee.getPassword());
    
 
     System.out.print(oauthUser);
     if(Objects.nonNull(oauthUser))
     {
  
     return "redirect:/employee";
    
    
     } else {
     return "redirect:/login";
    
    
     }
 
}
    
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
    
  
        return "redirect:/login";
    }

    
}
