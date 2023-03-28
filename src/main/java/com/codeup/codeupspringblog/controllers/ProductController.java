package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Product;
import com.codeup.codeupspringblog.repositories.PostRepository;
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

    private ProductsRepository productsDao;

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
        return "redirect:/";
    }

    @GetMapping("/products")
    public String getProductsIndexPage(Model model) {
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Xbox", 22000),
                new Product(2L, "3DO", 20),
                new Product(3L, "CDI", 500)
        ));

//        List<Product> filteredProductsList = products
//            .stream()
//            .filter(product -> product.getCostInCents() < 100)
//            .collect(Collectors.toList());

        model.addAttribute("products", products);
        return "product/index";
    }




    // =========== USING JPA
    @GetMapping("/delete/products")
    public String deletePosts(){
        productsDao.deleteById(4l);
        return "redirect:/products";
    }

    @GetMapping("/create/product")
    public String createTheProduct(){
        Product product = new Product("Hammer", 66000 ); // need to havew right constructors in, this inputs a
        productsDao.save(product);
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

}
