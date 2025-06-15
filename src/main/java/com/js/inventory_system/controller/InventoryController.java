package com.js.inventory_system.controller;


import com.js.inventory_system.model.Product;
import com.js.inventory_system.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

        private InventoryService inventoryService;

        public InventoryController(InventoryService inventoryService){
            this.inventoryService = inventoryService;
        }

        @GetMapping
        public String getInventory(){
         return "get inventory method called";
        }

        @GetMapping("/products")
        public List<Product> getAllProducts(){
            return  inventoryService.getAllProducts();
        }

        @GetMapping("/{id}")
        public Product getById(@PathVariable int id){
            return inventoryService.getProductById(id);
        }

        @PostMapping("/product")
        public String  createProduct(@RequestBody Product product){

            inventoryService.addProduct(product);
            return "Product created successfully: " + product.toString();
        }

        @PutMapping
        public void update(@RequestBody Product product){
          inventoryService.updateProduct(product);
        }

        @DeleteMapping("/{id}")
        public void deleteById(@PathVariable int id){
          inventoryService.deleteProductById(id);

        }




}
