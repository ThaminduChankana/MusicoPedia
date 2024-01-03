package com.project.musicapp.repositories;

import com.project.musicapp.models.CommentsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends CrudRepository<CommentsModel,Integer> {
}
