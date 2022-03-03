package com.bms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bms.model.Book;
import com.bms.service.BookService;

@Controller
public class BookController {
	
	private BookService bookService;
	
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@GetMapping("/books")
	public String listBooks(Model model)
	{
		model.addAttribute("books", bookService.getAllBooks());
		return "books";
	}
	
	@GetMapping("/books/new")
	public String addBook(Model model)
	{
		Book book = new Book();
		model.addAttribute("book", book);
		return "addbook";
	}
	
	@PostMapping("/books")
	public String saveBook(@ModelAttribute("book") Book book)
	{
		bookService.saveBook(book);
		return "redirect:/books";
	}
	
	@GetMapping("/books/edit/{id}")
	public String editBook(@PathVariable int id,Model model)
	{
		model.addAttribute("book",bookService.getBookbyId(id));
		return "editform";
	}
	
	@PostMapping("/books/{id}")
	public String updateBook(@PathVariable int id, @ModelAttribute("book") Book book,
			Model model)
	{
		Book newBook = new Book();
		newBook.setBookId(id);
		newBook.setIsbn(book.getIsbn());
		newBook.setBookName(book.getBookName());
		newBook.setBookAuthor(book.getBookAuthor());
		newBook.setBookPrice(book.getBookPrice());
		
		bookService.updateBook(newBook);
		return "redirect:/books";
	}
	
	@GetMapping("/books/{id}")
	public String deleteBook(@PathVariable int id)
	{
		bookService.deleteBook(id);
		return "redirect:/books";
	}
	
	
}
