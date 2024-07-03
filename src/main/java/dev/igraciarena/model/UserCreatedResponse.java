package dev.igraciarena.model;

/**
 * @author ivan.graciarena
 * @project CRUD
 */
public class UserCreatedResponse {
    private final int userId;
    private final String email;

    public UserCreatedResponse(int userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }
}
