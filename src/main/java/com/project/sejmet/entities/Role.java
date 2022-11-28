package com.project.sejmet.entities;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="role")
@Data
public class Role implements Serializable{
    @Id
    @SequenceGenerator(name="role_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="role_id_seq")
    private int id;

    @Column(name = "role_name")
    private String roleName;
}
