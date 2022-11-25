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

import com.pxu.k18.BASE1.entity.Category;
import com.pxu.k18.BASE1.entity.Product;
import com.pxu.k18.BASE1.exception.ResourceNotFoundException;
import com.pxu.k18.BASE1.service.CategoryService;
import com.pxu.k18.BASE1.service.ProductService; 

@Controller
@RequestMapping("/product")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService; 
    
    @Autowired
    private CategoryService categoryService; 
    
    @ModelAttribute("categorys")
    public List<Category> categorys(){
    	return categoryService.getCategorys();
    }
    
    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        List < Product > theProducts = productService.getProducts();
        theModel.addAttribute("products", theProducts);
        return "list-products";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show Product-form handler method");
        Product theProduct = new Product();
        theModel.addAttribute("product", theProduct);
        return "product-form";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product theProduct) {
        productService.saveProduct(theProduct);
        return "redirect:/product/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("productId") int id,
        Model theModel) throws AttributeNotFoundException, ResourceNotFoundException {
        Product product = productService.getProduct(id);
        theModel.addAttribute("product", product);
        return "product-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("productId") int theId) throws ResourceNotFoundException {
        productService.deleteProduct(theId);
        return "redirect:/product/list";
    }
}