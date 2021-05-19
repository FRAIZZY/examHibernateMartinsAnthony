/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.examHibernateMartinsAnthony.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author HB
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(targetEntity = Garage.class, mappedBy = "id")
    private List<Garage> garages = new ArrayList<>();

    @Basic
    @Column(name = "username", nullable = false, length = 180)
    @Length(max = 180, min = 1, message = "Le username doit contenir entre 1 et 180 caracteres")
    @NotNull(message = "Le username ne peut pas etre null")
    private String username;

    @Basic
    @Column(name = "roles", nullable = false, length = 65535, columnDefinition = "longtext")
    @NotNull(message = "Le role ne peut pas etre null")
    private String roles;

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    @Length(max = 255, min = 1, message = "Le password doit contenir entre 1 et 255 caracteres")
    @NotNull(message = "Le password ne peut pas etre null")
    private String password;

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    @Length(max = 255, min = 1, message = "L'email doit contenir entre 1 et 255 caracteres")
    @NotNull(message = "L'email ne peut pas etre null")
    private String email;

    @Basic
    @Column(name = "nom", nullable = false, length = 255)
    @Length(max = 255, min = 1, message = "Le nom doit contenir entre 1 et 255 caracteres")
    @NotNull(message = "Le nom ne peut pas etre null")
    private String nom;

    @Basic
    @Column(name = "prenom", nullable = false, length = 255)
    @Length(max = 255, min = 1, message = "Le prenom doit contenir entre 1 et 255 caracteres")
    @NotNull(message = "Le prenom ne peut pas etre null")
    private String prenom;

    @Basic
    @Column(name = "num_telephone", nullable = false, length = 255)
    @Length(max = 255, min = 1, message = "Le telephone doit contenir entre 1 et 255 caracteres")
    @NotNull(message = "Le telephone ne peut pas etre null")
    private String numTelephone;
}
