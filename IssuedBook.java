package com.nt.model;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Getter
@Document
public class IssuedBook implements Serializable{


    @Getter
    @Id
    private String studId;
    private String bookId;
    private String studName;
    private String studCont;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date issueDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;


    public IssuedBook() {

    }

    public IssuedBook(String studId, String bookId, String studName, String studCont, Date issueDate, Date returnDate) {
        this.studId = studId;
        this.bookId = bookId;
        this.studName = studName;
        this.studCont = studCont;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }

    public String getStudId() {
        return studId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getStudCont() {
        return studCont;
    }

    public void setStudCont(String studCont) {
        this.studCont = studCont;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "IssuedBook{" +
                "studId='" + studId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", studName='" + studName + '\'' +
                ", studCont='" + studCont + '\'' +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}


