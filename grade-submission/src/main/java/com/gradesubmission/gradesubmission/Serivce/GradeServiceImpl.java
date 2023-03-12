package com.gradesubmission.gradesubmission.Serivce;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gradesubmission.gradesubmission.ExceptionHandling.GradeNotFoundException;
import com.gradesubmission.gradesubmission.POJO.Courses;
import com.gradesubmission.gradesubmission.POJO.Grades;
import com.gradesubmission.gradesubmission.POJO.Students;
import com.gradesubmission.gradesubmission.Repo.CourseRepo;
import com.gradesubmission.gradesubmission.Repo.GradeRepo;
import com.gradesubmission.gradesubmission.Repo.StudentRepo;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {
    GradeRepo gradeRepo;
    StudentRepo studentRepo;
    CourseRepo courseRepo;
    @Override
    public Grades getGrade(Long student_id, Long course_id) {
        Optional<Grades> grade = gradeRepo.findByStudentsIdAndCoursesId(student_id, course_id);
        return unwrappGrades(student_id, course_id,grade);
    }
    @Override
    public Grades saveGrade(Grades grades, Long student_id, Long course_id) {
        Students students = StudentServiceImpl.unwrappedStudent(studentRepo.findById(student_id), student_id);
        Courses courses = CourseServiceImpl.unwrappedCourses(course_id, courseRepo.findById(course_id));
        grades.setCourses(courses);
        grades.setStudents(students);
        return gradeRepo.save(grades);
    }
    @Override
    public void deleteGrade(Long student_id, Long course_id) {
        gradeRepo.deleteByStudentsIdAndCoursesId(student_id, course_id);
    }
    @Override
    public Grades updateGrade(String score,Long student_id, Long course_id) {
        Optional<Grades> grade = gradeRepo.findByStudentsIdAndCoursesId(student_id, course_id);
        Grades unwrappGrades = unwrappGrades(student_id, course_id, grade);
        unwrappGrades.setScore(score);
        return gradeRepo.save(unwrappGrades);
    }
    @Override
    public List<Grades> getallgrades() {
        return (List<Grades>)gradeRepo.findAll();
    }
    @Override
    public List<Grades> getStudentsGrades(Long student_id) {
        return gradeRepo.findByStudentsId(student_id);
    }
    @Override
    public List<Grades> getCoursesGrades(Long course_id) {
        return gradeRepo.findByCoursesId(course_id);
    }
    public static Grades unwrappGrades(Long student_id,Long course_id,Optional<Grades> entity){
        if(entity.isPresent()) return entity.get();
        else throw new GradeNotFoundException(student_id, course_id);
    }
}
