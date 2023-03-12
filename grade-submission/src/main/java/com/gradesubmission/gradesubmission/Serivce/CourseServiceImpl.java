package com.gradesubmission.gradesubmission.Serivce;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.gradesubmission.gradesubmission.ExceptionHandling.EntityExceptionHandling;
import com.gradesubmission.gradesubmission.POJO.Courses;
import com.gradesubmission.gradesubmission.POJO.Students;
import com.gradesubmission.gradesubmission.Repo.CourseRepo;
import com.gradesubmission.gradesubmission.Repo.StudentRepo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    CourseRepo courseRepo;
    StudentRepo studentRepo;
    @Override
    public Courses getCourse(Long id) {
        Optional<Courses> courses = courseRepo.findById(id);
        return unwrappedCourses(id, courses);
    }
    @Override
    public Courses saveCourse(Courses courses) {
        return courseRepo.save(courses);
    }
    @Override
    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }

    @Override
    public List<Courses> getallCourses() {
        return (List<Courses>)courseRepo.findAll();
    }

    @Override
    public Courses enrollStudent(Long student_id, Long course_id) {
        Courses courses = getCourse(course_id);
        Optional<Students> students = studentRepo.findById(student_id);
        Students unwrappStudents = StudentServiceImpl.unwrappedStudent(students, student_id);
        courses.getStudents().add(unwrappStudents);
        return courseRepo.save(courses);
    }
    @Override
    public Set<Students> getStudentsEnrolled(Long course_id) {
        Courses courses = getCourse(course_id);
        return  courses.getStudents();
    }
    public static Courses unwrappedCourses(Long course_id,Optional<Courses> entity){
        if(entity.isPresent()) return entity.get();
        else throw new EntityExceptionHandling(course_id, Courses.class);
    }
}
