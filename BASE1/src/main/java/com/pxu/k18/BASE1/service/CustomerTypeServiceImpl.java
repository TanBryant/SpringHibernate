package com.pxu.k18.BASE1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pxu.k18.BASE1.entity.Category;
import com.pxu.k18.BASE1.entity.CustomerType;
import com.pxu.k18.BASE1.exception.ResourceNotFoundException;
import com.pxu.k18.BASE1.repository.CategoryRepository;
import com.pxu.k18.BASE1.repository.CustomerTypeRepository;

 
@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {

    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    @Transactional
    public List < CustomerType > getCustomerTypes() {
        return customerTypeRepository.findAll();
    }

    @Override
    @Transactional
    public void saveCustomerType(CustomerType customerType) {
    	customerTypeRepository.save(customerType);
    }

     

    @Override
    @Transactional
    public void deleteCustomerType(int theId) {
    	customerTypeRepository.deleteById(theId);
    }

	@Override
	public CustomerType getCustomerType(int id) throws ResourceNotFoundException {
	 
		return customerTypeRepository.findById(id).get();
	}
}