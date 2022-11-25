package com.ltphuc.k18.repositorynodb.service;

import java.util.List;

import com.ltphuc.k18.repositorynodb.model.Product;



public interface ProductService {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);
    
    void update(Product product);
    
    void delete(int id);
}
