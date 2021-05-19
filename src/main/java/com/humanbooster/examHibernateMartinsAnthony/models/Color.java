/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.examHibernateMartinsAnthony.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author HB
 */
@Entity
@Table(name = "color")
public class Color {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "color_car",
            joinColumns = {
                @JoinColumn(name = "color_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "car_id")}
    )
    Set<Car> cars = new HashSet<>();

    @Basic
    @Column(name = "libelle", nullable = false, length = 255)
    @Length(max = 255, min = 1, message = "Le libelle doit contenir entre 1 et 255 caracteres")
    @NotNull(message = "Le libelle ne peut pas etre null")
    private String libelle;
}
