package io.github.potatob6.Models;

import io.github.potatob6.Annos.PrimaryKey;
import io.github.potatob6.Annos.SQLSeq;

import java.math.BigDecimal;
import java.sql.Date;

public class BorrowBean {
    @PrimaryKey
    @SQLSeq(order = 1)
    public int borrowID;

    @PrimaryKey
    @SQLSeq(order = 2)
    public int bookID;

    @PrimaryKey
    @SQLSeq(order = 3)
    public String userID;

    @PrimaryKey
    @SQLSeq(order = 4)
    public Date borrowDate;

    @PrimaryKey
    @SQLSeq(order = 5)
    public int timeLimit;
    public Date returnedDate;

    public int getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(int borrowID) {
        this.borrowID = borrowID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public BigDecimal getOvertimeCharge() {
        return overtimeCharge;
    }

    public void setOvertimeCharge(BigDecimal overtimeCharge) {
        this.overtimeCharge = overtimeCharge;
    }

    public BigDecimal overtimeCharge;
}
