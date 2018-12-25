package com.pojo;

import java.util.Date;

public class User {

    private int id;

    private Date date;

    public User() {
    }

    public User(int id) {
        this.id = id;
        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
