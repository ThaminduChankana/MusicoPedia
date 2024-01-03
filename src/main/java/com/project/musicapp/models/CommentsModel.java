package com.project.musicapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Comments")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class CommentsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int MusicID;

    private String Comment;

    private int NumberOfLikes;

    private int NumberOfComments;

    private int NumberOfLoves;

    public CommentsModel(String Comment, int MusicID ){
        this.Comment = Comment;
        this.MusicID = MusicID;
    }

}
