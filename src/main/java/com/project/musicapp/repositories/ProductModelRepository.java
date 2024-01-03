package com.project.musicapp.repositories;

import com.project.musicapp.models.ProductModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductModelRepository extends CrudRepository<ProductModel, Integer> {
}
