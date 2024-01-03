package com.project.musicapp.controllers;

import com.project.musicapp.models.LogModel;
import com.project.musicapp.repositories.LogRepository;
import com.project.musicapp.models.MusicModel;
import com.project.musicapp.repositories.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    LogRepository Log;
    @Autowired
    MusicRepository MusicRepo;

    LogModel Date = new LogModel();

    @PostMapping(path="/create/{Userid}")
    public String createMusic(@RequestParam(name="MusicDescription") String MusicDescription,
                       @RequestParam(name="MusicName") String MusicName,
                       @RequestParam(name="Music") String Music, @PathVariable int Userid
                       ){
        MusicModel newMusic = new MusicModel(Userid , MusicName , Music , MusicDescription );
        MusicRepo.save(newMusic);
        return "Operation Completed";
    }

    @DeleteMapping(path="/delete/{id}")
    public String deleteMusic(@PathVariable int id){
            MusicRepo.deleteById(id);
            return "Deleted";

    }


    @GetMapping(path="/findMusicBy/{id}")
    public MusicModel findMusicBy(@PathVariable int id){
        return MusicRepo.findById(id);
    }



    @PostMapping(path="/update/{id}")
    public String updateMusicById(@PathVariable int id ,
                                  @RequestParam(name="MusicName") String MusicName,
                                  @RequestParam(name="MusicDescription") String MusicDescription,
                                  @RequestParam(name="Music") String Music
                                  ){
        MusicModel musicToUpdate = MusicRepo.findById(id);
        musicToUpdate.setMusic(Music);
        musicToUpdate.setMusicDescription(MusicDescription);
        musicToUpdate.setMusicName(MusicName);
        MusicRepo.save(musicToUpdate);
        return "Music Changed!";
    }


}
