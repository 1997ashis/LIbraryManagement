package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.model.Librarian;

public interface AdminService
{
    public boolean authenticateAdmin(String username, String password);
    public void addLibrarian(Librarian librarian);
    public List<Librarian> getAllLibrarians();
    public Optional<Librarian> findById(String id);
    public void updateLibrarian(Librarian librarian);

    public void deleteLibrarian(String librarianId);
}

