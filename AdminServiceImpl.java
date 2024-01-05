package com.nt.service;

import com.nt.model.Admin;
import com.nt.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.nt.model.Librarian;
import com.nt.repository.LibrarianRepository;

import java.util.List;
import java.util.Optional;

@Service

public class AdminServiceImpl implements AdminService {

    @Autowired
    private LibrarianRepository librarianRepository;
    @Autowired
    private AdminRepository adminRepository;





    public boolean authenticateAdmin(String username, String password) {
        Admin admin = adminRepository.findByUsername(username);
        return admin != null && admin.getPassword().equals(password);
    }
    @Override
    public void addLibrarian(Librarian librarian) {

        librarianRepository.save(librarian);
    }

    @Override
    public List<Librarian> getAllLibrarians() {
        return librarianRepository.findAll();
    }

    @Override
    @Cacheable(value = "librarianById", key = "#id",unless = "#result==null",cacheManager = "cacheManager")
    public Optional<Librarian> findById(String id) {
        System.out.println();
        return librarianRepository.findById(id);
    }




    public void updateLibrarian(Librarian librarian) {
        librarianRepository.save(librarian);
    }

    @Override
    @CacheEvict(value="deleteLibrarian",allEntries=true)
    @Scheduled(fixedRateString ="${caching.spring.cacheableTTLMinutes}" )
    public void deleteLibrarian(String librarianId)
    {
        librarianRepository.deleteById(librarianId);
    }
}
