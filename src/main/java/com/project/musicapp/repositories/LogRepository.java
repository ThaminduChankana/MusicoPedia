package com.project.musicapp.repositories;

import com.project.musicapp.models.LogModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<LogModel,Integer> {
}
