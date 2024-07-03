package dev.igraciarena.exception;

import dev.igraciarena.enums.DaoError;

/**
 * @author ivan.graciarena
 * @project CRUD
 */
public class UserNotFoundException extends RuntimeException{
    private final DaoError error;

    public UserNotFoundException(final DaoError error) {
        this.error = error;
    }
}
