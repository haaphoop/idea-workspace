package com.company.clone;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;

/**
 * Created by daishuli on 2017/8/8.
 */
public class User implements Cloneable, Serializable {
    private String username;
    private String password;
    private Date birthday;
    public User(String username, String password, Date birthday) {
        this.username = username;
        this.password = password;
        this.birthday = birthday;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User("Kent","123456", new Date());
        User user1 = user;
        User user2 = (User)user1.clone();

        System.out.println(user == user1);
        System.out.println(user.equals(user1));
        System.out.println(user == user2);
        System.out.println(user.equals(user2));
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User user = (User)obj;
            if (user.username == this.username && user.password == this.password && user.birthday == this.birthday) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
