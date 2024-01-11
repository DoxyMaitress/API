package com.example.demo.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Long idMascota;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    @ManyToOne
    @JoinColumn(name = "id_raza")
    private Raza raza;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private Propietario propietario;

    // Constructor vacío (necesario para JPA)
    public Mascota() {
    }

    // Constructor con parámetros para facilitar la creación de instancias
    public Mascota(String nombre, int edad, Raza raza, Propietario propietario) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.propietario = propietario;
    }

    // Getters y Setters

    public Long getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Long idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    // Otros métodos si es necesario

    @Override
    public String toString() {
        return "Mascota{" +
                "idMascota=" + idMascota +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", raza=" + raza +
                ", propietario=" + propietario +
                '}';
    }
}
