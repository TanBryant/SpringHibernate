package com.pxu.k18.BASE1.service;

import java.util.List;

import com.pxu.k18.BASE1.entity.Category; 
import com.pxu.k18.BASE1.exception.ResourceNotFoundException;

public interface CategoryService {

    public List < Category > getCategorys();

    public void saveCategory(Category category);

    public Category getCategory(int theId) throws ResourceNotFoundException;

    public void deleteCategory(int theId) throws ResourceNotFoundException;
}