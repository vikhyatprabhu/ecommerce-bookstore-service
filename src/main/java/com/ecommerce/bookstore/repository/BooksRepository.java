package com.ecommerce.bookstore.repository;

import java.util.List;

import com.ecommerce.bookstore.model.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends PagingAndSortingRepository<Book,Integer> {

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(concat(?1, '%'))")
    Page<Book> findAllByTitle(String title, Pageable pageable);

}
