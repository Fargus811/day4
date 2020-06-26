package com.sergeev.day4_1.exception;

public class IntArrayWrapperException extends Exception {
    public IntArrayWrapperException() {
        super();
    }

    public IntArrayWrapperException(String message) {
        super(message);
    }

    public IntArrayWrapperException(String message, Throwable cause) {
        super(message, cause);
    }

    public IntArrayWrapperException(Throwable cause) {
        super(cause);
    }
}
