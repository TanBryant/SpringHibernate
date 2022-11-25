package com.pxu.k18.BASE1.service;

import java.util.List;

import com.pxu.k18.BASE1.entity.Product; 
import com.pxu.k18.BASE1.exception.ResourceNotFoundException;

public interface ProductService {

    public List < Product > getProducts();

    public void saveProduct(Product product);

    public Product getProduct(int theId) throws ResourceNotFoundException;

    public void deleteProduct(int theId) throws ResourceNotFoundException;
}