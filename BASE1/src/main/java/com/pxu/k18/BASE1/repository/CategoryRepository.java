package com.pxu.k18.BASE1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pxu.k18.BASE1.entity.Category;
 

 

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
