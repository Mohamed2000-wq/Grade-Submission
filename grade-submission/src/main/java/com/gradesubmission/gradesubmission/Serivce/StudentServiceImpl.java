package com.gradesubmission.gradesubmission.Serivce;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.gradesubmission.gradesubmission.ExceptionHandling.EntityExceptionHandling;
import com.gradesubmission.gradesubmission.POJO.Courses;
import com.gradesubmission.gradesubmission.POJO.Students;
import com.gradesubmission.gradesubmission.Repo.StudentRepo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{
    StudentRepo studentRepo;
    @Override
    public Students getStudent(Long student_id) {
        Optional<Students> students = studentRepo.findById(student_id);
        return unwrappedStudent(students,student_id);
    }
    @Override
    public Students saveStudents(Students students) {
        return studentRepo.save(students);
    }
    @Override
    public void deleteStudent(Long student_id) {
        studentRepo.deleteById(student_id);
    }
    @Override
    public List<Students> getallStudents() {
        return (List<Students>)studentRepo.findAll();
    }
    @Override
    public Set<Courses> getCoursesforthestudent(Long student_id) {
        Students students = getStudent(student_id);
        return students.getCourses();
    }
    public static Students unwrappedStudent(Optional<Students> entity,Long student_id){
        if(entity.isPresent()) return entity.get();
        else throw new EntityExceptionHandling(student_id, Students.class);
    }
}
