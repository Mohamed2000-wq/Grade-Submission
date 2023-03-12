package com.gradesubmission.gradesubmission.POJO;

import java.time.LocalDate;
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
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank(message = "Name can not be blank")
    @NonNull
    @Column(name = "Name",nullable = false)
    private String name;
    @Past(message = "date can not be in the future")
    @NonNull
    @Column(name = "date",nullable = false)
    private LocalDate dateofbirth;
    @ManyToMany()
    @JsonIgnore
    @JoinTable(name = "students_courses",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Courses> courses;
    @OneToMany(mappedBy = "students",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Grades> grades;
}
