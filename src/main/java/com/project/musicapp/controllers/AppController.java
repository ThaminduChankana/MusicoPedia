package com.project.musicapp.controllers;

import com.project.musicapp.models.*;
import com.project.musicapp.algorithm.algorithmBlender;
import com.project.musicapp.repositories.CommentsRepository;
import com.project.musicapp.repositories.LogRepository;
import com.project.musicapp.repositories.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/app")
public class AppController {
    @Autowired
    MusicRepository musicRepo;
    @Autowired
    LogRepository Log;

    LogModel Date = new LogModel();
    @Autowired
    CommentsRepository CommentsRepo;
    algorithmBlender ab = new algorithmBlender();
    @GetMapping("/feed")
    public  Map<String, Integer> showMusics(){
        Iterable<MusicModel> listMusic = musicRepo.findAll();

        return ab.algorithmCalc(listMusic);
    }


    @PostMapping(path="/like/{id}")
    public String LikeMusicById(@PathVariable int id) {
        MusicModel musicToUpdate = musicRepo.findById(id);
        int numberLikes = musicToUpdate.getNumberOfLikes();
        musicToUpdate.setNumberOfLikes(numberLikes + 1);
        musicRepo.save(musicToUpdate);
        LogModel logData = new LogModel("app/like/{id}" , "App" , Date.getTimeNow() );
        Log.save(logData);
        return "Music Changed!";
    }

    @PostMapping(path="/comment/{id}")
    public String CommentMusicById(@PathVariable int id) {
        MusicModel musicToUpdate = musicRepo.findById(id);
        int numberComments = musicToUpdate.getNumberOfComents();
        musicToUpdate.setNumberOfComents(numberComments + 1);
        musicRepo.save(musicToUpdate);
        LogModel logData = new LogModel("app/comment/{id}" , "App" , Date.getTimeNow() );
        Log.save(logData);
        return "Music Changed!";
    }

    @PostMapping(path="/createComment/{id}")
    public String createComment(@PathVariable int id,
                                @RequestParam(name="Comment")String Comment){
        CommentsModel comment = new CommentsModel(Comment , id );
        CommentsRepo.save(comment);
        LogModel logData = new LogModel("app/createComment/{id}" , "App" , Date.getTimeNow() );
        Log.save(logData);
        return Comment;
    }

    @GetMapping(path="/getComments/{MusicId}")
    public String getCommentsByMusicId(@PathVariable int MusicId){

        return "Comment";
    }


}
