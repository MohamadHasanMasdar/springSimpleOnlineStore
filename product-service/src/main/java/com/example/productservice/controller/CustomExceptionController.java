package com.example.productservice.controller;

import com.example.productservice.exception.ErrorResponse;
import com.example.productservice.exception.GlobalCustomException;
import com.example.productservice.exception.NotFoundExceptionHandler;
import com.example.productservice.exception.ValidationExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@ControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundExceptionHandler.class)
    ResponseEntity handle(NotFoundExceptionHandler e) {
        List<String> errorList = new ArrayList<>();
        errorList.add(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorList);
    }

    @ExceptionHandler(GlobalCustomException.class)
    ResponseEntity handleGlobalException(GlobalCustomException e, Locale locale) {
        return ResponseEntity
                .badRequest()
                .body(ErrorResponse.builder()
                        .code(e.getFieldName())
                        .message(e.getMessage())
                        .build());
    }


//    @ExceptionHandler(ValidationExceptionHandler.class)
//    ResponseEntity handle(ValidationExceptionHandler e) {
//        Map<String, String> errorMap = new HashMap<>();
//        errorMap.put(e.getFieldName(), e.getMessage());
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(errorMap);
//    }
}
