package com.backend.androidProjectBE.Repository;

import com.backend.androidProjectBE.Entity.Messages;
import com.backend.androidProjectBE.Entity.Roles;
import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.dto.MessageDTO;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Messages, Integer> {
    Messages findById(int id);
    List<Messages> findByFromUser(Users users);
    List<Messages> findByToUser(Users users);

    Messages save(Messages message);
}
