package com.pxu.k18.BASE1.service;

import java.util.List;

import com.pxu.k18.BASE1.entity.Customer; 
import com.pxu.k18.BASE1.exception.ResourceNotFoundException;

public interface CustomerService {

    public List < Customer > getCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomer(int theId) throws ResourceNotFoundException;

    public void deleteCustomer(int theId) throws ResourceNotFoundException;
}