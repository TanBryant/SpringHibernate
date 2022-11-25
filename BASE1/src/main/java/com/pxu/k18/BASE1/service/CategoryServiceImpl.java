package com.pxu.k18.BASE1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pxu.k18.BASE1.entity.Category; 
import com.pxu.k18.BASE1.exception.ResourceNotFoundException;
import com.pxu.k18.BASE1.repository.CategoryRepository;

 
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public List < Category > getCategorys() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public void saveCategory(Category category) {
    	categoryRepository.save(category);
    }

     

    @Override
    @Transactional
    public void deleteCategory(int theId) {
    	categoryRepository.deleteById(theId);
    }

	@Override
	public Category getCategory(int id) throws ResourceNotFoundException {
	 
		return categoryRepository.findById(id).get();
	}
}