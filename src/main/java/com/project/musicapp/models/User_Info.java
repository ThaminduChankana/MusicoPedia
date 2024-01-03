package com.project.musicapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="User_Info")
public class User_Info {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public User_Info(int id, String photoURL, String favoritesMusics, String gender, String phone, String instaURL, String twitterURL, String favoritesThings) {
        this.id = id;
        this.photoURL = photoURL;
        this.favoritesMusics = favoritesMusics;
        this.gender = gender;
        this.phone = phone;
        this.instaURL = instaURL;
        this.twitterURL = twitterURL;
        this.favoritesThings = favoritesThings;
    }

    private String photoURL;

    private String favoritesMusics;

    private String gender;

    private String phone;

    private String instaURL;

    private String twitterURL;

    private String favoritesThings;

}
