package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.model.Librarian;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends MongoRepository<Librarian, String> {
    Librarian findByUsername(String username);
}
