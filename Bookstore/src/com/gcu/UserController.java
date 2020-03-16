package com.gcu;

import java.sql.SQLException;

import javax.validation.Valid;

// TODO - Figure out persistent user session storage
//import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.models.UserModel;
import com.gcu.models.RegisterUserModel;
import com.gcu.models.LoginCModel;
import com.gcu.Service.DataAccessObject;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@RequestMapping(path="/registerUser", method=RequestMethod.GET)
	public ModelAndView registerUser() {
		// TODO - Add checks to local session for already logged-in user.
		// TODO - If current user session is found, redirect user to authed home view or profile
		return new ModelAndView("register", "userRegistration", new RegisterUserModel());
	}

	@RequestMapping(path = "/registerUser", method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("userRegistration") @Valid RegisterUserModel registration, BindingResult resultUser) {
		ModelAndView mav = new ModelAndView();
		DataAccessObject dataService = new DataAccessObject();
		
		//Checks to see if there are errors.
		if(resultUser.hasErrors()) {
			mav.setViewName("register");
			mav.addObject("userRegistration", registration);
			return mav;
		}
		
		try {
			if(!dataService.isAvailable(registration)) {
				resultUser.rejectValue("email","error.user", "This email is being used by another account, please choose another email.");
				registration.setEmail("");
				registration.setPasswordConfirmation("");
				mav.addObject("userRegistration", registration);
				mav.setViewName("register");
				return mav;
			}
			else {
				if(registration.getPassword().equals(registration.getPasswordConfirmation())) {
					dataService.Register(registration);
					mav.setViewName("redirect:/loginUser");
					return mav;
				}
				else {
					resultUser.rejectValue("passwordConfirmation", "error.user", "The passwords do not match.");
					// Display registration page again
					registration.setPasswordConfirmation("");
					mav.setViewName("registration");
					mav.addObject("userRegistration", registration);
					return mav;
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		// Return to /register view by default
		mav.setViewName("register");
		mav.addObject("userRegistration", registration);
		return mav;
	}
	
	@RequestMapping(path="/loginUser", method=RequestMethod.GET)
	public ModelAndView loginUser() {
		// TODO - Add checks to local session for already logged-in user.
		// TODO - If current user session is found, redirect user to authed home view or profile
		return new ModelAndView("login", "loginCModel", new LoginCModel());
	}
	
	@RequestMapping(path = "/loginUser", method=RequestMethod.POST) 
	public ModelAndView loginUser(@ModelAttribute("loginCModel") @Valid LoginCModel login, BindingResult resultLogin) {
		System.out.println("Got to here");
		ModelAndView mav = new ModelAndView();
		DataAccessObject dataService = new DataAccessObject();
		Boolean loggedIn = false;
		
		mav.addObject("user", new UserModel());
		
		//Checks to see if there are errors.
		if(resultLogin.hasErrors()) {
			mav.setViewName("login");
			mav.addObject("login", login);
			return mav;
		}
		
		
		try {
			loggedIn = dataService.Login(login.getEmail(), login.getPassword());
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Logged in status: " + loggedIn);
		
		if(loggedIn) {
			mav.setViewName("redirect:/browse");
			return mav;			
		}
		resultLogin.rejectValue("email", "error.user", "Invalid email and password combination, please try again.");
//		resultLogin.rejectValue("passwordConfirmation", "error.user", "The passwords do not match.");
		mav.setViewName("login");
		mav.addObject("login", login);
		return mav;
	}

}
