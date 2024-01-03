package com.project.musicapp.repositories;

import com.project.musicapp.models.User_Info;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends CrudRepository<User_Info, Integer> {
}
