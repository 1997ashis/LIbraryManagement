package com.nt.testservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import com.nt.model.Book;
import com.nt.repository.BookRepository;
import com.nt.service.BookService;
import com.nt.service.BookServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public class BookServiceTest1 {
    @Mock
    private BookRepository bookRepository;
    @Mock
    private Book book;
    private BookService bookService;
    @Before
    public void setUp() throws IOException
    {
        MockitoAnnotations.openMocks(this);
        bookService = new BookServiceImpl(bookRepository);
    }
    @Test
    public void testSaveAndFindBookById()
    {
        String bookId = UUID.randomUUID().toString();

        Book newBook = new Book();
        newBook.setBookId(bookId);
        when(bookRepository.save(newBook)).thenReturn(newBook);
        when(bookRepository.findByBookId(bookId)).thenReturn(Optional.of(newBook));
        Book savedBook = bookService.addBook(newBook);
        Book foundBook = bookService.findById(bookId);
        assertEquals(savedBook, foundBook);
        verify(bookRepository, times(1)).save(newBook);
        verify(bookRepository, times(1)).findByBookId(bookId);
    }
}
