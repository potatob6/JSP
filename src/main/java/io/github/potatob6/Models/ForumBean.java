package io.github.potatob6.Models;

import io.github.potatob6.Annos.AutoIncrement;
import io.github.potatob6.Annos.PrimaryKey;
import io.github.potatob6.Annos.SQLSeq;
import io.github.potatob6.Annos.TableName;

import java.sql.Date;

@TableName(name = "Forum")
public class ForumBean {
    @AutoIncrement
    @PrimaryKey
    @SQLSeq(order = 1)
    public int forumID;

    @SQLSeq(order = 2)
    public String userID;

    @SQLSeq(order = 3)
    public Date pushDate;

    @SQLSeq(order = 4)
    public String title;

    @SQLSeq(order = 5)
    public String content;

    public int getForumID() {
        return forumID;
    }

    public void setForumID(int forumID) {
        this.forumID = forumID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public Date getPushDate() {
        return pushDate;
    }

    public void setPushDate(Date pushDate) {
        this.pushDate = pushDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ForumBean() {
        OurDatabase ourDatabase = OurDatabase.getDataBase();
        this.pushDate = ourDatabase.getNowDate();
    }

    @Override
    public String toString() {
        return "ForumBean{" +
                "forumID=" + forumID +
                ", userID='" + userID + '\'' +
                ", pushDate=" + pushDate +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
