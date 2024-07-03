package dev.igraciarena.model;

/**
 * @author ivan.graciarena
 * @project CRUD
 */
public class UserByIdResponse {
    private final String userName;
    private final String name;
    private final String sureName;
    private final String email;

    public UserByIdResponse(String userName, String name, String sureName, String email) {
        this.userName = userName;
        this.name = name;
        this.sureName = sureName;
        this.email = email;
    }

    public String getUserName() {
        return userName;
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
}
