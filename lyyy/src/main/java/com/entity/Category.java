package com.entity;

import javax.persistence.*;

@Entity
@Table(name="category")
public class Category{
    @Id
    @Column(name="id")
    Integer id;
    @Column(name="name",length=225)
    String name;
    @Column(name="p_id",length=225)
    String pId;
    @Column(name="level")
    int level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pId='" + pId + '\'' +
                ", level=" + level +
                '}';
    }
}
