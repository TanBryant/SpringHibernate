package com.springmvc.hibernatecrudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.hibernatecrudapp.entity.Customer;
import com.springmvc.hibernatecrudapp.entity.Province;
import com.springmvc.hibernatecrudapp.entity.post.CustomerPostForm;
import com.springmvc.hibernatecrudapp.services.BaseService;

@Controller
@RequestMapping("/customerbase")
public class CustomerController {

   
    @Autowired
    private BaseService<Province> provinceBaseService;
    
    @Autowired
    private BaseService<Customer> customerBaseService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        List < Customer > theCustomers = customerBaseService.getAll();
        theModel.addAttribute("customers", theCustomers);
        return "base-list-customers";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "base-customer-form";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") CustomerPostForm customer,Model theModel) {
        System.out.println("getAddress : " + customer.getAddress());
        System.out.println("getEmail : " + customer.getEmail());
        System.out.println("getFirstName : " + customer.getFirstName());
        System.out.println("getId : " + customer.getId());
        System.out.println("getLastName : " + customer.getLastName());
        System.out.println("getTel : " + customer.getTel());
        System.out.println("getProvince : " + customer.getProvince());     
        
        
        
        Province province= provinceBaseService.get(customer.getProvince());
        Customer cusSave = new Customer(customer, province);
        
        customerBaseService.save(cusSave);
        
        
        
        return "redirect:/customerbase/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
        Model theModel) {
        Customer theCustomer = customerBaseService.get(theId);
        theModel.addAttribute("customer", theCustomer);
        return "base-customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {
        customerBaseService.delete(theId);
        return "redirect:/customerbase/list";
    }
    
    @ModelAttribute("provinces")
    public List<Province> provinces(){
            return provinceBaseService.getAll();
    }
}
