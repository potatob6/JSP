package io.github.yywl5.Models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 星包客
 */
public class UserBean implements Serializable {
    private int id;
    private String uuidname;
    private String realname;
    private String savepath;
    private Timestamp uploadtime;
    private String description;
    private String ip;
    private String usernickname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuidname() {
        return uuidname;
    }

    public void setUuidname(String uuidname) {
        this.uuidname = uuidname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSavepath() {
        return savepath;
    }

    public void setSavepath(String savepath) {
        this.savepath = savepath;
    }

    public Timestamp getUploadtime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());
        Timestamp ts = Timestamp.valueOf(time);
        return ts;
    }

    public void setUploadtime(Timestamp uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsernickname() {
        return usernickname;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", uuidname='" + uuidname + '\'' +
                ", realname='" + realname + '\'' +
                ", savepath='" + savepath + '\'' +
                ", uploadtime=" + uploadtime +
                ", description='" + description + '\'' +
                ", ip='" + ip + '\'' +
                ", usernickname='" + usernickname + '\'' +
                '}';
    }

    public void setUsernickname(String usernickname) {
        this.usernickname = usernickname;
    }
}
