package io.github.potatob6.Models;

import io.github.potatob6.Annos.PrimaryKey;
import io.github.potatob6.Annos.SQLSeq;
import io.github.potatob6.Annos.TableName;

@TableName(name = "Administrator")
public class AdministratorBean {

    @PrimaryKey
    @SQLSeq(order = 1)
    public String userID;

    @SQLSeq(order = 2)
    public String pwd;

    @SQLSeq(order = 3)
    public String nickname;

    @SQLSeq(order = 4)
    public int adminLevel;

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

    public int getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(int adminLevel) {
        this.adminLevel = adminLevel;
    }

    @Override
    public String toString() {
        return "AdministratorBean{" +
                "userID='" + userID + '\'' +
                ", pwd='" + pwd + '\'' +
                ", nickname='" + nickname + '\'' +
                ", adminLevel=" + adminLevel +
                '}';
    }

    public AdministratorBean () {

    }
}
