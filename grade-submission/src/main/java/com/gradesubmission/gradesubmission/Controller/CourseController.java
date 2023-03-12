package com.gradesubmission.gradesubmission.Controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gradesubmission.gradesubmission.POJO.Courses;
import com.gradesubmission.gradesubmission.POJO.Students;
import com.gradesubmission.gradesubmission.Serivce.CourseService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {
    CourseService courseService;
    @GetMapping("/{course_id}")
    public ResponseEntity<Courses> getCourse(@PathVariable Long course_id){
        return new ResponseEntity<>(courseService.getCourse(course_id), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Courses> saveCourse(@Valid@RequestBody Courses courses){
        return new ResponseEntity<Courses>(courseService.saveCourse(courses), HttpStatus.CREATED);
    }
    @DeleteMapping("/{course_id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long course_id){
        courseService.deleteCourse(course_id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Courses>> getallcourse(){
        return new ResponseEntity<>(courseService.getallCourses(),HttpStatus.OK);
    }

    @PutMapping("/{course_id}/student/{student_id}")
    public ResponseEntity<Courses> enrollStudent(@PathVariable Long course_id, @PathVariable Long student_id){
        return new ResponseEntity<>(courseService.enrollStudent(student_id, course_id),HttpStatus.OK);
    }

    @GetMapping("/{course_id}/students")
    public ResponseEntity<Set<Students>> getStudentsEnrolled(@PathVariable Long course_id){
        return new ResponseEntity<>(courseService.getStudentsEnrolled(course_id),HttpStatus.OK);
    }
}
