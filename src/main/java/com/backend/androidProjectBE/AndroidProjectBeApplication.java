package com.backend.androidProjectBE;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.backend.androidProjectBE.Service.imp.UserServiceImp;

import jakarta.annotation.Resource;


@SpringBootApplication
public class AndroidProjectBeApplication implements CommandLineRunner{

	@Resource
  	UserServiceImp userService;

	public static void main(String[] args) {
		SpringApplication.run(AndroidProjectBeApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
//    userService.deleteAll();
		userService.init();
	}

}
