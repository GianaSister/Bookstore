package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b1 = new Book("Neverwhere", "Gaiman, Neil", "951-1-16857-6", 1997, 10.80f);
			Book b2 = new Book("Pride and Prejudice", "Austen, Jane", "978-1-85326-000-1", 1813, 24.50f);
			Book b3 = new Book("Bored of the Ring", "Beard, Henry N.", "0-575-07362-4", 1988, 6.99f);
		
			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		};
	}
}
