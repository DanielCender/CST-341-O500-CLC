package com.gcu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class BaseController {
	@RequestMapping(path = "/", method=RequestMethod.GET)
	public String registerUser() {
		return "index";
	}
}