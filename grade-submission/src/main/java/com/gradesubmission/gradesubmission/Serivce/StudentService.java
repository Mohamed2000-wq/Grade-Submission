package com.gradesubmission.gradesubmission.Serivce;
import java.util.List;
import java.util.Set;

import com.gradesubmission.gradesubmission.POJO.Courses;
import com.gradesubmission.gradesubmission.POJO.Students;

public interface StudentService {
    Students getStudent(Long student_id);
    Students saveStudents(Students students);
    void deleteStudent(Long student_id);
    List<Students> getallStudents();
    Set<Courses> getCoursesforthestudent(Long student_id);
    
}
