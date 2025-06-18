package com.js.inventory_system.service;

import com.js.inventory_system.dao.ProductDao;
import com.js.inventory_system.dao.ProductDaoImplementation;
import com.js.inventory_system.exception.IdNotFoundException;
import com.js.inventory_system.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private ProductDao productDao;
    @Autowired
    public InventoryService(ProductDao productDao){
              this.productDao = productDao;
    }
    public List<Product> getAllProducts(){
       return productDao.findAll();
    }
    public Product getProductById(int id){
        Product product = productDao.findById(id);
        if (product == null) {
            throw new IdNotFoundException("Product with ID " + id + " not found");
        }
       return productDao.findById(id);
    }

    public Product addProduct(Product product){
       return productDao.save(product);
    }

    public void updateProduct(Product product){
       productDao.update(product);
    }

    public void deleteProductById(int id){
        productDao.deleteById(id);
    }

}
