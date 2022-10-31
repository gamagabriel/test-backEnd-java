package com.uol.api.exceptions;

public class FailRequestHttpException extends Throwable {

    public FailRequestHttpException() {
        super();
    }

    public FailRequestHttpException(String message) {
        super(message);
    }

    public FailRequestHttpException(Throwable cause) {
        super(cause);
    }

    public FailRequestHttpException(String message, Throwable cause){
        super(message, cause);
    }
}
