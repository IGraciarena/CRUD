package dev.igraciarena.model;

import java.time.Instant;

/**
 * @author ivan.graciarena
 * @project CRUD
 */
public class UserUpdatedResponse {
    private final String userName;
    private final String email;
    private final Instant modifiedDate;

    public UserUpdatedResponse(String userName, String email, Instant modifiedDate) {
        this.userName = userName;
        this.email = email;
        this.modifiedDate = modifiedDate;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public Instant getModifiedDate() {
        return modifiedDate;
    }
}
