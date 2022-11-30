package com.project.sejmet.controllers;

import com.project.sejmet.entities.ShoppingCart;
import com.project.sejmet.repository.ShoppingCartRepository;
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
@RequestMapping("/shopping_carts")
public class ShoppingCartController {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;


    @GetMapping
    public List<ShoppingCart> getShoppingCartAll() {
        return shoppingCartRepository.findAll();
    }


    @GetMapping("/{id}")
    public ShoppingCart getShoppingCartbyId(@PathVariable int id) {

        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(id);

        if (shoppingCart.isPresent()) {
            return shoppingCart.get();
        }

        return null;
    }


    @PostMapping
    public ShoppingCart postShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
        return shoppingCart;
    }


    @PutMapping("/{id}")
    public ShoppingCart putShoppingCartbyId(@PathVariable int id, @RequestBody ShoppingCart shoppingCart) {

        Optional<ShoppingCart> shoppingCartCurrent = shoppingCartRepository.findById(id);

        if (shoppingCartCurrent.isPresent()) {
            ShoppingCart shoppingCartReturn = shoppingCartCurrent.get();

            shoppingCartReturn.setProduct(shoppingCart.getProduct());
            shoppingCartReturn.setUser(shoppingCart.getUser());
            shoppingCartReturn.setAmount(shoppingCart.getAmount());

            shoppingCartRepository.save(shoppingCartReturn);
            return shoppingCartReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public ShoppingCart deleteShoppingCartbyId(@PathVariable int id) {

        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(id);

        if (shoppingCart.isPresent()) {
            ShoppingCart shoppingCartReturn = shoppingCart.get();
            shoppingCartRepository.deleteById(id);
            return shoppingCartReturn;
        }

        return null;
    }
}
