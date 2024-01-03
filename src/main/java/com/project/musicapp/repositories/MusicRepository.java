package com.project.musicapp.repositories;

import com.project.musicapp.models.MusicModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends CrudRepository<MusicModel, Integer> {
    MusicModel findById(int id);
}
