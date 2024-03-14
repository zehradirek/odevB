package com.tobeto.exception;

public class NoSpaceAvailableException extends RuntimeException {

    public NoSpaceAvailableException(String message) {
        super(message);
    }

    public NoSpaceAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    // Method to handle NoSpaceAvailableException
    public static void handleNoSpaceAvailableException(NoSpaceAvailableException ex) {
        System.out.println("No space available: " + ex.getMessage());

    }
}
