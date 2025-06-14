package com.js.inventory_system.dao;

import com.js.inventory_system.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImplementation implements ProductDao{

    private final List<Product> products = new ArrayList<>();
    @Override
    public List<Product> findAll(){
         return products;
    }

    @Override
    public Product findById(int id){
       return products.stream().filter(product->product.getId()==id).findFirst().orElse(null);
    }

    @Override
    public Product save(Product product){
        products.add(product);
        return product;
    }

    @Override
    public void update(Product product){
         Product existingProduct = findById(product.getId());
         if(existingProduct != null){
             existingProduct.setName(product.getName());
             existingProduct.setPrice(product.getPrice());
         }
    }

    @Override
    public void deleteById(int id){
       products.removeIf(product ->product.getId()==id);
    }


}
