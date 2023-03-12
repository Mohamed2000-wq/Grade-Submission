package com.gradesubmission.gradesubmission.Repo;

import org.springframework.data.repository.CrudRepository;

import com.gradesubmission.gradesubmission.POJO.Courses;

public interface CourseRepo extends CrudRepository<Courses,Long> {
    
}
