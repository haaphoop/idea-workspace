package com.company.clone;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by daishuli on 2017/8/8.
 */
public class Administrator implements Cloneable, Serializable {
    private User user;
    private Boolean editable;

    public Administrator(User user, Boolean editable) {
        this.user = user;
        this.editable = editable;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Administrator administrator1 = new Administrator(new User("Kent", "123456", new Date()), true);
        Administrator administrator2 = administrator1;
        Administrator administrator3 = (Administrator)administrator1.clone();
        System.out.println(administrator1 == administrator2);
        System.out.println(administrator1.equals(administrator2));
        System.out.println(administrator1 == administrator3);
        System.out.println(administrator1.equals(administrator3));

        System.out.println(administrator1.getUser() == administrator3.getUser());
        System.out.println(administrator1.getUser().equals(administrator3.getUser()));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Administrator administrator = (Administrator)super.clone();
        administrator.user = (User)administrator.user.clone();
        return administrator;
        //return super.clone();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
