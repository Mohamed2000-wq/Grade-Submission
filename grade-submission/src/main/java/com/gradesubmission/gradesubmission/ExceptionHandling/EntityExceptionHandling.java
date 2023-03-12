package com.gradesubmission.gradesubmission.ExceptionHandling;


public class EntityExceptionHandling extends RuntimeException{

    public EntityExceptionHandling(Long id,Class<?> entity) {
        super("This "+entity.getSimpleName()+" with id "+id+" does't exsist");
    }

}
