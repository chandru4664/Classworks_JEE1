package com.htc.spring4mvc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.htc.spring4mvc.model.User;
import com.htc.spring4mvc.service.UserService;
 
@Controller
public class UserController {
  
	 	private static final String[] genders = {"MALE", "FEMALE"};
	 	
	 	@Autowired
	 	UserService userService;
	 	
	 	//@Autowired
	 	//UserFormValidator userValidator;
	 	
	    public UserService getUserService() {
			return userService;
	    }
		public void setUserService(UserService userService) {
			this.userService = userService;
		}
		
		@InitBinder("user")
	    public void customizeBinding (WebDataBinder binder) {
	        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
	        dateFormatter.setLenient(false);
	        binder.registerCustomEditor(Date.class, "birthdate", new CustomDateEditor(dateFormatter, true));
	        
	      //  binder.setValidator(userValidator);
		}
		
		@RequestMapping
		public String resourceNotFound() {
			return "error";
		}
		
	    @RequestMapping(value = "/userForm", method=RequestMethod.GET)    
	    public ModelAndView userForm() {        
	    	//System.out.println("userForm");
	    	ModelAndView modelAndView = new ModelAndView("register", "user", new User());        
	    	modelAndView.addObject("genders", genders);        
//	    	modelAndView.addObject("countries", countries);
	        return modelAndView;    
        }
	    		

		@RequestMapping(value = "/registerUser", method=RequestMethod.POST)    
	    public String registerUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult , Model model, RedirectAttributes redirectAttrs) {
					
			if(bindingResult.hasErrors()) {
		    	model.addAttribute("genders", genders);        
		    	//model.addAttribute("countries", countries);
				model.addAttribute("user", user);
		    	return "register";	
			}
			else{
				boolean result = userService.registerUser(user);
				if(result) {
					redirectAttrs.addFlashAttribute("msg", "User details added successfully");
					redirectAttrs.addFlashAttribute("firstName", user.getFirstName());
					redirectAttrs.addFlashAttribute("lastName", user.getLastName());
					return "redirect:/registerSuccess";
				}        
				else{
			    	model.addAttribute("genders", genders);        
			    	//model.addAttribute("countries", countries);
					model.addAttribute("user", user);
					return "register";
				}
			}
    	} 
		@RequestMapping(value="/registerSuccess", method=RequestMethod.GET)
		public ModelAndView showAllUsers(){
			List<User> userList = userService.getAllUsers();
			ModelAndView mv = new ModelAndView("userList", "users", userList);
			return mv;
		}

		@RequestMapping(value="/deleteUser")
		public String deleteUser(@RequestParam("email") String email, RedirectAttributes redirectAttrs) {
			boolean result = userService.deleteUser(email);
			if(result) {
				redirectAttrs.addFlashAttribute("msg", "User details deleted successfully");
				return "redirect:/registerSuccess";
			}
			else {
				redirectAttrs.addFlashAttribute("msg", "Error during deletion.");
				return "editFailure";
			}
		}
		
		@RequestMapping(value="/editUser/{phoneno}")
		public String editUser(@PathVariable("phoneno") String phoneno, Model model) {
			User user = userService.findUser(phoneno);
			model.addAttribute("genders", genders);
			model.addAttribute("user", user);
			return "edituserform";
		}
		
		@RequestMapping(value="/testException")
		public String testException() {
			if(true)
				throw new RuntimeException();
			return "success";
			
		}
	
		@ModelAttribute("countryList")  //
		public List<String> getCountries(){
			List<String> countryList = new ArrayList<String>();
			Locale[] locales = Locale.getAvailableLocales();
			for(Locale loc : locales) {
				countryList.add(loc.getDisplayCountry());	
			}
			return countryList;
		}
		
		@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	    public String accessDeniedPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "accessDenied";
	    }
	 
	    @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String loginPage() {
	        return "login";
	    }
	 
	    @RequestMapping(value="/logout", method = RequestMethod.GET)
	    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null){    
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	        }
	        return "redirect:/login?logout";
	    }
	 
	    private String getPrincipal(){
	        String userName = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 
	        if (principal instanceof UserDetails) {
	            userName = ((UserDetails)principal).getUsername();
	        } else {
	            userName = principal.toString();
	        }
	        return userName;
	    }
		
		/*@ExceptionHandler
		public ModelAndView handleException(RuntimeException ex) {
			ModelAndView mv = new ModelAndView("error", "errorObj", ex);
			return mv;
		}*/

}

