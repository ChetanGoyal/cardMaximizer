package com.example.cardmaximizer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("status", "error");
        errorMap.put("message", ex.getMessage());
        return new ResponseEntity<>(errorMap, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneralException(Exception ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("status", "error");
        errorMap.put("message", "An unexpected error occurred. Please try again.");
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}
