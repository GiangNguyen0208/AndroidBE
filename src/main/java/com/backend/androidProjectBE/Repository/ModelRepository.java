package com.backend.androidProjectBE.Repository;

import com.backend.androidProjectBE.Entity.Models;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Models, Integer> {
    Models findById(int id);
}
