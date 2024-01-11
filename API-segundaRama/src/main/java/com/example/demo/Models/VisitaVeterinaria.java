package com.example.demo.Models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visita_veterinaria")
public class VisitaVeterinaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_visita")
    private Long idVisita;

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    private Mascota mascota;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "razon_visita")
    private String razonVisita;

    @Column(name = "diagnostico")
    private String diagnostico;

    // Constructor vacío (necesario para JPA)
    public VisitaVeterinaria() {
    }

    // Constructor con parámetros para facilitar la creación de instancias
    public VisitaVeterinaria(Mascota mascota, Date fecha, String razonVisita, String diagnostico) {
        this.mascota = mascota;
        this.fecha = fecha;
        this.razonVisita = razonVisita;
        this.diagnostico = diagnostico;
    }

    // Getters y Setters

    public Long getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(Long idVisita) {
        this.idVisita = idVisita;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRazonVisita() {
        return razonVisita;
    }

    public void setRazonVisita(String razonVisita) {
        this.razonVisita = razonVisita;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    // Otros métodos si es necesario

    @Override
    public String toString() {
        return "VisitaVeterinaria{" +
                "idVisita=" + idVisita +
                ", mascota=" + mascota +
                ", fecha=" + fecha +
                ", razonVisita='" + razonVisita + '\'' +
                ", diagnostico='" + diagnostico + '\'' +
                '}';
    }
}
