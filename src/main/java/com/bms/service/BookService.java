package com.bms.service;

import java.util.List;

import com.bms.model.Book;

public interface BookService {
	
	List<Book> getAllBooks();
	
	Book saveBook(Book book);
	
	Book getBookbyId(int bookId);
	
	Book updateBook(Book book);
	
	void deleteBook(int bookId);
	

}
