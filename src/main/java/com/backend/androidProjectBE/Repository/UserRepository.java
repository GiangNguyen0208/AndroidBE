package com.backend.androidProjectBE.Repository;

import com.backend.androidProjectBE.Entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
        Users findByUsername(String username);
        Users findByEmail(String email);
//        @Query(value = "SELECT email FROM users WHERE email = :email" , nativeQuery = true)
//        String checkUserEmail(@Param("email") String email);
//
//        @Query(value = "SELECT password FROM users Where email = :email", nativeQuery = true)
//        String checkUserPasswordByEmail(@Param("email") String email);
//
//        @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
//        Users getUserDetail(@Param("email") String email);
}
