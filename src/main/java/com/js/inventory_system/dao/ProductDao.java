package com.js.inventory_system.dao;

import com.js.inventory_system.model.Product;
//import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductDao {

    List<Product> findAll();

    Product findById(int id);

    Product save(Product product);

    void update(Product product);

    void deleteById(int id);


}
