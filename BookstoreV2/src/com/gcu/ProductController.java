package com.gcu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/browse")
public class ProductController {
	@RequestMapping(path = "/", method=RequestMethod.GET)
	public String displayBooks() {
		return "browse";
	}
}
