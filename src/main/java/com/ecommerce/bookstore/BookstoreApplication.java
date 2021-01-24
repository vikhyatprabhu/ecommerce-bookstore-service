package com.ecommerce.bookstore;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ecommerce.bookstore.model.Book;
import com.ecommerce.bookstore.utils.ImageURL;
import com.ecommerce.bookstore.service.BookStoreService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(BookStoreService booksService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Book>> typeReference = new TypeReference<List<Book>>(){};
			TypeReference<List<ImageURL>> urlTypeReference = new TypeReference<List<ImageURL>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/books.json");
			InputStream imageStream = TypeReference.class.getResourceAsStream("/json/images.json");
			List<ImageURL> imageURLs = new ArrayList<>();
			try {
				imageURLs.addAll(mapper.readValue(imageStream,urlTypeReference));
			} catch (IOException e) {
				System.out.println("Unable to read image: " + e.getMessage());
			}
			try {
				List<Book> books = mapper.readValue(inputStream,typeReference);
				if(!books.isEmpty()){
					Random random = new Random(128373);
					books.forEach(book -> book.setImageUrl(imageURLs.get(random.nextInt(imageURLs.size())).getImage()));
				    booksService.saveAll(books);
				}
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}

}
