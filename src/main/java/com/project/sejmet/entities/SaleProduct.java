package com.project.sejmet.entities;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="sale_product")
@Data
public class SaleProduct implements Serializable{
    @Id
    @SequenceGenerator(name="sale_product_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sale_product_id_seq")
    private int id;

    @OneToOne
    @JoinColumn(name="sale_id")
    private Sale sale;

    @OneToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name = "product_amount")
    private int productAmount;
}
