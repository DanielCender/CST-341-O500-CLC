package com.gcu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.Service.BookService;
import com.gcu.models.BookModel;

@Controller
public class ProductController {
	@RequestMapping(path = "/browse", method=RequestMethod.GET)
	public String displayBooks() {
		return "browse";
	}
	
	@RequestMapping(path="/addBook", method=RequestMethod.GET)
		public ModelAndView addBook(@Valid @ModelAttribute("book")BookModel book, BindingResult resultBook) {
			
			ModelAndView mav = new ModelAndView();
			
			mav.addObject("books", BookService.create(book));
			
			return mav;
		}
}
