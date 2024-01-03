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
@Table(name="ForumChat")
public class ForumChatModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public ForumChatModel(String message, int userId, int forumId) {
        this.message = message;
        this.userId = userId;
        this.forumId = forumId;
    }

    private String message;

    private int userId;


    private int forumId;
}
