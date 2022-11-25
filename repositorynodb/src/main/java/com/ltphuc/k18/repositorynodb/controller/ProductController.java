package com.ltphuc.k18.repositorynodb.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ltphuc.k18.repositorynodb.model.Product;
import com.ltphuc.k18.repositorynodb.service.ProductService;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping("/products")
    public ModelAndView list(){
        System.out.print(this.getClass().getClassLoader().getResourceAsStream("repositorynodb.properties"));
        List<Product> products = this.productService.findAll();
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView createProduct(@ModelAttribute("product") Product product){
        int randomId = (int)(Math.random() * 10000);
        product.setId(randomId);//For demo purpose only
        this.productService.save(product);

        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "New product was created");
        return modelAndView;
    }
    
    @GetMapping(value="/edit")
    public ModelAndView showEditForm(@RequestParam("id") Integer productId){
    	Product product = this.productService.findById(productId);
        ModelAndView modelAndView = new ModelAndView("product/edit");
        modelAndView.addObject("product", product);
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView updateProduct(@ModelAttribute("product") Product product){
        //For demo purpose only

        this.productService.update(product);

        ModelAndView modelAndView = new ModelAndView("product/edit");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "New product was updated");
        return modelAndView;
    }
    @GetMapping(value="/delete")
    public ModelAndView deleteProduct(@RequestParam("id") Integer productId){
    	Product product = this.productService.findById(productId);
    	this.productService.delete(productId);
       // ModelAndView modelAndView = new ModelAndView("product/list");
        //modelAndView.addObject("product", product);
    	 return new ModelAndView("redirect:" +"/products");
    }

    @GetMapping(value = "/view")
    public ModelAndView view(@RequestParam("id") Integer productId){
        Product product = this.productService.findById(productId);
        ModelAndView modelAndView = new ModelAndView("product/view");
        modelAndView.addObject("product", product);
        return modelAndView;
    }
    
    @GetMapping( "/viewpathvariable/{productId}")
    public ModelAndView viewpathvariable(@PathVariable Integer productId){
        Product product = this.productService.findById(productId);
        ModelAndView modelAndView = new ModelAndView("product/view");
        modelAndView.addObject("product", product);
        return modelAndView;
    }
}