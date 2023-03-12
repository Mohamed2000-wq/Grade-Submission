package com.gradesubmission.gradesubmission.Repo;

import org.springframework.data.repository.CrudRepository;

import com.gradesubmission.gradesubmission.POJO.Students;

public interface StudentRepo extends CrudRepository<Students,Long>{
    
}
