package com.example.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
		
	@RequestMapping("/booklist")
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookid, Model model) {
		model.addAttribute("book", repository.findById(bookid));
		return "editbook";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String updateBook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookid, Model model) {
		repository.deleteById(bookid);
		return "redirect:../booklist";
	}
	
}
