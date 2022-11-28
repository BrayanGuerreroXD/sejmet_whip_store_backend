package com.project.sejmet.entities;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="sale")
@Data
public class Sale implements Serializable{
    @Id
    @SequenceGenerator(name="sale_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sale_id_seq")
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "sale_date")
    private Date saleDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "total_price")
    private int totalPrice;
}
