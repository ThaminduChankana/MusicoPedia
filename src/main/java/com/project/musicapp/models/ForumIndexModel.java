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
@Table(name="ForumIndex")
public class ForumIndexModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String ForumName;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ForumID;

    private String ForumDescription;

    private int userId;

    public ForumIndexModel(String forumName, int forumID, String forumDescription, int userId) {
        ForumName = forumName;
        ForumID = forumID;
        ForumDescription = forumDescription;
        this.userId = userId;
    }
}
