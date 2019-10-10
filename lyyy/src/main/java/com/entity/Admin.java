package com.entity;

import javax.persistence.*;

@Entity
@Table(name="admin")
public class Admin {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Integer id;
   @Column(name="username",length=225)
   private String username;
   @Column(name="password")
   private String password;
   @Column(name="real_name")
   private String realName;
   @Column(name="level")
   private short level;

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", level=" + level +
                '}';
    }
}
