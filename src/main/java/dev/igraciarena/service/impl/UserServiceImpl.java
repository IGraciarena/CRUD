package dev.igraciarena.service.impl;

import dev.igraciarena.dao.UserDao;
import dev.igraciarena.model.User;
import dev.igraciarena.model.UserByIdResponse;
import dev.igraciarena.model.UserCreatedResponse;
import dev.igraciarena.model.UserUpdatedRequest;
import dev.igraciarena.model.UserUpdatedResponse;
import dev.igraciarena.service.UserService;

import static dev.igraciarena.mapper.UserMapper.mapUserToUserByIdResponse;
import static dev.igraciarena.mapper.UserMapper.mapUserToUserCreatedResponse;
import static dev.igraciarena.mapper.UserMapper.mapUserToUserUpdatedResponse;

/**
 * @author ivan.graciarena
 * @project CRUD
 */
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(final UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserCreatedResponse saveUser(final User user) {
        int savedUserId = userDao.saveUser(user);
        return mapUserToUserCreatedResponse(user, savedUserId);
    }

    @Override
    public UserByIdResponse getById(final int id) {
        var userById = userDao.getById(id);
        return mapUserToUserByIdResponse(userById);
    }

    @Override
    public void deleteUser(final int userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public UserUpdatedResponse updateUser(final UserUpdatedRequest user, final String email) {
        var updatedUser = userDao.updateUser(user, email);
        return mapUserToUserUpdatedResponse(updatedUser);
    }
}
