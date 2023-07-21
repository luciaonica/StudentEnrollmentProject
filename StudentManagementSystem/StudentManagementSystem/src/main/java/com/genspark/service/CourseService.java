package com.genspark.service;

import com.genspark.Dto.CourseDTO;
import com.genspark.entity.Course;
import com.genspark.entity.User;
import com.genspark.response.EnrollmentResponse;

import java.util.List;

public interface CourseService {

    String addCourse(CourseDTO courseDTO);
    List<Course> getAllCourses();
    Course updateCourse(CourseDTO courseDTO);
    String deleteCourse(int courseId);

    List<Course> getCoursesByStudentId(int studentId);

    List<User> getStudentsByCourseId(int courseId);

    String deleteCourseStudent(int courseId, int studentId);

    String deleteUser(int userId);

    String addCourseAndStudent(int courseId, int studentId);

    Course getCourseById(int courseId);

    EnrollmentResponse studentEnrollment(int courseId, int studentId);
}
