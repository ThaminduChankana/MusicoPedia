package com.project.musicapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class LogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int logId;

    private String command;

    private String classe;

    private LocalDateTime data;

    public LogModel(String command, String classe, LocalDateTime data){
        this.command =command;
        this.classe =classe;
        this.data =data;
    }

    public LocalDateTime getTimeNow(){
        return LocalDateTime.now();
    }

}


