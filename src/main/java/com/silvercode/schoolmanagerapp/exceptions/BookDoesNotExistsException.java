package com.silvercode.schoolmanagerapp.exceptions;

public class BookDoesNotExistsException extends RuntimeException {
    public BookDoesNotExistsException(String message) {
        super(message);
    }
}
