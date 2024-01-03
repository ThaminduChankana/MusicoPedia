package com.project.musicapp.algorithm;

import com.project.musicapp.models.MusicModel;

import java.util.HashMap;
import java.util.Map;

public class algorithmBlender extends algorithmData {
    algorithmData AD = new algorithmData();

    public Map<String, Integer> algorithmCalc(Iterable<MusicModel> listMusics){
        HashMap<String, Integer> HashAlgorithm = new HashMap<>();
        for(MusicModel itemMusic : listMusics){
            int nlikes = itemMusic.getNumberOfLikes();
            int ncomments = itemMusic.getNumberOfComents();

            int likesPoints = AD.rhythmPointsByLike(nlikes);
            int commentsPoints = AD.rhythmPointsByComments(ncomments);

            int rhythmPoints = likesPoints + commentsPoints;

            String musicName = itemMusic.getMusicName();

            HashAlgorithm.put(musicName , rhythmPoints );

        }

        return HashAlgorithm;

    }


}
