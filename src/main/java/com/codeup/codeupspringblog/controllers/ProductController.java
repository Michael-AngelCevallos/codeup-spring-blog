package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Product;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductController {



    @GetMapping("/products/create")
    public


    @GetMapping
    public String {
    return"redirect:/";
}
@GetMapping
public String getProductaIndexPage(Model model){
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1L, "Xbox", 22000),
            new Product(1L, "Xbox", 22000),
            new Product(1L, "Xbox", 22000)
    );
    model.addAttribute("products", products);

}
