package com.project.musicapp.controllers;

import com.project.musicapp.models.*;
import com.project.musicapp.repositories.LogRepository;
import com.project.musicapp.repositories.UserAccRepository;
import com.project.musicapp.repositories.UserInfoRepository;
import com.project.musicapp.security.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@RequestMapping(path="/auth")
public class AuthController {
    AuthUtil JwtToken;
    @Autowired
    UserAccRepository UserAccRepo;
    @Autowired
    UserInfoRepository UserInfoRepo;
    @Autowired
    LogRepository Log;
    LogModel Date = new LogModel();


    @PostMapping(path = "/register")
    public String createAuser(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "confirmpassword") String confirmPassword,
            @RequestParam(name = "username") String username) {

        if (!Objects.equals(password, confirmPassword)) {
            return "Passwords don't match!";
        } else {
            User_Credentials userCred = new User_Credentials(email, password, username);
            UserAccRepo.save(userCred);

            LogModel logData = new LogModel("createUser01", "User", Date.getTimeNow());
            Log.save(logData);
            return "Sucess!";
        }

    }


    @GetMapping(path = "/login")
    public String loginUser(@RequestParam(name = "email") String email,
                              @RequestParam(name = "password") String password) {
        User_Credentials user = UserAccRepo.findUserByEmail(email);
        if(user != null){
            if(Objects.equals(user.getPassword(), password)){

                return "Login Success!";
            }else{
                return "Incorrect password!";
            }
        }else{
            return "Email not found!";
        }

    }
    }

