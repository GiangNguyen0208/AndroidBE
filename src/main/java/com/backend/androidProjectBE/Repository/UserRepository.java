package com.backend.androidProjectBE.Repository;

import com.backend.androidProjectBE.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findById(int id);
    Users findByUsername(String username);
    Users findByEmail(String email);
}
