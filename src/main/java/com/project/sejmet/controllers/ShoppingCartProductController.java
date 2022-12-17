package com.project.sejmet.controllers;

import com.project.sejmet.entities.ShoppingCartProduct;
import com.project.sejmet.repository.ShoppingCartProductRepository;
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
@RequestMapping("/shopping_carts_products")
public class ShoppingCartProductController {

    @Autowired
    ShoppingCartProductRepository shoppingCartProductRepository;


    @GetMapping
    public List<ShoppingCartProduct> getShoppingCartProductAll() {
        return shoppingCartProductRepository.findAll();
    }


    @GetMapping("/{id}")
    public ShoppingCartProduct getShoppingCartProductbyId(@PathVariable int id) {

        Optional<ShoppingCartProduct> shoppingCartProduct = shoppingCartProductRepository.findById(id);

        if (shoppingCartProduct.isPresent()) {
            return shoppingCartProduct.get();
        }

        return null;
    }


    @PostMapping
    public ShoppingCartProduct postShoppingCartProduct(@RequestBody ShoppingCartProduct shoppingCartProduct) {
        shoppingCartProductRepository.save(shoppingCartProduct);
        return shoppingCartProduct;
    }


    @PutMapping("/{id}")
    public ShoppingCartProduct putShoppingCartProductbyId(@PathVariable int id, @RequestBody ShoppingCartProduct shoppingCartProduct) {

        Optional<ShoppingCartProduct> shoppingCartProductCurrent = shoppingCartProductRepository.findById(id);

        if (shoppingCartProductCurrent.isPresent()) {
            ShoppingCartProduct shoppingCartProductReturn = shoppingCartProductCurrent.get();

            shoppingCartProductReturn.setShoppingCart(shoppingCartProduct.getShoppingCart());
            shoppingCartProductReturn.setProduct(shoppingCartProduct.getProduct());

            shoppingCartProductRepository.save(shoppingCartProductReturn);
            return shoppingCartProductReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public ShoppingCartProduct deleteShoppingCartProductbyId(@PathVariable int id) {

        Optional<ShoppingCartProduct> shoppingCartProduct = shoppingCartProductRepository.findById(id);

        if (shoppingCartProduct.isPresent()) {
            ShoppingCartProduct shoppingCartProductReturn = shoppingCartProduct.get();
            shoppingCartProductRepository.deleteById(id);
            return shoppingCartProductReturn;
        }

        return null;
    }
}
