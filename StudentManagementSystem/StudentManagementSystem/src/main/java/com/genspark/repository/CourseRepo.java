package com.genspark.repository;

import com.genspark.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableJpaRepositories
public interface CourseRepo extends JpaRepository<Course, Integer> {

    @Query(value = "SELECT c.* FROM course c INNER JOIN user_course uc ON c.course_id = uc.course_id WHERE uc.user_id = :studentId", nativeQuery = true)
    List<Course> findByStudentId(@Param("studentId") int studentId);

    @Query(value = "DELETE FROM user_course uc WHERE uc.user_id = ?2 and uc.course_id =?1", nativeQuery = true)
    @Modifying
    void deleteCourseAndStudentById(int courseId, int studentId);

    @Query(value = "insert into user_course(course_id, user_id) values(?1,?2)", nativeQuery = true)
    @Modifying
    void saveCourseAndStudent(int courseId, int studentId);

    @Query(value = "SELECT COUNT(*) AS count FROM user_course WHERE user_id = ?2 AND course_id = ?1", nativeQuery = true)
    int isStudentAlreadyEnrolled(int courseId, int studentId);
}
