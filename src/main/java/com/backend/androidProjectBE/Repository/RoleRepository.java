package com.backend.androidProjectBE.Repository;

import com.backend.androidProjectBE.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByName(String name);
}
