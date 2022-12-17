package com.project.sejmet.repository;

import com.project.sejmet.entities.ShoppingCartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartProductRepository extends JpaRepository<ShoppingCartProduct, Integer> {
}
