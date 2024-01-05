package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.model.Admin;

public interface AdminRepository extends MongoRepository<Admin,String>
{

    Admin findByUsername(String username);
}
