package com.nt.service;
import com.nt.model.Librarian;
import com.nt.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class LibrarianServiceImpl implements LibrarianService{
    private final LibrarianRepository librarianRepository;

    @Autowired
    public LibrarianServiceImpl(LibrarianRepository librarianRepository) {
        this.librarianRepository = librarianRepository;
    }

    public boolean isValidLogin(String username, String password) {
        Librarian librarian = librarianRepository.findByUsername(username);
        return librarian != null && librarian.getPassword().equals(password);
    }
    @Override
    @Cacheable(value = "findById", key = "#id",unless = "#result==null",cacheManager = "cacheManager")
    public Librarian findById(String id) {
        return librarianRepository.findById(id).orElse(null);
    }

}
