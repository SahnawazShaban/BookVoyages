package com.boot.bookstore;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.bookstore.entities.Book;
import com.boot.bookstore.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

	// get all books handler
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBook() {
		List<Book> list = this.bookService.getAllBooks();
		if (list.size() <= 0) {
			// show data - ResponseEntity have status method, to create object use build method
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	// get single book handler
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getSingleBook(@PathVariable("id") int id) {
		Book book = bookService.getBookById(id);
		
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	//new book handler
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b = null;
		try {
			b = this.bookService.addBook(book);
			System.out.println(b);
			return ResponseEntity.of(Optional.of(b));
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// delete book handler
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		
		this.bookService.deleteBook(bookId);
	}
	
	//update book handler
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		
		this.bookService.updateBook(book, bookId);
		return book;
	}
}

// if you write @RestController then you don't need to write @ResponseBody

//@RequestMapping(value="/books", method = RequestMethod.GET)
// @RequestMapping(value="/books", method = RequestMethod.GET) == @GetMapping("/books")

// If you return Book object then return should be Book - public Book getBook()
