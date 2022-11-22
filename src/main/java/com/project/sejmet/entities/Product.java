package com.project.sejmet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    private String productName;
    private int visibility;
    private int salePrice;
    private int stock;
    private String productDescription;
    private String productCharacteristics;
}
