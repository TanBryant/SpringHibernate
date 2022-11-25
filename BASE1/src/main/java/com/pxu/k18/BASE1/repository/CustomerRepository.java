package com.pxu.k18.BASE1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.pxu.k18.BASE1.entity.Customer;
 

 

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
