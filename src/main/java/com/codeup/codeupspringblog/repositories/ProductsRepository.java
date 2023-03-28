package com.codeup.codeupspringblog.repositories;


import com.codeup.codeupspringblog.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// implements crud functionality
public interface ProductsRepository extends JpaRepository<Product, Long> {


}
