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
@Table(name="user")
@Data
public class User implements Serializable {
    @Id
    @SequenceGenerator(name="user_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_id_seq")
    private int id;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

    private String userName;
    private String typeIdentityCard;
    private int identityCardNumber;
    private String email;
    private String password;
    private String address;
}
