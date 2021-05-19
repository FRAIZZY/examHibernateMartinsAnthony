/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.examHibernateMartinsAnthony.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author HB
 */
@Entity
@Table(name = "garage")
public class Garage {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(targetEntity = Car.class, mappedBy = "id")
    private List<Car> cars = new ArrayList<>();

    @Basic
    @Column(name = "nom", nullable = false, length = 255)
    @Length(max = 255, min = 1, message = "Le nom doit contenir entre 1 et 255 caracteres")
    @NotNull(message = "Le nom ne peut pas etre null")
    private String nom;

    @Basic
    @Column(name = "rue", nullable = false, length = 255)
    @Length(max = 255, min = 1, message = "La rue doit contenir entre 1 et 255 caracteres")
    @NotNull(message = "La rue ne peut pas etre null")
    private String rue;

    @Basic
    @Column(name = "code_postal", nullable = false, length = 255)
    @Length(max = 255, min = 1, message = "Le code_postal doit contenir entre 1 et 255 caracteres")
    @NotNull(message = "Le code_postal ne peut pas etre null")
    private String codePostal;

    @Basic
    @Column(name = "ville", nullable = false, length = 255)
    @Length(max = 255, min = 1, message = "La ville doit contenir entre 1 et 255 caracteres")
    @NotNull(message = "La ville ne peut pas etre null")
    private String ville;

    @Basic
    @Column(name = "num_telephone", nullable = false, length = 255)
    @Length(max = 255, min = 1, message = "Le telephone doit contenir entre 1 et 255 caracteres")
    @NotNull(message = "Le telephone ne peut pas etre null")
    private String numTelephone;

    @Basic
    @Column(name = "num_siret", nullable = false, length = 255)
    @Length(max = 255, min = 1, message = "Le siret doit contenir entre 1 et 255 caracteres")
    @NotNull(message = "Le siret ne peut pas etre null")
    private String numSiret;
}
