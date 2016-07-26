package com.example.repository;

import com.example.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


/**
 * User Repository.
 */
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
}
