package com.ghilea.cryptotrading.exception;

/**
 * Exception thrown when a requested resource entity is not found.
 *
 * @author Dan Lucian Ghilea
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
