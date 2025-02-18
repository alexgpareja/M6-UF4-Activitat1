package com.alex_gil.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoria; // Identificador únic de la categoria

    @Column(nullable = false, unique = true)
    private String nomCategoria; // Nom de la categoria (únic i obligatori)

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Llibre> llibres;

    // Constructor
    public Categoria() {
    }

    public Categoria(String nomCategoria) {
        this.nomCategoria = nomCategoria;
    }

    // Getters i Setters
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomCategoria() {
        return nomCategoria;
    }

    public void setNomCategoria(String nomCategoria) {
        this.nomCategoria = nomCategoria;
    }

    public List<Llibre> getLlibres() {
        return llibres;
    }

    public void setLlibres(List<Llibre> llibres) {
        this.llibres = llibres;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", nomCategoria='" + nomCategoria + '\'' +
                '}';
    }
}