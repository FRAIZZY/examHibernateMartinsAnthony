/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.examHibernateMartinsAnthony.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author HB
 */
@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "garage_id", referencedColumnName = "id")
    private Garage garage;

    @OneToMany(targetEntity = Images.class, mappedBy = "id")
    private List<Images> images = new ArrayList<>();

    @ManyToMany(mappedBy = "cars")
    private Set<Color> colors = new HashSet<>();

    @Basic
    @Column(name = "marque", nullable = false, length = 255)
    @Length(max = 255, min = 1, message = "La marque doit contenir entre 1 et 255 caracteres")
    @NotNull(message = "La marque ne peut pas etre null")
    private String marque;

    @Basic
    @Column(name = "modele", nullable = false, length = 255)
    @Length(max = 255, min = 1, message = "Le modele doit contenir entre 1 et 255 caracteres")
    @NotNull(message = "Le modele ne peut pas etre null")
    private String modele;

    @Basic
    @Column(name = "carburant", nullable = false, length = 255)
    @Length(max = 255, min = 1, message = "Le carburant doit contenir entre 1 et 255 caracteres")
    @NotNull(message = "Le carburant ne peut pas etre null")
    private String carburant;

    @Basic
    @Column(name = "annee", nullable = false)
    @NotNull(message = "L'annee ne peut pas etre null")
    private Integer annee;

    @Basic
    @Column(name = "kilometrage", nullable = false)
    @NotNull(message = "Le kilometrage ne peut pas etre null")
    private Integer kilometrage;

    @Basic
    @Column(name = "prix", nullable = false)
    @NotNull(message = "Le prix ne peut pas etre null")
    private Integer prix;

    @Basic
    @Column(name = "date_ajout", nullable = false, columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "La date d'ajout ne peut pas etre null")
    private Date dateAjout;

    @Basic
    @Column(name = "description", nullable = false, length = 65535, columnDefinition = "longtext")
    @NotNull(message = "La description ne peut pas etre null")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public Set<Color> getColors() {
        return colors;
    }

    public void setColors(Set<Color> colors) {
        this.colors = colors;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Integer getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(Integer kilometrage) {
        this.kilometrage = kilometrage;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", garage=" + garage + ", images=" + images + ", colors=" + colors + ", marque=" + marque + ", modele=" + modele + ", carburant=" + carburant + ", annee=" + annee + ", kilometrage=" + kilometrage + ", prix=" + prix + ", dateAjout=" + dateAjout + ", description=" + description + '}';
    }

}
