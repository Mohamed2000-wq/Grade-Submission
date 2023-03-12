package com.gradesubmission.gradesubmission.Serivce;

import java.util.List;

import com.gradesubmission.gradesubmission.POJO.Grades;

public interface GradeService {
    Grades getGrade(Long student_id,Long course_id);
    Grades saveGrade(Grades grades,Long student_id,Long course_id);
    void deleteGrade(Long student_id,Long course_id);
    Grades updateGrade(String score,Long student_id,Long course_id);
    List<Grades> getallgrades();
    List<Grades> getStudentsGrades(Long student_id);
    List<Grades> getCoursesGrades(Long course_id);
}
