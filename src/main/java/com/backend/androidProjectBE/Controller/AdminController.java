package com.backend.androidProjectBE.Controller;

import com.backend.androidProjectBE.Entity.LicenseVehicles;
import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Service.UserService;
import com.backend.androidProjectBE.dto.ImgLicense;
import com.backend.androidProjectBE.dto.UserDTO;
import com.backend.androidProjectBE.dto.UserStatus;
import com.backend.androidProjectBE.model.FileInfo;
import com.backend.androidProjectBE.model.ResponseMessage;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int id) {
        UserDTO user = userService.loadUsers(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        Users updatedUser = userService.updateUser(id, userDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @GetMapping("/users/{id}/uploadStatus")
    public ResponseEntity<UserStatus> uploadStatusLicense(@PathVariable int id) {
        UserStatus status = userService.uploadLicenseStatus(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping("/users/{id}/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable int id) {
        String message = "";
        try {
            userService.save(id, file);

        message = "Uploaded the file successfully: " + file.getOriginalFilename();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
        message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
// admin
    @GetMapping("/admin/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = userService.loadAll().map(path -> {
        String filename = path.getFileName().toString();
        String url = MvcUriComponentsBuilder
            .fromMethodName(UserController.class, "getFile", path.getFileName().toString()).build().toString();

        return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }
//admin
    @GetMapping("/users/{id}/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = userService.load(filename);
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
    @GetMapping("/admin/getAllUser")
    public ResponseEntity<?> getAllUser() {
        return new ResponseEntity<>(userServiceImp.getAllUsers(), HttpStatus.OK);
    }
}


