package com.sparta.fk.libraryproject.exceptions;

public class AuthorNotFoundResponse {
    private String message;
    private int statusCode;

    public AuthorNotFoundResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
