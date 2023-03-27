package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Product;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class ProductController {

    @GetMapping("/products")
    public String returnProductCreateView() {
        return "products";
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



@GetMapping
public String getProductsIndexPage(Model model){
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1L, "Xbox", 22000),
            new Product(2L, "Ps4", 20),
            new Product(3L, "Laptop", 43000)
    ));

//    List<Product> filteredProductList = products.stream().>

    model.addAttribute("products", products);
    return "product/index";


    }

}
