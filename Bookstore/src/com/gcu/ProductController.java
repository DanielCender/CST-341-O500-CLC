package com.gcu;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.Service.interfaces.BookServiceInterface;
import com.gcu.models.BookModel;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	BookServiceInterface service;
	
	@Autowired
	public void setBookServiceInterface(BookServiceInterface i) {
		service = i;
	}
	
	@RequestMapping(path = "/add", method=RequestMethod.GET)
	public ModelAndView displayBooks() {
		return new ModelAndView("addBook", "book", new BookModel());
	}
	
	@RequestMapping(path="/addBook", method=RequestMethod.POST)
		public ModelAndView addBook(@Valid @ModelAttribute("book")BookModel book, BindingResult result) {
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("book");
			try {
			mav.addObject("book", service.create(book));
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				mav.setViewName("addBook");
			}
			
			mav.addObject("book", book);
			return mav;
		}
}
