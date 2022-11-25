package com.pxu.k18.BASE1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pxu.k18.BASE1.entity.Customer; 
import com.pxu.k18.BASE1.exception.ResourceNotFoundException;
import com.pxu.k18.BASE1.repository.CustomerRepository; 

 
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public List < Customer > getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
    	customerRepository.save(customer);
    }

     

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
    	customerRepository.deleteById(theId);
    }

	@Override
	public Customer getCustomer(int id) throws ResourceNotFoundException {
	 
		return customerRepository.findById(id).get();
	}
}