package com.project.sejmet.entities;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="user")
@Data
public class User implements Serializable {
    @Id
    @SequenceGenerator(name="user_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_id_seq")
    private int id;

    @ManyToOne
    private Role role;

    private String userName;
    private String typeIdentityCard;
    private int identityCardNumber;
    private String email;
    private String password;
    private String address;
}
