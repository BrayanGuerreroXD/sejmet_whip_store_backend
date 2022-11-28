package com.project.sejmet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="product")
@Data
public class Product implements Serializable{
    @Id
    @SequenceGenerator(name="product_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_id_seq")
    private int id;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "visibility")
    private int visibility;

    @Column(name = "sale_price")
    private int salePrice;

    @Column(name = "stock")
    private int stock;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_characteristics")
    private String productCharacteristics;
}
