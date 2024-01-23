package com.example.schedulemanagement.schedule.controller;

import com.example.schedulemanagement.exception.BadCredentialsException;
import com.example.schedulemanagement.exception.dto.ExceptionDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ScheduleErrorController {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionDto> handleBadCredentials(BadCredentialsException e) {
        return ResponseEntity.badRequest().body(new ExceptionDto(e.getMessage()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleEntityNotFound(EntityNotFoundException e) {
        return ResponseEntity.badRequest().body(new ExceptionDto(e.getMessage()));
    }
}
