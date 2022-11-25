package com.pxu.k18.BASE1.service;

import java.util.List;

import com.pxu.k18.BASE1.entity.CustomerType;
import com.pxu.k18.BASE1.exception.ResourceNotFoundException;

public interface CustomerTypeService {

    public List < CustomerType > getCustomerTypes();

    public void saveCustomerType(CustomerType customerType);

    public CustomerType getCustomerType(int theId) throws ResourceNotFoundException;

    public void deleteCustomerType(int theId) throws ResourceNotFoundException;
}