package dev.igraciarena.dao;

import dev.igraciarena.exception.UserEmailAlreadyExistsException;
import dev.igraciarena.exception.UserNotFoundException;
import dev.igraciarena.model.User;
import dev.igraciarena.model.UserUpdatedRequest;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static dev.igraciarena.enums.DaoError.USER_ALREADY_EXISTS_EXCEPTION_MESSAGE;
import static dev.igraciarena.enums.DaoError.USER_NOT_FOUND;
import static java.lang.Boolean.TRUE;

/**
 * @author ivan.graciarena
 * @project CRUD
 */
public class UserDao {

    private final Map<Integer, User> userMap;
    private int currentId;

    public UserDao() {
        this.userMap = new HashMap<>();
        this.currentId = 0;
    }

    public int saveUser(final User user) {
        if (containsEmail(user.getEmail())) {
            throw new UserEmailAlreadyExistsException(USER_ALREADY_EXISTS_EXCEPTION_MESSAGE);
        }
        currentId++;
        userMap.put(currentId, user);
        return currentId;
    }

    public User getById(final int userId) {
        if (checkIsDeleted(userId)) {
            throw new UserNotFoundException(USER_NOT_FOUND);
        }
        return userMap.get(userId);
    }

    public void deleteUser(final int userId) {
        userMap.get(userId).setDeleted(TRUE);
    }

    public User updateUser(final UserUpdatedRequest user, final String email) {
        var userToBeUpdated = retrievesByEmail(email);
        var id = getKeyByEmail(email);
        userToBeUpdated.setUserName(user.getUserName());
        userToBeUpdated.setEmail(user.getEmail());
        userToBeUpdated.setModifiedDate(Instant.now());
        userMap.put(id, userToBeUpdated);
        return userToBeUpdated;
    }

    private boolean containsEmail(final String email) {
        return userMap.values().stream()
                .anyMatch(user -> user.getEmail().equals(email));
    }

    private boolean checkIsDeleted(final int userId) {
        return userMap.get(userId).isDeleted();
    }

    private User retrievesByEmail(final String email) {
        return userMap.values().stream()
                .filter(userInMap -> userInMap.getEmail().equals(email) && !userInMap.isDeleted())
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
    }

    private int getKeyByEmail(final String email) {
        return userMap.entrySet().stream()
                .filter(entry -> entry.getValue().getEmail().equals(email) && !entry.getValue().isDeleted())
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
    }
}
