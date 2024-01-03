package com.project.musicapp.controllers;

import com.project.musicapp.models.LogModel;
import com.project.musicapp.repositories.LogRepository;
import com.project.musicapp.models.ProductModel;
import com.project.musicapp.repositories.ProductModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/product")
public class MarketController {
    @Autowired
    ProductModelRepository ProductRepository;

    @Autowired
    LogRepository Log;

    LogModel Date = new LogModel();

    @PostMapping(path="/create/{userId}")
    public String createProduct(
                                @RequestParam(name="description") String description,
                                @RequestParam(name="price") double price,
                                @RequestParam(name="musicId") int musicId,
                                @PathVariable int userId,
                                @RequestParam(name="listproduct")String listProduct){

        ProductModel product = new ProductModel(description,price,musicId,userId,listProduct);

        ProductRepository.save(product);
        LogModel logData = new LogModel("product/create/{userid}" , "Product" , Date.getTimeNow() );
        Log.save(logData);
        return "Product Created";

    }

    @GetMapping(path="/MarketFeed")
    public Iterable<ProductModel> showAllProducts(){

        return ProductRepository.findAll();

    }

    @DeleteMapping(path="/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        ProductRepository.deleteById(id);
        return "Produt Deleted";
    }


}
