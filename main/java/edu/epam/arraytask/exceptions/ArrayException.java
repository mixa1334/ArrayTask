package edu.epam.arraytask.exceptions;

public class ArrayException extends Exception {
    public ArrayException() {
    }

    public ArrayException(String message) {
        super(message);
    }

    public ArrayException(Exception exception) {
        super(exception);
    }

    public ArrayException(String message, Exception exception) {
        super(message, exception);
    }
}
