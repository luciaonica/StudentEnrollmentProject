package com.genspark.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id", length = 45)
    private int courseId;
    private String name;
    private String description;
    @Column(name="max_students")
    private int maxNumberOfStudents;

    private String teacher;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<UserCourse> studentCourses = new ArrayList<>();

    public Course(int courseId, String name, String description, int maxNumberOfStudents, String teacher) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.teacher = teacher;
    }
}
