package dev.igraciarena.controller;

import dev.igraciarena.model.User;
import dev.igraciarena.model.UserByIdResponse;
import dev.igraciarena.model.UserCreatedResponse;
import dev.igraciarena.model.UserUpdatedRequest;
import dev.igraciarena.model.UserUpdatedResponse;
import dev.igraciarena.service.UserService;

/**
 * @author ivan.graciarena
 * @project CRUD
 */
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    public UserCreatedResponse saveUser(final User user) {
        return userService.saveUser(user);
    }

    public UserByIdResponse getUserById(final int userId) {
        return userService.getById(userId);
    }

    public void deleteUser(final int userId) {
        userService.deleteUser(userId);
    }

    public UserUpdatedResponse updateUser(final UserUpdatedRequest user, final String email) {
        return userService.updateUser(user, email);
    }
}
