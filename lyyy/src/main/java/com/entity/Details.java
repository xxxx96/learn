package com.entity;

import javax.persistence.*;

@Entity
@Table(name="details")
public class Details {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="title",length=225)
    private String title;
    @Column(name="preface",length=225)
    private String preface;
    @Column(name="text",length=225)
    private String text;
    @Column(name="pic_url",length=225)
    private String picUrl;
    @Column(name="man_surname",length=225)
    private String manSurname;
    @Column(name="woman_surname",length=225)
    private String womanSurname;
    @Column(name="category_id")
    private Integer categoryId;
    @Column(name="time",length=225)
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreface() {
        return preface;
    }

    public void setPreface(String preface) {
        this.preface = preface;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getManSurname() {
        return manSurname;
    }

    public void setManSurname(String manSurname) {
        this.manSurname = manSurname;
    }

    public String getWomanSurname() {
        return womanSurname;
    }

    public void setWomanSurname(String womanSurname) {
        this.womanSurname = womanSurname;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
