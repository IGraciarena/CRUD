package dev.igraciarena.model;

/**
 * @author ivan.graciarena
 * @project CRUD
 */
public class UserUpdatedRequest {
    private final String userName;
    private final String email;

    public UserUpdatedRequest(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }
}
