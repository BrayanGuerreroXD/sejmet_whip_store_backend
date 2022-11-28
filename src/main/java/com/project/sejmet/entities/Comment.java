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
@Table(name="comment")
@Data
public class Comment implements Serializable{
    @Id
    @SequenceGenerator(name="image_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="image_id_seq")
    private int id;

    @OneToOne
    @JoinColumn(name="sale_product_id")
    private SaleProduct saleProduct;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "str_comment")
    private String strComment;

    @Column(name = "score")
    private int score;
}
