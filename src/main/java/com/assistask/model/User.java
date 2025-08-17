/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assistask.model;

import java.util.Date;

/**
 *
 * @author stredhy
 */
public class User {
    private int id;
    private String username;
    private String email;
    private Date birthday;

    private void copyAll(User usr){
        this.id = usr.id;
        this.username = usr.username;
        this.email = usr.email;
        this.birthday = usr.birthday;
    }
    
    public User(User usr){
        copyAll(usr);
    }
    
    
    public User(int id, String username, String email, Date birthday) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    
}
