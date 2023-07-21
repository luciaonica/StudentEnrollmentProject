package com.genspark.controller;

import com.genspark.Dto.CourseDTO;
import com.genspark.Dto.LoginDTO;
import com.genspark.Dto.UserDTO;
import com.genspark.entity.Course;
import com.genspark.entity.User;
import com.genspark.response.EnrollmentResponse;
import com.genspark.response.LoginResponse;
import com.genspark.service.CourseService;
import com.genspark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @PostMapping(path="/saveuser")
    public String saveUser(@RequestBody UserDTO userDTO) {
        String id = userService.addUser(userDTO);

        return id;
    }

    @PostMapping(path="/savecourse")
    public String saveCourse(@RequestBody CourseDTO courseDTO) {
        String id = courseService.addCourse(courseDTO);

        return "course was saved";
    }

    @GetMapping(path = "/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping(path = "/students")
    public List<User> getAllStudents() {
        return userService.getAllStudents();
    }

    @GetMapping(path = "/teachers")
    public List<User> getAllTeachers() {
        return userService.getAllTeachers();
    }

    @GetMapping(path = "/courses/{courseId}")
    public Course getCourseById(@PathVariable String courseId){
        return courseService.getCourseById(Integer.parseInt(courseId));
    }

    @GetMapping(path = "/users/{userId}")
    public User getUserById(@PathVariable String userId){
        return userService.getUserById(Integer.parseInt(userId));
    }

    @GetMapping(path = "/coursesbystudent/{studentId}")
    public List<Course> getCoursesByStudentId(@PathVariable int studentId) {
        return courseService.getCoursesByStudentId(studentId);
    }

    @GetMapping(path = "/studentsbycourse/{courseId}")
    public List<User> getStudentsByCourseId(@PathVariable int courseId) {
        return courseService.getStudentsByCourseId(courseId);
    }

    @PutMapping(path="/savecourse")
    public Course updateCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.updateCourse(courseDTO);
    }

    @PutMapping(path="/saveuser")
    public User updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @PutMapping(path="/updateaccount")
    public User updateAccount(@RequestBody UserDTO userDTO) {
        return userService.updateAccount(userDTO);
    }

    @DeleteMapping("/deletecourse/{courseId}")
    public String deleteCourse(@PathVariable int courseId) {
        return courseService.deleteCourse(courseId);
    }

    @DeleteMapping("/deletestudent/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        return userService.deleteStudent(studentId);
    }

    @DeleteMapping("/deletecoursestudent/{courseId}/{studentId}")
    public String deleteCourseStudent(@PathVariable("courseId") int courseId, @PathVariable("studentId") int studentId) {
        return courseService.deleteCourseStudent(courseId, studentId);
    }

    @PostMapping(path="/savecoursestudent/{courseId}/{studentId}")
    public String saveCourseStudent(@PathVariable("courseId") int courseId, @PathVariable("studentId") int studentId) {
        return courseService.addCourseAndStudent(courseId, studentId);
    }

    @DeleteMapping("/deleteuser/{userId}")
    public String deleteUser(@PathVariable int userId) {
        return courseService.deleteUser(userId);
    }

    @GetMapping(path="/isstudentenrolled/{courseId}/{studentId}")
   // public String studentEnrollment(@PathVariable("courseId") int courseId, @PathVariable("studentId") int studentId){
   //     return courseService.studentEnrollment(courseId, studentId);
   // }

    public ResponseEntity<?> studentEnrollment(@PathVariable("courseId") int courseId, @PathVariable("studentId") int studentId) {
        EnrollmentResponse response = courseService.studentEnrollment(courseId, studentId);
        return ResponseEntity.ok(response);
    }
}
