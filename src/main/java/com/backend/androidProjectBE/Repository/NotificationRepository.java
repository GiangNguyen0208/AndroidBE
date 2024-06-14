package com.backend.androidProjectBE.Repository;

import com.backend.androidProjectBE.Entity.Anounces;
import com.backend.androidProjectBE.Entity.Messages;
import com.backend.androidProjectBE.Entity.Users;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Anounces, Integer> {
    @Override
    <S extends Anounces> S save(S entity);
    @Override
    @NotNull
    List<Anounces> findAll();
}
