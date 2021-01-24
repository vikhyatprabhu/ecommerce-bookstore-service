package com.ecommerce.bookstore.service;

import java.util.List;

import com.ecommerce.bookstore.model.Book;
import com.ecommerce.bookstore.repository.BooksRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookStoreService {

    private BooksRepository booksRepository;

    public BookStoreService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Book save(Book book){
        return booksRepository.save(book);
    }

    public Iterable<Book> saveAll(List<Book> books) {
        return booksRepository.saveAll(books);
    }

	public Page<Book> list(Pageable pageable) {
		return booksRepository.findAll(pageable);
    }
    
    public Page<Book> searchByTitle(String title, Pageable pageable ){
        return booksRepository.findAllByTitle(title, pageable);
    }

}
