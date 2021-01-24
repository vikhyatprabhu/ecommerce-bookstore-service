package com.ecommerce.bookstore.repository;

import java.util.List;

import com.ecommerce.bookstore.model.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends PagingAndSortingRepository<Book,Integer> {

    Page<Book> findAllByTitle(String title, Pageable pageable);

}
