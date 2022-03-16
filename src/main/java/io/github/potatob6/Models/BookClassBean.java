package io.github.potatob6.Models;

import io.github.potatob6.Annos.SQLSeq;

public class BookClassBean {
    @SQLSeq(order = 1)
    public int classID;

    @SQLSeq(order = 2)
    public String className;

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public BookClassBean() {
        this.classID = 0;
        this.className = null;
    }
}
