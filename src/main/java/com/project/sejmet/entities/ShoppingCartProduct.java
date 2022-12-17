package com.project.sejmet.entities;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="shopping_cart_product")
@Data
public class ShoppingCartProduct implements Serializable{

    @Id
    @SequenceGenerator(name="shopping_cart__product_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="shopping_cart_product_id_seq")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="shopping_cart_id")
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
}
