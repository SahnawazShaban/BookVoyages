package com.boot.bookstore.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.bookstore.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	public Book findById(int id);

}
