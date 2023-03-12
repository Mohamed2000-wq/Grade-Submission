package com.gradesubmission.gradesubmission.Controller;

import java.util.List;

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

import com.gradesubmission.gradesubmission.POJO.Grades;
import com.gradesubmission.gradesubmission.Serivce.GradeService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/grades")
public class GradesController {
    GradeService gradeService;

    @GetMapping("/student/{student_id}/course/{course_id}")
    public ResponseEntity<Grades> getGrade(@PathVariable Long student_id,@PathVariable Long course_id){
        return new ResponseEntity<Grades>(gradeService.getGrade(student_id, course_id), HttpStatus.OK);
    }

    @PostMapping("/student/{student_id}/course/{course_id}")
    public ResponseEntity<Grades> saveGrade(@Valid@RequestBody Grades grades,@PathVariable Long student_id,@PathVariable Long course_id){
        return new ResponseEntity<Grades>(gradeService.saveGrade(grades, student_id, course_id), HttpStatus.CREATED);
    }

    @DeleteMapping("/student/{student_id}/course/{course_id}")
    public ResponseEntity<HttpStatus> deleteGrade(@PathVariable Long student_id,@PathVariable Long course_id){
        gradeService.deleteGrade(student_id, course_id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/student/{student_id}/course/{course_id}")
    public ResponseEntity<Grades> updateGrade(@Valid@RequestBody Grades grades,@PathVariable Long student_id,@PathVariable Long course_id){
        return new ResponseEntity<Grades>(gradeService.updateGrade(grades.getScore(),student_id, course_id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Grades>> getallGrades(){
        return new ResponseEntity<>(gradeService.getallgrades(),HttpStatus.OK);
    }

    @GetMapping("/student/{student_id}")
    public ResponseEntity<List<Grades>> getStudentGrades(@PathVariable Long student_id){
        return new ResponseEntity<>(gradeService.getStudentsGrades(student_id), HttpStatus.OK);
    }

    @GetMapping("/course/{course_id}")
    public ResponseEntity<List<Grades>> getCourseGrades(@PathVariable Long course_id){
        return new ResponseEntity<>(gradeService.getCoursesGrades(course_id),HttpStatus.OK);
    }
}
