package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.model.Book;

import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {

    boolean existsByBookId(String bookId);

    Optional<Book> findByBookId(String bookId);
}

