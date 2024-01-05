package com.nt.repository;

import com.nt.model.IssuedBook;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IssuedBookRepository extends MongoRepository<IssuedBook,String>
{

}
