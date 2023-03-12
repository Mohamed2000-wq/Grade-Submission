package com.gradesubmission.gradesubmission.Serivce;

import com.gradesubmission.gradesubmission.POJO.User;

public interface UserService {
    User getUser(Long id);
    User getUser(String username);
    User saveUser(User user);
}
