package com.ltphuc.k18.repositorynodb.repository;

import java.util.List;

import com.ltphuc.k18.repositorynodb.model.Product;



public interface ProductRepository {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);
    
    void update(Product product);
    
    void delete(int id);
}
