package com.codeup.codeupspringblog.controllers;


import com.codeup.codeupspringblog.models.Product;
import com.codeup.codeupspringblog.repositories.ProductsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ProductController {


    private final ProductsRepository productsDao;

    public ProductController(ProductsRepository productsDao){
        this.productsDao = productsDao;
    }




    @GetMapping("/products/create")
    public String returnProductCreateView() {
        return "product/create";
    }

    @PostMapping("/products/create")
    public String insertProduct(@RequestParam String name, @RequestParam int price) {
        System.out.println(name);
        System.out.println(price);
        // create a product object from request params
        // print out the product
        // redirect to the "/"
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String getProductsIndexPage(Model model) {

//        this Update method will allow u to update your page but info must be entered here
//        List<Product> products = new ArrayList<>(Arrays.asList(
//                new Product(1L, "Xbox", 22000),
//                new Product(2L, "3DO", 20),
//                new Product(3L, "CDI", 500)
//        ));

        //using this line below will add seeder info to your html page
        List<Product> products = productsDao.findAll();

        model.addAttribute("products", products);
        return "product/index";
    }

    // =========== USING JPA
    @GetMapping("/delete/products")
    public String deletePosts(){
        productsDao.deleteById(4L);
        return "redirect:/products";
    }


    // this will add hammer to list if you got to "/create/product" url
    @GetMapping("/create/product")
    public String createTheProduct(){
        Product product = new Product("Hammer", 66000 ); // need to havew right constructors in, this inputs a
        Product product1 = new Product();
        productsDao.save(product1);
        return "redirect:/products";
    }

    @GetMapping("/products/{id}")
    public String findProductsById(@PathVariable long id){
        Optional<Product> product = productsDao.findById(id);
        if(product.isPresent()){
            System.out.println(product.get());
        }
      return "redirect:/products";
    }

    @GetMapping("/jpa/2")
    @ResponseBody
    public List<Product> getAllProductsOrderedByCost() {
        return productsDao.findAllByOrderByCostInCents();
    }

    @GetMapping("/jpa/3")
    @ResponseBody
    public List<Product> getAllProductsOrderedByCostDesc() {
        return productsDao.findAllByOrderByCostInCentsDesc();
    }

    @GetMapping("/jpa/4")
    @ResponseBody
    public List<Product> getProductByCost() {
        return productsDao.findByCostInCents(9670);
    }

    @GetMapping("/jpa/5")
    @ResponseBody
    public List<Product> getProductByCostInRange() {
        return productsDao.searchProductByCostInCentsBetween(500, 1000);
    }

//    @GetMapping("/jpa/6")
//    @ResponseBody
//    public List<String> getNamesById() {
//        return productsDao.findNameById(1L, 10L);
//    }

//    @GetMapping("/jpa/7")
//    @ResponseBody
//    public List<String> getNamesByIdNative() {
//        return productsDao.findNameByIdNative(1L, 10L);
//    }
//
}

