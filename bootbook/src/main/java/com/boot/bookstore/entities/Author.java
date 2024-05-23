package com.boot.bookstore.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	private String firstName;
	private String lastName;
	private String language;
	
	@OneToOne(mappedBy = "author")
	@JsonBackReference
	private Book book;
	
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	/*
	 * public Author(int aid, String firstName, String lastName, String language) {
	 * super(); this.aid = aid; this.firstName = firstName; this.lastName =
	 * lastName; this.language = language; } public Author() { super(); // TODO
	 * Auto-generated constructor stub }
	 */
	
	
}
