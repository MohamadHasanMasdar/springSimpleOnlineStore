package com.example.productservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GlobalCustomException extends RuntimeException{

    private String message;
    private String fieldName;

    public GlobalCustomException(String message) {
        super(message);
    }
}
