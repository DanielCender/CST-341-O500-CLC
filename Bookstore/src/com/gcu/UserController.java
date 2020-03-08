package com.gcu;

import java.sql.SQLException;

//import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gcu.models.UserModel;
import com.gcu.models.LoginCModel;
import com.gcu.Service.DataAccessObject;

@Controller
public class UserController {
	
	@RequestMapping(path="/registerUser", method=RequestMethod.GET)
	public ModelAndView registerUser() {
		// TODO - Add checks to local session for already logged-in user.
		// TODO - If current user session is found, redirect user to authed home view or profile
		return new ModelAndView("register", "userModel", new UserModel());
	}

	@RequestMapping(path = "/registerUser", method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user")UserModel user, BindingResult resultUser, @ModelAttribute("login")LoginCModel login, BindingResult resultLogin, RedirectAttributes redirect) {
		
		ModelAndView mav = new ModelAndView();
		DataAccessObject dataService = new DataAccessObject();
		
		//Checks to see if there are errors.
		if(resultUser.hasErrors()) {
			mav.setViewName("register");
			mav.addObject("user", user);
			mav.addObject("login", new LoginCModel());
			return mav;
		}
		
		try {
			if(!dataService.isAvailable(user)) {
				resultUser.rejectValue("userExists","error.user", "This emial is being used by another account, please choose another email.");
				user.setEmail("");
				mav.addObject("user", user);
				mav.addObject("login", new LoginCModel());
				mav.setViewName("register");
				return mav;
			}
			else {
				if(user.getPassword().equals(login.getPasswordConfirmation())) {
					dataService.Register(user);
					login.setEmail(user.getEmail());
					mav.setViewName("redirect:/");
					return mav;
				}
				else {
					resultUser.rejectValue("passwordConfirmation", "error.user", "The passwords do not match.");
					// Display registration page again
					mav.addObject("user", user);
					mav.addObject("login", login);
					mav.setViewName("registration");
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		// Return to /register view by default
		mav.setViewName("register");
		mav.addObject("user", user);
		mav.addObject("login", new LoginCModel());
		return mav;
	}
	
	@RequestMapping(path="/loginUser", method=RequestMethod.GET)
	public ModelAndView loginUser() {
		// TODO - Add checks to local session for already logged-in user.
		// TODO - If current user session is found, redirect user to authed home view or profile
		return new ModelAndView("login", "loginCModel", new LoginCModel());
	}
	
	@RequestMapping(path = "/loginUser", method=RequestMethod.POST) 
	public ModelAndView loginUser(@ModelAttribute("login")LoginCModel login, BindingResult resultLogin, @ModelAttribute("user")UserModel user, BindingResult resultUser) {
		System.out.println("Got to here");
		ModelAndView mav = new ModelAndView();
		DataAccessObject dataService = new DataAccessObject();
		Boolean loggedIn = false;
		
//		HttpSession session = res.getSession();
		mav.addObject("user", new UserModel());
		
		//Checks to see if there are errors.
		if(resultUser.hasErrors()) {
			mav.setViewName("login");
			mav.addObject("login", login);
			return mav;
		}
		
		
		try {
			loggedIn = dataService.Login(login.getEmail(), login.getPassword());
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(loggedIn) {
//			session.setAttribute("user", loggedIn);
			mav.setViewName("redirect:/ main");
			return mav;			
		}
		
		mav.setViewName("login");
		mav.addObject("login", login);
		return mav;
	}

}
