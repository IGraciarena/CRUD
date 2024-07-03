package dev.igraciarena.model;

import java.time.Instant;

import static java.lang.Boolean.FALSE;

/**
 * @author ivan.graciarena
 * @project CRUD
 */
public class User {
    private String name;
    private String sureName;
    private String email;
    private String userName;
    private boolean isDeleted;
    private Instant createdDate;
    private Instant modifiedDate;

    public User(String name, String sureName, String email, String userName) {
        this.name = name;
        this.sureName = sureName;
        this.email = email;
        this.userName = userName;
        this.isDeleted = FALSE;
        this.createdDate = Instant.now();
        this.modifiedDate = Instant.now();
    }

    public String getName() {
        return name;
    }

    public String getSureName() {
        return sureName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Instant getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
