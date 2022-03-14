package io.github.potatob6.Models;

import io.github.potatob6.Annos.SQLSeq;

import java.math.BigDecimal;
import java.sql.Date;

public class BookBean {
    @SQLSeq(order = 1)
    public String bookID;

    @SQLSeq(order = 2)
    public String classID;

    @SQLSeq(order = 3)
    public String bookName;

    @SQLSeq(order = 4)
    public String publisher;

    @SQLSeq(order = 5)
    public BigDecimal originPrice;

    @SQLSeq(order = 6)
    public Date storageDate;

    @SQLSeq(order = 7)
    public int storageCount;

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BigDecimal getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(BigDecimal originPrice) {
        this.originPrice = originPrice;
    }

    public Date getStorageDate() {
        return storageDate;
    }

    public void setStorageDate(Date storageDate) {
        this.storageDate = storageDate;
    }

    public int getStorageCount() {
        return storageCount;
    }

    public void setStorageCount(int storageCount) {
        this.storageCount = storageCount;
    }
}
