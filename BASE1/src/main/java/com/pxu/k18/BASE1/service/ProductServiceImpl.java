package com.pxu.k18.BASE1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pxu.k18.BASE1.entity.Product; 
import com.pxu.k18.BASE1.exception.ResourceNotFoundException;
import com.pxu.k18.BASE1.repository.ProductRepository;

 
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public List < Product > getProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public void saveProduct(Product Product) {
    	productRepository.save(Product);
    }

     

    @Override
    @Transactional
    public void deleteProduct(int theId) {
    	productRepository.deleteById(theId);
    }

	@Override
	public Product getProduct(int id) throws ResourceNotFoundException {
	 
		return productRepository.findById(id).get();
	}
}