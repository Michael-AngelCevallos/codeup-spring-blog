package com.codeup.codeupspringblog.repositories;


import com.codeup.codeupspringblog.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// implements crud functionality
public interface ProductsRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByOrderByCostInCents();

    List<Product> findAllByOrderByCostInCentsDesc();

    List<Product> findByCostInCents(int i);

    List<Product> searchProductByCostInCentsBetween(int i, int i1);

//    List<String> findNameById(long l, long l1);
//
//    List<String> findNameByIdNative(long l, long l1);


    // some cases you may be able to call a method/functions if you use the right wording(like below)
//    List<Product> findByCostInCents();

}
