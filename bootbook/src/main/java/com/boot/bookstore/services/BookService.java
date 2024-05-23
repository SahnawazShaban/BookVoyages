package com.boot.bookstore.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.bookstore.dao.BookRepository;
import com.boot.bookstore.entities.Book;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
//	private static List<Book> list = new ArrayList<>();
//	
//	static {
//		list.add(new Book(12, "Mastery", "RG"));
//		list.add(new Book(13, "The fault in our star", "John Green"));
//		list.add(new Book(14, "The power of subconcise mind", "ABC"));
//		list.add(new Book(15, "The Atomic habit", "James clear"));
//	}
	
	// get all Books
	public List<Book> getAllBooks(){
//		return list;
		List<Book> list = (List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	//get single books by id
	
	public Book getBookById(int id) {
		Book book = null;
		try {
//			book = list.stream().filter(e->e.getId() == id).findFirst().get();
			book = this.bookRepository.findById(id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return book;
	}
	
	// adding the book
	public Book addBook(Book b) {
		Book res = this.bookRepository.save(b);
		return res;
	}
	
	// delete book
	public void deleteBook(int bid) {
//		list.stream().filter(e -> {
//			if(e.getId() != bid) {
//				return true;
//			}
//			else {
//				return false;
//			}
//		}).collect(Collectors.toList());
		
		// or
		
		// book = e
		
//		list = list.stream().filter(book->book.getId() != bid).collect(Collectors.toList());
		
		this.bookRepository.deleteById(bid);
	}
	
	public void updateBook(Book book, int bookId) {
//		list.stream().map(b -> {
//			if (b.getId() == bookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
		book.setId(bookId);
		
		this.bookRepository.save(book);
	}
}
