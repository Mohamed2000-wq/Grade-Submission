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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gradesubmission.gradesubmission.POJO.Courses;
import com.gradesubmission.gradesubmission.POJO.Students;
import com.gradesubmission.gradesubmission.Serivce.StudentService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {
    StudentService studentService;
    @GetMapping("/{student_id}")
    public ResponseEntity<Students> getStudents(@PathVariable Long student_id){
        return new ResponseEntity<>(studentService.getStudent(student_id),HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Students> postStudent(@Valid@RequestBody Students students){
        return new ResponseEntity<>(studentService.saveStudents(students),HttpStatus.CREATED);
    }
    @DeleteMapping("/{student_id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long student_id){
        studentService.deleteStudent(student_id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Students>> getStudents(){
        return new ResponseEntity<>(studentService.getallStudents(),HttpStatus.OK);
    }

    @GetMapping("/{student_id}/courses")
    public ResponseEntity<Set<Courses>> getCourseseEnrolledToStudents(@PathVariable Long student_id){
        return new ResponseEntity<>(studentService.getCoursesforthestudent(student_id), HttpStatus.OK);
    }
}
