package com.company.serializable;

import java.io.Serializable;

/**
 * Created by daishuli on 2017/8/8.
 */
public class Administrator implements Serializable {
    static final long serialVersionUID = 1L;
    private User user;
    private Boolean editable;

    public Administrator(User user, Boolean editable) {
        this.user = user;
        this.editable = editable;
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
}
