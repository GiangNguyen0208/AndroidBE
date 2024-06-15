package com.backend.androidProjectBE.Controller;

import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Service.imp.UserServiceImp;
import com.backend.androidProjectBE.dto.UserDTO;
import com.backend.androidProjectBE.dto.UserStatus;
import com.backend.androidProjectBE.model.FileInfo;
import com.backend.androidProjectBE.model.ResponseMessage;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.User;
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
    private UserServiceImp userServiceImp;

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int id) {
        UserDTO user = userServiceImp.loadUsers(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userServiceImp.updateUser(id, userDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @PutMapping("/users/changesPass/{id}")
    public ResponseEntity<Users> changePass(@PathVariable int id, @RequestBody UserDTO userDTO) {
        Users changePass = userServiceImp.changePassword(id, userDTO);
        return new ResponseEntity<>(changePass, HttpStatus.OK);
    }

    @GetMapping("/users/{id}/uploadStatus")
    public ResponseEntity<UserStatus> uploadStatusLicense(@PathVariable int id) {
        UserStatus status = userServiceImp.uploadLicenseStatus(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping("/users/{id}/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("image") MultipartFile file, @PathVariable int id) {
        String message = "";
        try {
            userServiceImp.save(id, file);

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
        List<FileInfo> fileInfos = userServiceImp.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(UserController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }
    //user
    @GetMapping("/users/{id}/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable int id, @PathVariable String filename) {
        Resource file = userServiceImp.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUserList() {
        return new ResponseEntity<>(userServiceImp.getAllUsers(), HttpStatus.OK);
    }

}


