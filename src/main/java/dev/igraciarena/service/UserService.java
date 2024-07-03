package dev.igraciarena.service;

import dev.igraciarena.model.User;
import dev.igraciarena.model.UserByIdResponse;
import dev.igraciarena.model.UserCreatedResponse;
import dev.igraciarena.model.UserUpdatedRequest;
import dev.igraciarena.model.UserUpdatedResponse;

/**
 * @author ivan.graciarena
 * @project CRUD
 */
public interface UserService {
    UserCreatedResponse saveUser(final User user);

    UserByIdResponse getById(final int userId);

    void deleteUser(final int userId);

    UserUpdatedResponse updateUser(final UserUpdatedRequest user, final String email);
}
