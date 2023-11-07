package com.example.orderservice.controller;

import com.example.orderservice.exception.NotFoundException;
import com.example.orderservice.external.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionController {


    @ExceptionHandler(CustomException.class)
    ResponseEntity handle(CustomException e) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put(e.getErrorCode(), e.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorMap);
    }

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity handle(NotFoundException e) {
        List<String> errorList = new ArrayList<>();
        errorList.add(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorList);
    }
}
