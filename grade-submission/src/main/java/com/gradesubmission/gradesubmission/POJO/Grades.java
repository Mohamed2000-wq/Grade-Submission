package com.gradesubmission.gradesubmission.POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.gradesubmission.gradesubmission.Validation.score;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Grades",
uniqueConstraints = @UniqueConstraint(columnNames = {"student_id","course_id"})
)
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @score(message = "score must be a letter grade")
    @Column(name = "score",nullable = false)
    private String score;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Students students;
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Courses courses;
}
