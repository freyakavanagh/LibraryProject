package com.sparta.fk.libraryproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AuthorNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(AuthorNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AuthorNotFoundResponse> authorNotFoundHandler(AuthorNotFoundException e) {
        AuthorNotFoundResponse response = new AuthorNotFoundResponse(e.getMessage(), 400);
        return ResponseEntity.badRequest().body(response);
    }
}
