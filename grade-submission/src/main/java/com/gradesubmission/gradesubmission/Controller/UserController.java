package com.gradesubmission.gradesubmission.Controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gradesubmission.gradesubmission.POJO.User;
import com.gradesubmission.gradesubmission.Serivce.UserService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@Valid@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

   @GetMapping("/{id}")
   public ResponseEntity<String> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUser(id).getUsername(),HttpStatus.OK);
   }
    
}
