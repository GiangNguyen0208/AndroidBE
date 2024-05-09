package com.backend.androidProjectBE.Service;

import com.backend.androidProjectBE.Entity.Users;
import com.backend.androidProjectBE.Repository.UserRepository;
import com.backend.androidProjectBE.Service.imp.LoginServiceImp;
import com.backend.androidProjectBE.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service    // Dua len Bean
public class LoginService implements LoginServiceImp {
    @Autowired
    UserRepository userRepository;
    public List<UserDTO> getAllUser() {
        List<Users> listUser = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (Users u: listUser) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(u.getId());
            userDTO.setEmail(u.getEmail());
            userDTO.setBirthDay(u.getBirthDay());
            userDTO.setPassword(u.getPassword());

            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public boolean checkLogin(String email, String password) {

        List<Users> listUser = userRepository.findByEmailAndPassword(email,password);

        return listUser.size() > 0;
    }

//    @Override
//    public boolean addUser(SignupRequest signupRequest) {
////        Roles roles = new Roles();
////        roles.setId(signupRequest.getId_role());
//
//        Users users = new Users();
//        users.setFullname(signupRequest.getFullname());
//        users.setPassword(signupRequest.getPassword());
//        users.setEmail(signupRequest.getEmail());
////        users.setRoles(roles);
//
//        try {
//            userRepository.save(users);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
}
