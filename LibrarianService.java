package com.nt.service;

import com.nt.model.Librarian;

public interface LibrarianService {
    public boolean isValidLogin(String username, String password);
    Librarian findById(String id);

}
