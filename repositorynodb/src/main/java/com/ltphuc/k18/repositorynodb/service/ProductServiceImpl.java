package com.ltphuc.k18.repositorynodb.service;



import org.springframework.beans.factory.annotation.Autowired;

import com.ltphuc.k18.repositorynodb.model.Product;
import com.ltphuc.k18.repositorynodb.repository.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return this.productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }
    @Override
    public void update(Product product) {
        this.productRepository.update(product);
    }
    @Override
    public void delete(int id) {
        this.productRepository.delete(id);
    }
}
