package com.backend.androidProjectBE.Service.imp;

import org.springframework.web.multipart.MultipartFile;
import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.dto.UserDTO;
import com.backend.androidProjectBE.dto.UserStatus;
import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;

public interface UserServiceImp {
    Users updateUser(int id, UserDTO userDTO);
    UserDTO loadUsers(int id);
    UserStatus uploadLicenseStatus(int id);
    public void init();
    public void save(int userId, MultipartFile file);
    public Resource load(String filename);
    public void deleteAll();
    public Stream<Path> loadAll();
}
