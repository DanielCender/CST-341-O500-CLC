package com.app;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.model.UserModel;
import com.app.model.LoginCModel;

@Controller
public class UserController {
	
	@RequestMapping(path = "/registerUser", method=RequestMethod.GET)
	public ModelAndView registerUser(@ModelAttribute("user")UserModel user, BindingResult resultUser, @ModelAttribute("login")LoginCredModel login, BindingResult resultLogin, RedirectAttributes redirect) {
		
		ModelAndView mav = new ModelAndView();
		
		//Checks to see if there are errors.
		if(resultUser.hasErrors()) {
			displayRegistrationPage(mav);
			mav.setViewName("register");
			mav.addObject("user", user);
			mav.addObject("login", new LoginCModel());
			return mav;
		}
		
		if(dataService.doesUserExist(user)) {
			resultUser.rejectValue("userExists","error.user", "This emial is being used by another account, please choose another email.");
			user.setEmail("");
			displayRegistrationPage(mav);
			mav.addObject("user", user);
			mav.addObject("login", new LoginCModel());
			mav.setViewName("register");
			return mav;
		}
		else {
			if(user.getPassword().equals(user.getPasswordConfirmation())) {
				dataService.addUser(user);
				login.setEmail(user.getEmail());
				mav.setViewName("redirect:/");
				return mav;
			}
			else {
				resultUser.rejectValue("passwordConfirmation", "error.user", "The passwords do not match.");
				displayRegistrationPage(mav);
				mav.addObject("user", user);
				mav.addObject("login", login);
				mav.setViewName("registration");
			}
		}
		
	}
	
	@RequestMapping(path = "/loginUser", method=RequestMethod.GET) 
	public ModelAndView loginUser(@ModelAttribute("login")LoginCModel login, BindingResult resultLogin, @ModelAttribute("user")UserModel user, BindingResult resultUser) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", new UserModel());
		
		//Checks to see if there are errors.
		if(resultUser.hasErrors()) {
			displayLoginPage(mav);
			mav.setViewName("login");
			mav.addObject("login", login);
			return mav;
		}
		
		UserModel loggedIn = dataService.loginUserWithModel(new UserModel("", "", login.getEmail(), login.getPassword()));
		
		if(loggedIn.getID() != -1) {
			
			HttpSession.setAttribute("user", loggedIn);
			mav.setViewName("redirect:/ main");
			return mav;			
		}
	}

}
