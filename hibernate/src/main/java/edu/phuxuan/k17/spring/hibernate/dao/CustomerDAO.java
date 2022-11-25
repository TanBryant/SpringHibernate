package edu.phuxuan.k17.spring.hibernate.dao;

import java.util.List;

import edu.phuxuan.k17.spring.hibernate.entity.Customer;



public interface CustomerDAO {

    public List < Customer > getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);
}
