package com.gcu.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.DataBusinessInterface;
import com.gcu.models.BookModel;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	DataBusinessInterface<BookModel> service;
	
	@Autowired
	public void setDataBusinessInterface(DataBusinessInterface<BookModel> i) {
		service = i;
	}
	
	@RequestMapping(path = "/add", method=RequestMethod.GET)
	public ModelAndView displayBooks() {
		return new ModelAndView("addBook", "book", new BookModel());
	}
	
	@RequestMapping(path="/addBook", method=RequestMethod.POST)
		public ModelAndView addBook(@Valid @ModelAttribute("book")BookModel book, BindingResult result) {
			ModelAndView mav = new ModelAndView();
			boolean successful = service.create(book);
			
			if(successful) {
				mav.setViewName("book");
				mav.addObject("book", book);				
			} else {
				result.rejectValue("title", "error.book", "Book was not created successfully. Please check input.");
				mav.setViewName("addBook");
				mav.addObject("book", book);
			}
			return mav;
		}
}
