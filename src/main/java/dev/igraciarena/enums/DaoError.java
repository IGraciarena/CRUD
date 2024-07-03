package dev.igraciarena.enums;

import java.time.Instant;

/**
 * @author ivan.graciarena
 * @project CRUD
 */
public enum DaoError {
    USER_ALREADY_EXISTS_EXCEPTION_MESSAGE("USER_ALREADY_EXISTS",
            "The email that was provided already have an existing account.", Instant.now()),
    USER_NOT_FOUND("NOT FOUND", "The username that was provided was not found.", Instant.now());

    private final String code;
    private final String description;
    private final Instant timestamp;

    DaoError(final String code,final String description,final Instant timestamp) {
        this.code = code;
        this.description = description;
        this.timestamp = timestamp;
    }
}
