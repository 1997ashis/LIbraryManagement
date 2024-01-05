package com.nt.service;

import com.nt.model.Book;

import java.util.List;

public interface BookService
{
    public List<Book> getAllBooks();
    public Book findById(String id);
    public Book addBook(Book book);

    public void deleteBook(String id);
    public boolean bookExists(String bookId);

}
