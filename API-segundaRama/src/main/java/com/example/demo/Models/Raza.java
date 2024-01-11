package com.example.demo.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "raza")
public class Raza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_raza")
    private Long idRaza;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "origen")
    private String origen;

    @Column(name = "expectativa_vida")
    private int expectativaVida;

    // Constructor vacío (necesario para JPA)
    public Raza() {
    }

    // Constructor con parámetros para facilitar la creación de instancias
    public Raza(String nombre, String descripcion, String origen, int expectativaVida) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.origen = origen;
        this.expectativaVida = expectativaVida;
    }

    // Getters y Setters

    public Long getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(Long idRaza) {
        this.idRaza = idRaza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getExpectativaVida() {
        return expectativaVida;
    }

    public void setExpectativaVida(int expectativaVida) {
        this.expectativaVida = expectativaVida;
    }

    // Otros métodos si es necesario

    @Override
    public String toString() {
        return "Raza{" +
                "idRaza=" + idRaza +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", origen='" + origen + '\'' +
                ", expectativaVida=" + expectativaVida +
                '}';
    }
}
