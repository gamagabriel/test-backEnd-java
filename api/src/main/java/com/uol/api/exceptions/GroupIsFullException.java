package com.uol.api.exceptions;

public class GroupIsFullException extends Throwable {

    public GroupIsFullException() {
        super();
    }

    public GroupIsFullException(String message) {
        super(message);
    }

    public GroupIsFullException(Throwable cause) {
        super(cause);
    }

    public GroupIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

}