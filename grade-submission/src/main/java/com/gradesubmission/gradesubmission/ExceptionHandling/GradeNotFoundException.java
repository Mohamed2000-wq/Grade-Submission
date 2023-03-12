package com.gradesubmission.gradesubmission.ExceptionHandling;

public class GradeNotFoundException extends RuntimeException{

    public GradeNotFoundException(Long student_id,Long course_id) {
        super("This grade is not found for student with "+student_id+" and course "+course_id);
    }
    
}
