package com.gradesubmission.gradesubmission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gradesubmission.gradesubmission.ExceptionHandling.EntityExceptionHandling;
import com.gradesubmission.gradesubmission.ExceptionHandling.ErrorHandling;
import com.gradesubmission.gradesubmission.ExceptionHandling.GradeNotFoundException;

@ControllerAdvice
public class Handling extends ResponseEntityExceptionHandler{

    @ExceptionHandler({EntityExceptionHandling.class,GradeNotFoundException.class})
    public ResponseEntity<Object> handleEntity(RuntimeException ex){
        ErrorHandling error = new ErrorHandling(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> deleteException(RuntimeException ex){
        ErrorHandling error = new ErrorHandling(Arrays.asList("This id doest not exsist to delete it"));
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> dataViolation(DataIntegrityViolationException ex){
        ErrorHandling error = new ErrorHandling(Arrays.asList("You have entered the data for this record before"));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
                List<String> erros = new ArrayList<>();
                for (ObjectError error :ex.getBindingResult().getAllErrors()) {
                    erros.add(error.getDefaultMessage());
                }
        return new ResponseEntity<>(erros,HttpStatus.BAD_REQUEST);
    }
}
