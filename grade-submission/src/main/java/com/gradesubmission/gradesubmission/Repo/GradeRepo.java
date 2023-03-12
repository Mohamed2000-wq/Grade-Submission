package com.gradesubmission.gradesubmission.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gradesubmission.gradesubmission.POJO.Grades;

public interface GradeRepo extends CrudRepository<Grades,Long> {
    Optional<Grades> findByStudentsIdAndCoursesId(Long student_id,Long Course_id);
    @Transactional
    void deleteByStudentsIdAndCoursesId(Long student_id,Long Course_id);
    List<Grades> findByStudentsId(Long student_id);
    List<Grades> findByCoursesId(Long course_id);
}
