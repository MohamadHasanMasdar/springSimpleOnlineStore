package com.example.productservice.exception;

public class ValidationExceptionHandler extends GlobalCustomException{

    public ValidationExceptionHandler() {
        super("exception occured", "quantity");
    }

    public ValidationExceptionHandler(String message) {
        super(message, "quantity");
    }
}
