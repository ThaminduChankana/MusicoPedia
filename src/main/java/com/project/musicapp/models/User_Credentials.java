package com.project.musicapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="User_Credentials")
public class User_Credentials {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;

    private String username;

    public User_Credentials( String email, String password, String username){

        this.email = email;
        this.password = password;
        this.username = username;

    }

}
