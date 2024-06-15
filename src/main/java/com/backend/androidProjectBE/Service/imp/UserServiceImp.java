package com.backend.androidProjectBE.Service.imp;

import org.springframework.web.multipart.MultipartFile;
import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.dto.UserDTO;
import com.backend.androidProjectBE.dto.UserStatus;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;

public interface UserServiceImp {
    List<UserDTO> getAllUsers();
    UserDTO updateUser(int id, UserDTO userDTO);
    UserDTO loadUsers(int id);
    UserStatus uploadLicenseStatus(int id);
    Users changePassword(int id, UserDTO userDTO);
    void init();
    void save(int userId, MultipartFile file);
    Resource load(String filename);
    void deleteAll();
    Stream<Path> loadAll();
}