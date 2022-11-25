package com.springmvc.hibernatecrudapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.hibernatecrudapp.entity.Customer;
import com.springmvc.hibernatecrudapp.repository.BaseRepository;



@Service
public class CustomerBaseService implements BaseService<Customer> {

    
    @Autowired
    private BaseRepository<Customer> customerRepository;
    
    
    public CustomerBaseService() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Customer> getAll() {
        // TODO Auto-generated method stub
        return customerRepository.getAll();
    }

    @Override
    public void save(Customer object) {
        // TODO Auto-generated method stub
        customerRepository.save(object);
    }

    @Override
    public Customer get(int id) {
        // TODO Auto-generated method stub
        return customerRepository.getById(id);
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        customerRepository.deleteById(id);
    }

   
}
