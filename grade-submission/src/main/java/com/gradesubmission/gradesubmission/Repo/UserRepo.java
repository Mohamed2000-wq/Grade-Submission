package com.gradesubmission.gradesubmission.Repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gradesubmission.gradesubmission.POJO.User;

public interface UserRepo extends CrudRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
