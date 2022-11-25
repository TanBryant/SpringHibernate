package com.pxu.k18.BASE1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 
 
import com.pxu.k18.BASE1.entity.CustomerType;
 

 

@Repository("customerTypeRepository")
public interface CustomerTypeRepository extends JpaRepository<CustomerType, Integer> {

}
