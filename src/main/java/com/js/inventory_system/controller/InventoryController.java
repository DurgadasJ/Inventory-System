package com.js.inventory_system.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {


        @GetMapping
        public String getInventory(){
         return "get inventory method called";
        }


}
