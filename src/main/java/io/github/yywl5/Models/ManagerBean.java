package io.github.yywl5.Models;
import io.github.potatob6.Annos.PrimaryKey;
import io.github.potatob6.Annos.SQLSeq;
import io.github.potatob6.Annos.TableName;
/*********************
 *
 *
 * 管理员模型
 *
 * *********************************/
@TableName(name = "Administrator")
public class ManagerBean {
    public ManagerBean(){
        this.userID=null;
        this.pwd=null;
        this.nickname=null;
        this.adminLevel=null;
    }

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

    public String getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
    }

    @PrimaryKey
    @SQLSeq(order = 1)
    public String userID;
    @SQLSeq(order = 2)
    public String pwd;
    @SQLSeq(order = 3)
    public String nickname;
    @SQLSeq(order = 4)
    public String adminLevel;
}
