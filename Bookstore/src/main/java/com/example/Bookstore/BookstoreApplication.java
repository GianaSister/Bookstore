package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("Let's save the base of the bookstore");
			crepository.save(new Category("Dekkari"));
			crepository.save(new Category("Historia"));
			crepository.save(new Category("Fantasia"));
			
			brepository.save(new Book("Neverwhere", "Gaiman, Neil", "951-1-16857-6", 1997, 10.80f, crepository.findByName("Fantasia").get(0)));
			brepository.save(new Book("Pride and Prejudice", "Austen, Jane", "978-1-85326-000-1", 1813, 24.50f, crepository.findByName("Historia").get(0)));
			brepository.save(new Book("Bored of the Ring", "Beard, Henry N.", "0-575-07362-4", 1988, 6.99f, crepository.findByName("Dekkari").get(0)));
		
			log.info("list all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
