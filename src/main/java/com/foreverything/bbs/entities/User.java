package com.foreverything.bbs.entities;

/**
 * @ClassName User
 * @Author LiuJingxin
 * @Date Created in 14:46 2019/12/17
 * @Description
 */
public class User {
    private String password;
    private String mail;
    private int grade=0;
    private int id;
    private boolean isAdmin=false;
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", grade=" + grade +
                ", id=" + id +
                ", isAdmin=" + isAdmin +
                ", name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
