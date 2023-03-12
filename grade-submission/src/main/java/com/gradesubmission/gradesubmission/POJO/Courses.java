package com.gradesubmission.gradesubmission.POJO;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank(message = "Subject can not be empty")
    @NonNull
    @Column(name = "subject",nullable = false)
    private String subject;
    @NotBlank(message = "Code can not be empty")
    @NonNull
    @Column(name = "code",nullable = false)
    private String code;
    @NotBlank(message = "description can not be empty")
    @NonNull
    @Column(name = "description",nullable = false)
    private String description;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "students_courses",
    joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Students> students;
    @OneToMany(mappedBy = "courses",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Grades> grades;
}
