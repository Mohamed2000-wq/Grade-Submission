package com.gradesubmission.gradesubmission.Serivce;

import java.util.List;
import java.util.Set;

import com.gradesubmission.gradesubmission.POJO.Courses;
import com.gradesubmission.gradesubmission.POJO.Students;

public interface CourseService {
    Courses getCourse(Long id);
    Courses saveCourse(Courses courses);
    void deleteCourse(Long id);
    List<Courses> getallCourses();
    Courses enrollStudent(Long student_id,Long course_id);
    Set<Students> getStudentsEnrolled(Long course_id);
}
