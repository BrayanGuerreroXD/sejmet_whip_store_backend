package com.project.sejmet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="shopping_cart")
@Data
public class ShoppingCart {
    @Id
    @SequenceGenerator(name="shopping_cart_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="shopping_cart_id_seq")
    private int id;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "amount")
    private int amount;
}
