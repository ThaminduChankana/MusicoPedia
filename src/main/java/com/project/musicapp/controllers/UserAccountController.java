package com.project.musicapp.controllers;

import com.project.musicapp.repositories.LogRepository;
import com.project.musicapp.repositories.UserAccRepository;
import com.project.musicapp.models.*;
import com.project.musicapp.repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserAccountController {
    @Autowired
    UserAccRepository UserAccRepo;
    @Autowired
    UserInfoRepository UserInfoRepo;
    @Autowired
    LogRepository Log;
    LogModel Date = new LogModel();

    @GetMapping(path="/findUser")
    public User_Credentials findUserById(@RequestParam(name = "id") String ID){
        int intID = Integer.parseInt(ID);
        return UserAccRepo.findById(intID);
    }
    @DeleteMapping(path="/delete")
    public String deleteUserById(@RequestParam(name="id") String ID){
        int intID = Integer.parseInt(ID);
        UserAccRepo.deleteById(intID);
        return "Account Deleted";
    }
    @PostMapping(path="/update")
    public String updateUserById(@RequestParam(name="id")String id,
                                 @RequestParam(name="email")String email,
                                 @RequestParam(name="password")String password,
                                 @RequestParam(name="username")String username)
    {
        int intID = Integer.parseInt(id);
        User_Credentials userExist = UserAccRepo.findById(intID);
        if(userExist != null){
            userExist.setEmail(email);
            userExist.setPassword(password);
            userExist.setUsername(username);
            UserAccRepo.save(userExist);
            return "Saved User";
        }else{
            return "User not found";
        }

    }


    @PostMapping(path="/createInfo/{userId}")
    public String updateInfoUserBy(@PathVariable int userId,
                                   @RequestParam(name="photoURL")String photoURL,
                                   @RequestParam(name="favoritesMusics")String favoritesMusics,
                                   @RequestParam(name="gender")String gender,
                                   @RequestParam(name="phone")String phone,
                                   @RequestParam(name="instaURL")String instaURL,
                                   @RequestParam(name="twitterURL")String twitterURL,
                                   @RequestParam(name="favoritesThings")String favoritesThings){

        User_Info userInfo = new User_Info(userId , photoURL ,favoritesMusics ,gender ,phone ,instaURL ,twitterURL,favoritesThings );
        UserInfoRepo.save(userInfo);
        return "ATUALIZADO";
    }





}
