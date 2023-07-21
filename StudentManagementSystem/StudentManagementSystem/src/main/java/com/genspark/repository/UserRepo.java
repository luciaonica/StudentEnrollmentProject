package com.genspark.repository;

import com.genspark.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findOneByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    @Query(value = "SELECT u.* FROM users u INNER JOIN user_course uc ON u.user_id = uc.user_id WHERE uc.course_id = :courseId", nativeQuery = true)
    List<User> findByCourseId(@Param("courseId")int courseId);

    @Query(value = "SELECT u.* FROM users u WHERE u.role = 'STUDENT'", nativeQuery = true)
    List<User> findAllStudents();

    @Query(value = "SELECT u.* FROM users u WHERE u.role = 'TEACHER'", nativeQuery = true)
    List<User> findAllTeachers();
}
