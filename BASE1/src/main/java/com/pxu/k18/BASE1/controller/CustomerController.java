package com.pxu.k18.BASE1.controller;

 
import java.util.List;

import javax.management.AttributeNotFoundException;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

 
import com.pxu.k18.BASE1.entity.CustomerType;
import com.pxu.k18.BASE1.entity.Customer;
import com.pxu.k18.BASE1.exception.ResourceNotFoundException;
import com.pxu.k18.BASE1.service.CategoryService;
import com.pxu.k18.BASE1.service.CustomerService;
import com.pxu.k18.BASE1.service.CustomerTypeService;
import com.pxu.k18.BASE1.service.ProductService; 

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService; 
    
    @Autowired
    private CustomerTypeService customerTypeService; 
    
    @ModelAttribute("customerTypes")
    public List<CustomerType> customerTypes(){
    	return customerTypeService.getCustomerTypes();
    }
    
    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        List < Customer > theCustomers = customerService.getCustomers();
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside shoCustomermer-form handler method");
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("customerId") int id,
        Model theModel) throws AttributeNotFoundException, ResourceNotFoundException {
        Customer customer = customerService.getCustomer(id);
        theModel.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) throws ResourceNotFoundException {
        customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }
}