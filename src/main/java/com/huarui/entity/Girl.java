package com.huarui.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * Created by lihui on 2019/3/3.
 */
public class Girl implements Serializable {

    private String id;
    private String name;
    private Date date;

    public Girl(){

    }

    public Girl(String id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
