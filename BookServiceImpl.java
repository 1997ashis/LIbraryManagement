package com.nt.service;

import com.nt.model.Book;
import com.nt.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService
{
    private final BookRepository bookRepository;


    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
       return  bookRepository.findAll();
    }

    @Override
    public Book findById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book addBook(Book book)
    {
        bookRepository.save(book);
        return book;
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);

    }
    @Override
    public boolean bookExists(String bookId) {

        return bookRepository.existsByBookId(bookId);
    }

}
