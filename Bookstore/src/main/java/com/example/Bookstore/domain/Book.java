package com.example.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String Title, Author, Isbn;
	private int Year;
	private float Price;
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;
	
	public Book() {}
		
	public Book(String title, String author, String isbn, int year, float price, Category category) {
		super();
		this.Title = title;
		this.Author = author;
		this.Isbn = isbn;
		this.Year = year;
		this.Price = price;
		this.category = category;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public String toString() {
		if (this.category != null)
			return "Book [Title=" + Title + ", Author=" + Author + ", Isbn=" + Isbn + ", Year=" + Year + ", Price=" + Price
				+ "]";
		else
			return "Book [Title=" + Title + ", Author=" + Author + ", Isbn=" + Isbn + ", Year=" + Year + ", Price=" + Price
					+ ", Category=" + category + "]";
	}	
}
