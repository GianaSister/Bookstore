package com.example.Bookstore.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
	@Autowired
	private BookRepository brepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	// Show all books
	@RequestMapping(value={"/", "/booklist"})
	public String booklist(Model model) {
		model.addAttribute("books", brepository.findAll());
		return "booklist";
	}
	
	// Add a new student
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	
	// Save a new student
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		brepository.save(book);
		return "redirect:booklist";
	}
	
	// Delete a student
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookid, Model model) {
		brepository.deleteById(bookid);
		return "redirect:../booklist";
	}
	
	// Edit book
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookid, Model model) {
		model.addAttribute("book", brepository.findById(bookid));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}	
	
}
