package com.project.musicapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="MusicModel")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class MusicModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int MusicId;

    private String MusicName;

    private String Music;

    private String MusicDescription;

    private int NumberOfLikes;

    private int NumberOfComents;

    private int NumberOfLoves;

    public MusicModel(int MusicId , String MusicName , String Music , String MusicDescription){
        this.MusicId = MusicId;
        this.Music = Music;
        this.MusicDescription = MusicDescription;
        this.MusicName = MusicName;

    }

}
