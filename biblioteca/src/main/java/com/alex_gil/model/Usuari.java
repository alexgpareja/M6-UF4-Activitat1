package com.alex_gil.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Usuari")
public class Usuari implements Serializable {

    @Id
    private String dni; // DNI de l'usuari (clau primària)

    @Column(nullable = false)
    private String nomUsuari; // Nom de l'usuari (obligatori)

    @Column(nullable = false)
    private String telefon; // Telèfon de l'usuari (obligatori)

    @Column(nullable = false, unique = true)
    private String email; // Email de l'usuari (únic i obligatori)

    @OneToMany(mappedBy = "usuari") // Relació 1 a N amb Reserva (un usuari pot fer diverses reserves)
    private Set<Reserva> reserves;

    // Constructor
    public Usuari() {
    }

    public Usuari(String dni, String nomUsuari, String telefon, String email) {
        this.dni = dni;
        this.nomUsuari = nomUsuari;
        this.telefon = telefon;
        this.email = email;
    }

    // Getters i Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Reserva> getReserves() {
        return reserves;
    }

    public void setReserves(Set<Reserva> reserves) {
        this.reserves = reserves;
    }

    @Override
    public String toString() {
        return "Usuari{" +
                "dni='" + dni + '\'' +
                ", nomUsuari='" + nomUsuari + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}