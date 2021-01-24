package com.ecommerce.bookstore.controller;

import com.ecommerce.bookstore.model.Book;
import com.ecommerce.bookstore.service.BookStoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookStoreController {

    @Autowired
    private BookStoreService bookStoreService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public Page<Book> getBooks(Pageable pageable){
      return bookStoreService.list(pageable);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/search")
    public Page<Book> getBooks( @RequestParam(name = "title") String title, Pageable pageable){
      return bookStoreService.searchByTitle(title,pageable);
    }
    
}
