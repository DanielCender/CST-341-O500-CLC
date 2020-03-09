package com.gcu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ProductController {
	@RequestMapping(path = "/browse", method=RequestMethod.GET)
	public String displayBooks() {
		return "browse";
	}
}
