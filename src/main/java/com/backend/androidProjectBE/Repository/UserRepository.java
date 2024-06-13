package com.backend.androidProjectBE.Repository;

import com.backend.androidProjectBE.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findById(int id);
    Users findByUsername(String username);
    Users findByEmail(String email);
    List<Users> findByIsAdminMessageTrue();
}
