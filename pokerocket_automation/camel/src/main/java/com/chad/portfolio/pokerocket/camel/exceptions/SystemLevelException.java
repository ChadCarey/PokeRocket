package com.chad.portfolio.pokerocket.camel.exceptions;

public class SystemLevelException extends Exception {
    public SystemLevelException(Exception e) {
        super(e);
    }

    public SystemLevelException(String message, Exception e) {
        super(message, e);
    }

    public SystemLevelException(String message) {
        super(message);
    }
}
