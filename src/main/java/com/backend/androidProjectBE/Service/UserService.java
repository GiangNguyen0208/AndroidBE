package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.LicenseVehicles;
import com.backend.androidProjectBE.Entity.Roles;
import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Repository.LicenseVehiclesRepository;
import com.backend.androidProjectBE.Repository.RoleRepository;
import com.backend.androidProjectBE.Repository.UserRepository;
import com.backend.androidProjectBE.Service.imp.RolesServiceImp;
import com.backend.androidProjectBE.Service.imp.UserServiceImp;
import com.backend.androidProjectBE.dto.RoleDTO;
import com.backend.androidProjectBE.dto.UserDTO;
import com.backend.androidProjectBE.dto.UserStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService implements UserServiceImp, RolesServiceImp {
    
    private final Path root = Paths.get("uploads");

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LicenseVehiclesRepository licenseVehiclesRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void init() {
      try {
        Files.createDirectories(root);
      } catch (IOException e) {
        throw new RuntimeException("Could not initialize folder for upload!");
      }
    }

    @Override
    public UserDTO updateUser(int id, UserDTO userDTO) {
        Optional<Users> userOptional = Optional.ofNullable(userRepository.findById(id));
        if (!userOptional.isPresent()) {
            throw new RuntimeException("User not found");
        }
        Users user = userOptional.get();
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        user.setPassword(user.getPassword());
        user.setGender(userDTO.getGender());
        user.setPhone(userDTO.getPhone());
        user.setBirthDay(userDTO.getBirthDay());
        user.setIsAdminMessage(userDTO.getIsAdminMessage());
        Optional<Roles> r = roleRepository.findByName(userDTO.getRoleName());
        if (r.isPresent())
            user.setRoles(r.get());
        Users u = userRepository.save(user);
        return convertToDTO(u);
    }

    @Override
    public UserDTO loadUsers(int id) {
        Optional<Users> userOptional = Optional.ofNullable(userRepository.findById(id));
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            UserDTO userResponseDTO = new UserDTO();
            userResponseDTO.setId(user.getId());
            userResponseDTO.setFirstname(user.getFirstname());
            userResponseDTO.setLastname(user.getLastname());
            userResponseDTO.setEmail(user.getEmail());
            userResponseDTO.setPassword(user.getPassword());
            userResponseDTO.setPhone(user.getPhone());
            userResponseDTO.setGender(user.getGender());
            userResponseDTO.setBirthDay(user.getBirthDay());
            userResponseDTO.setRoleName(user.getRoles().getName());
            userResponseDTO.setIsAdminMessage(user.getIsAdminMessage());
            return userResponseDTO;
        } else {
            throw new RuntimeException("User not found");
    }
}

    @Override
    public UserStatus uploadLicenseStatus(int id) {
        Optional<Users> userOptional = Optional.ofNullable(userRepository.findById(id));
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            UserStatus userResponseStatus = new UserStatus();
            userResponseStatus.setStatus(user.getStatus());
            
            return userResponseStatus;
        } else {
            throw new RuntimeException("The Bug");
    }
    }

    @Override
    public Users changePassword(int id, UserDTO userDTO) {
        Optional<Users> userOptional = Optional.ofNullable(userRepository.findById(id));
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        if(!userDTO.getPassword().equals(userOptional.get().getPassword())) {
            throw new RuntimeException("Passwords do not match");
        }
            Users user = userOptional.get();
            user.setPassword(userDTO.getNewPassword());

        return userRepository.save(user);
    }

    @Override
    public void save(int userId, MultipartFile file) {
        Optional<Users> userOptional = Optional.ofNullable(userRepository.findById(userId));
        if (userOptional.isPresent()) {
            try {
                Users user = userOptional.get();
                user.setStatus(true);
    
                Path filePath = this.root.resolve(file.getOriginalFilename());
                Files.copy(file.getInputStream(), filePath);
    
                LicenseVehicles license = new LicenseVehicles();
                license.setImgLicense(filePath.toString());
                license.setUsers(user);

                licenseVehiclesRepository.save(license);
                userRepository.save(user);
    
            } catch (Exception e) {
                if (e instanceof FileAlreadyExistsException) {
                    throw new RuntimeException("A file of that name already exists.");
                }
                throw new RuntimeException(e.getMessage());
            }
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }
    

  @Override
  public Resource load(String filename) {
    try {
      Path file = root.resolve(filename);
      Resource resource = new UrlResource(file.toUri());

      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("Could not read the file!");
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("Error: " + e.getMessage());
    }
  }

  @Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(root.toFile());
  }

  @Override
  public Stream<Path> loadAll() {
    try {
      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
      
    } catch (IOException e) {
      throw new RuntimeException("Could not load the files!");
    }
  }
    public List<RoleDTO> getRoles() {
        return roleRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private RoleDTO convertToDTO(Roles role) {
        RoleDTO result = RoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .dateCreate(role.getDateCreate()).build();
        return result;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    private UserDTO convertToDTO(Users user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setGender(user.getGender());
        userDTO.setPhone(user.getPhone());
        userDTO.setEmail(user.getEmail());
        userDTO.setBirthDay(user.getBirthDay());
        userDTO.setRoleName(user.getRoles().getName());
        userDTO.setIsAdminMessage(user.getIsAdminMessage());
        return userDTO;
    }
}
