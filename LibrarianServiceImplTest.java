/*package com.nt.testservice;

import com.nt.repository.LibrarianRepository;
import com.nt.service.LibrarianServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;


import static org.mockito.Mockito.verify;

@SpringBootTest
class LibrarianServiceImplTest {


    @Mock
    private LibrarianRepository librarianRepository;
    private LibrarianServiceImpl librarianService;


    @Test
    void findById() {
        librarianRepository.findById("651ea9765450b467fd8056fb");
        System.out.println("Librarian  Find Successfully");
        verify(librarianRepository).findById("651ea9765450b467fd8056fb");
    }
    @Test
    void getAllLibrarians()
    {
        librarianRepository.findAll();
        verify(librarianRepository).findAll();
        System.out.println("Find all Librarians");
    }
}*/