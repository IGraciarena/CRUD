package dev.igraciarena.exception;

import dev.igraciarena.enums.DaoError;

/**
 * @author ivan.graciarena
 * @project CRUD
 */
public class UserEmailAlreadyExistsException extends RuntimeException {
    private final DaoError error;

    public UserEmailAlreadyExistsException(final DaoError error) {
        this.error = error;
    }
}
