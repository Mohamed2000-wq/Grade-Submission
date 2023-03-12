package com.gradesubmission.gradesubmission.ExceptionHandling;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ErrorHandling {
    private List<String> message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy hh:mm")
    private LocalDateTime timestamp;

    public ErrorHandling(List<String> message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
    
}
