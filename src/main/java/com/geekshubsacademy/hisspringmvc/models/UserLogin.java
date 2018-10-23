package com.geekshubsacademy.hisspringmvc.models;

public class UserLogin {
    private String user;
    private String pass;

    public UserLogin () {
    }

    public UserLogin(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}


