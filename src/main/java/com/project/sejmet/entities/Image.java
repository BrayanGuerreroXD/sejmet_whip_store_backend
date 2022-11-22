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
@Table(name="image")
@Data
public class Image implements Serializable{
    @Id
    @SequenceGenerator(name="image_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="image_id_seq")
    private int id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    private String imageName;
    private String imageSrc;
}
