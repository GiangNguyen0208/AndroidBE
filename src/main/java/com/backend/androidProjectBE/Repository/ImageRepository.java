package com.backend.androidProjectBE.Repository;

import com.backend.androidProjectBE.Entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Images, Integer> {
}
