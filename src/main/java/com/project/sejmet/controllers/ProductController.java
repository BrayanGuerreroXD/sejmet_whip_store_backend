package com.project.sejmet.controllers;

import com.project.sejmet.entities.Product;
import com.project.sejmet.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;


    @GetMapping
    public List<Product> getProductAll() {
        return productRepository.findAll();
    }


    @GetMapping("/{id}")
    public Product getProductbyId(@PathVariable int id) {

        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            return product.get();
        }

        return null;
    }


    @PostMapping
    public Product postProduct(@RequestBody Product product) {
        productRepository.save(product);
        return product;
    }


    @PutMapping("/{id}")
    public Product putProductbyId(@PathVariable int id, @RequestBody Product product) {

        Optional<Product> productCurrent = productRepository.findById(id);

        if (productCurrent.isPresent()) {
            Product productReturn = productCurrent.get();

            productReturn.setCategory(product.getCategory());
            productReturn.setProductName(product.getProductName());
            productReturn.setVisibility(product.getVisibility());
            productReturn.setSalePrice(product.getSalePrice());
            productReturn.setStock(product.getStock());
            productReturn.setProductDescription(product.getProductDescription());
            productReturn.setProductCharacteristics(product.getProductCharacteristics());

            productRepository.save(productReturn);
            return productReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public Product deleteProductbyId(@PathVariable int id) {

        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            Product productReturn = product.get();
            productRepository.deleteById(id);
            return productReturn;
        }

        return null;
    }
}
