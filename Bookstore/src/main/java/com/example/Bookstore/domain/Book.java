package com.example.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String Title, Author, Isbn;
	private int Year;
	private float Price;
	
	public Book() {}
		
	public Book(String title, String author, String isbn, int year, float price) {
		super();
		this.Title = title;
		this.Author = author;
		this.Isbn = isbn;
		this.Year = year;
		this.Price = price;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getIsbn() {
		return Isbn;
	}
	public void setIsbn(String isbn) {
		Isbn = isbn;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}

	@Override
	public String toString() {
		return "Book [Title=" + Title + ", Author=" + Author + ", Isbn=" + Isbn + ", Year=" + Year + ", Price=" + Price
				+ "]";
	}

	
}
