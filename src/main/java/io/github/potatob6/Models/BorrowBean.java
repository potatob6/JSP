package io.github.potatob6.Models;

import io.github.potatob6.Annos.AutoIncrement;
import io.github.potatob6.Annos.PrimaryKey;
import io.github.potatob6.Annos.SQLSeq;
import io.github.potatob6.Annos.TableName;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.Formatter;

@TableName(name = "Borrow")
public class BorrowBean {

    @PrimaryKey
    @AutoIncrement
    @SQLSeq(order = 1)
    public int borrowID;

    @SQLSeq(order = 2)
    public int bookID;

    @SQLSeq(order = 3)
    public String userID;

    @SQLSeq(order = 4)
    public Date borrowDate;

    @SQLSeq(order = 5)
    public int timeLimit;

    @SQLSeq(order = 6)
    public Date returnedDate;

    @SQLSeq(order = 7)
    public BigDecimal overtimeCharge;

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

    public BorrowBean() {
        this.bookID = 0;
        this.borrowID = 0;
        Calendar nowDay = Calendar.getInstance();
        Formatter formatter = new Formatter();
        formatter.format("%04d-%02d-%02d", nowDay.get(Calendar.YEAR), nowDay.get(Calendar.MONTH)+1, nowDay.get(Calendar.DAY_OF_MONTH));
        this.setBorrowDate(Date.valueOf(formatter.out().toString()));
        this.userID = null;
        this.timeLimit = 0;
        this.returnedDate = null;
        this.overtimeCharge = new BigDecimal("0.0");
    }
}
