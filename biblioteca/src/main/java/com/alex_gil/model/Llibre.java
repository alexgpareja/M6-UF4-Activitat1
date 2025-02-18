package com.alex_gil.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Llibres")
public class Llibre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLlibre; // Identificador únic del llibre

    @Column(unique = true, nullable = false)
    private long isbn; // ISBN del llibre (únic i obligatori)

    @Column(nullable = false)
    private String titol; // Títol del llibre (obligatori)

    @Column(nullable = false)
    private String autor; // Autor del llibre (obligatori)

    @Column(nullable = false)
    private int anyPublicacio; // Any de publicació del llibre (obligatori)

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false) // Un llibre NOMÉS pot tenir UNA categoria (ManyToOne)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "reserva_id", nullable = true) // Un llibre NOMÉS pot estar en UNA reserva (ManyToOne)
    private Reserva reserva;

    // Constructor per defecte (necessari per Hibernate)
    public Llibre() {
    }

    // Constructor personalitzat
    public Llibre(long isbn, String titol, String autor, int anyPublicacio, Categoria categoria) {
        this.isbn = isbn;
        this.titol = titol;
        this.autor = autor;
        this.anyPublicacio = anyPublicacio;
        this.categoria = categoria;
        this.reserva = null; // Inicialment el llibre NO està reservat
    }

    // Getters i Setters
    public int getIdLlibre() {
        return idLlibre;
    }

    public void setIdLlibre(int idLlibre) {
        this.idLlibre = idLlibre;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnyPublicacio() {
        return anyPublicacio;
    }

    public void setAnyPublicacio(int anyPublicacio) {
        this.anyPublicacio = anyPublicacio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    // Disponibilitat automàtica: si el llibre té una reserva, no està disponible
    public boolean isDisponible() {
        return reserva == null;
    }

    @Override
    public String toString() {
        return "Llibre{" +
                "idLlibre=" + idLlibre +
                ", isbn=" + isbn +
                ", titol='" + titol + '\'' +
                ", autor='" + autor + '\'' +
                ", anyPublicacio=" + anyPublicacio +
                ", categoria=" + (categoria != null ? categoria.getNomCategoria() : "Sense categoria") +
                ", disponible=" + isDisponible() +
                '}';
    }
}
