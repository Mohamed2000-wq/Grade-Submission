package com.gradesubmission.gradesubmission;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gradesubmission.gradesubmission.POJO.Courses;
import com.gradesubmission.gradesubmission.POJO.Students;
import com.gradesubmission.gradesubmission.Repo.CourseRepo;
import com.gradesubmission.gradesubmission.Repo.StudentRepo;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@SpringBootApplication
public class GradeSubmissionApplication implements CommandLineRunner{
	StudentRepo studentRepo;
	CourseRepo courseRepo;
	public static void main(String[] args) {
		SpringApplication.run(GradeSubmissionApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Override
	public void run(String... args) throws Exception {
		Students[] students = new Students[] {
            new Students("Harry Potter", LocalDate.parse(("1980-07-31"))),
            new Students("Ron Weasley", LocalDate.parse(("1980-03-01"))),
            new Students("Hermione Granger", LocalDate.parse(("1979-09-19"))),
            new Students("Neville Longbottom", LocalDate.parse(("1980-07-30"))) 
        };
		
		for (int i = 0; i < students.length; i++) {
			studentRepo.save(students[i]);
		}

		Courses[] courses = new Courses[] {
            new Courses("Charms", "CH104", "In this class, you will learn spells concerned with giving an object new and unexpected properties."),
            new Courses("Defence Against the Dark Arts", "DADA", "In this class, you will learn defensive techniques against the dark arts."),
            new Courses("Herbology", "HB311", "In this class, you will learn the study of magical plants and how to take care of, utilise and combat them."),
            new Courses("History of Magic", "HIS393", "In this class, you will learn about significant events in wizarding history."),
            new Courses("Potions", "POT102", "In this class, you will learn correct mixing and stirring of ingredients to create mixtures with magical effects."),
            new Courses("Transfiguration", "TR442", "In this class, you will learn the art of changing the form or appearance of an object.")
        };

		for (int i = 0; i < courses.length; i++) {
			courseRepo.save(courses[i]);
		}
 		
	}
}
