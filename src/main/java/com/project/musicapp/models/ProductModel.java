package com.project.musicapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    private String description;

    private double price;

    private int MusicId;

    private int userId;

    public ProductModel( String description,
                        double price, int musicId, int userId,
                        String listProduct) {

        this.description = description;
        this.price = price;
        this.MusicId = musicId;
        this.userId = userId;
        this.listProduct = listProduct;
    }

    private String listProduct;

}
