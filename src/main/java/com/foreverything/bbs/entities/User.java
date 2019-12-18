package com.foreverything.bbs.entities;

/**
 * @ClassName User
 * @Author LiuJingxin
 * @Date Created in 14:46 2019/12/17
 * @Description
 */
public class User extends BaseBean {
    private String account;
    private String password;
    private String mail;
    private int grade;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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
