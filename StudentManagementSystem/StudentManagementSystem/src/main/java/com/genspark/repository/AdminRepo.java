package com.genspark.repository;

import com.genspark.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface AdminRepo extends JpaRepository<User, Integer> {
}
