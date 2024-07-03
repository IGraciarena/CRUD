package dev.igraciarena.mapper;

import dev.igraciarena.model.User;
import dev.igraciarena.model.UserByIdResponse;
import dev.igraciarena.model.UserCreatedResponse;
import dev.igraciarena.model.UserUpdatedResponse;

/**
 * @author ivan.graciarena
 * @project CRUD
 */
public final class UserMapper {

    private UserMapper() {
    }

    public static UserByIdResponse mapUserToUserByIdResponse(final User user) {
        return new UserByIdResponse(user.getUserName(), user.getName(), user.getSureName(), user.getEmail());
    }

    public static UserCreatedResponse mapUserToUserCreatedResponse(final User user, final int userId) {
        return new UserCreatedResponse(userId, user.getEmail());
    }

    public static UserUpdatedResponse mapUserToUserUpdatedResponse(final User user) {
        return new UserUpdatedResponse(user.getUserName(), user.getEmail(), user.getModifiedDate());
    }
}
