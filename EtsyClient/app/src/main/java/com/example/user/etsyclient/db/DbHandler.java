package com.example.user.etsyclient.db;

import com.example.user.etsyclient.model.Image;
import com.example.user.etsyclient.model.Product;

import java.util.List;

/**
 * Created by User on 02.01.2017.
 */

public interface DbHandler {
    List<Product> getAllProducts();

    long addProduct(Product product);

    boolean isFavorite(Product product);

    List<Image> getImages(Product product);
}