/*package com.nt.repo;

import com.nt.model.Book;
import com.nt.repository.BookRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@PropertySource("classpath:applicationtest.properties")
public class BookRepositoryTest {
    @Mock
    private BookRepository bookRepository;

    @Autowired
    private Environment environment;

    @ParameterizedTest
    @ValueSource(strings = { "${bookId}" })
    public void testFindByBookId(String bookId) {
        Book testBook = new Book();
        testBook.setBookId(bookId);
        Mockito.when(bookRepository.findByBookId(bookId)).thenReturn(Optional.of(testBook));
        Optional<Book> foundBook =bookRepository.findByBookId(bookId);
        assertNotNull(foundBook);
        assertTrue(foundBook.isPresent());
        foundBook.ifPresent(book -> {
            assertEquals(bookId, book.getBookId());
        });
    }
}
*/