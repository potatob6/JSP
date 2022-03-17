package io.github.potatob6.Models;

import io.github.potatob6.Annos.AutoIncrement;
import io.github.potatob6.Annos.PrimaryKey;
import io.github.potatob6.Annos.SQLSeq;
import io.github.potatob6.Annos.TableName;

import java.math.BigDecimal;
import java.sql.Date;

@TableName(name = "Book")
public class BookBean {

    @PrimaryKey
    @AutoIncrement
    @SQLSeq(order = 1)
    public int bookID;

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

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
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
