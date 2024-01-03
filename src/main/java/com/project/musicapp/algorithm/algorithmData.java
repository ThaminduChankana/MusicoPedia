package com.project.musicapp.algorithm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class algorithmData {

    private int rhythmPoints;

    private boolean black_list;

    private boolean blocked;

    public int rhythmPointsByLike(int likes){
        return likes*10;
    }

    public int rhythmPointsByComments(int comments){
        return comments*15;
    }


}
