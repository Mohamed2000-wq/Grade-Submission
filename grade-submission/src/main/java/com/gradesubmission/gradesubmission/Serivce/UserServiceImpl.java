package com.gradesubmission.gradesubmission.Serivce;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gradesubmission.gradesubmission.ExceptionHandling.EntityExceptionHandling;
import com.gradesubmission.gradesubmission.POJO.User;
import com.gradesubmission.gradesubmission.Repo.UserRepo;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    UserRepo userRepo;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepo.findById(id);
        return unwrapUser(id, user);
    }
    @Override
    public User getUser(String username) {
        Optional<User> user = userRepo.findByUsername(username);
        return unwrapUser(404L, user);
    }
    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public static User unwrapUser(Long id,Optional<User> entity){
        if(entity.isPresent()) return entity.get();
        else throw new EntityExceptionHandling(id, User.class);
    }
}
