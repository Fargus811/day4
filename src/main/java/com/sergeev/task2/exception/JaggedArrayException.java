package com.sergeev.task2.exception;

public class JaggedArrayException extends Exception {
    public JaggedArrayException() {
        super();
    }

    public JaggedArrayException(String message) {
        super(message);
    }

    public JaggedArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public JaggedArrayException(Throwable cause) {
        super(cause);
    }
}
