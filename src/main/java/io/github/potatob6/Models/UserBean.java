package io.github.potatob6.Models;

import io.github.potatob6.Annos.SQLSeq;

import java.math.BigDecimal;

/**
 * 用户模型
 */
public class UserBean {
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public void setVIP(boolean VIP) {
        isVIP = VIP;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public UserBean() {
        this.userID = null;
        this.pwd = null;
        this.nickname = null;
        this.isVIP = false;
        this.cardID = null;
        this.balance = new BigDecimal("0.0");
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @SQLSeq(order = 1)
    public String userID;
    @SQLSeq(order = 2)
    public String pwd;
    @SQLSeq(order = 3)
    public String nickname;
    @SQLSeq(order = 4)
    public boolean isVIP;
    @SQLSeq(order = 5)
    public String cardID;
    @SQLSeq(order = 6)
    public BigDecimal balance;
}
