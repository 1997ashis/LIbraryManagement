package com.nt.service;

import com.nt.model.IssuedBook;

import java.util.List;

public interface IssuedBookService {
    public List<IssuedBook> getAllIssuedBook();

    public IssuedBook findById(String id);
    public void addIssuedBook(IssuedBook issuedBook);
    public void updateIssuedBook(IssuedBook issuedBook);
    public void deleteIssuedBook(String id);
}
