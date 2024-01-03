package com.project.musicapp.repositories;

import com.project.musicapp.models.ForumChatModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumChatRepository extends CrudRepository<ForumChatModel, Integer> {
}
