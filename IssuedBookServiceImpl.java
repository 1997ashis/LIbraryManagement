package com.nt.service;

import com.nt.model.IssuedBook;
import com.nt.repository.BookRepository;
import com.nt.repository.IssuedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssuedBookServiceImpl implements IssuedBookService
{
    @Autowired
    private  final IssuedBookRepository issuedBookRepository;
    public IssuedBookServiceImpl(IssuedBookRepository issuedBookRepository)
    {
        this.issuedBookRepository=issuedBookRepository;
    }
    @Override
    public List<IssuedBook> getAllIssuedBook() {
        return issuedBookRepository.findAll();
    }

    @Override
    public IssuedBook findById(String id) {
        return issuedBookRepository.findById(id).orElse(null);
    }

    @Override
    public void addIssuedBook(IssuedBook issuedBook) {
        issuedBookRepository.save(issuedBook);
    }


    @Override
    public void updateIssuedBook(IssuedBook issuedBook)
    {
        issuedBookRepository.save(issuedBook);
    }

    @Override
    public void deleteIssuedBook(String id) {
        issuedBookRepository.deleteById(id);

    }
}
