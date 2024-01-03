package com.project.musicapp.repositories;

import com.project.musicapp.models.ForumIndexModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumIndexRepository extends CrudRepository<ForumIndexModel, Integer> {
}
