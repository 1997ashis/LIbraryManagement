package com.nt.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Document(collection = "book")
public class Book  implements Serializable {
    @Id
    private String id;
    @Getter
    private String bookId;
    private String title;
    private String author;
    private int pages;
    @Getter
    private int bookNumber;
    //private boolean available;

    public Book() {

    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }


    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", bookNumber=" + bookNumber +
                '}';
    }
}

