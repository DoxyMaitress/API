package com.example.demo.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "visita_veterinaria")
public class VisitaVeterinaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVisita;

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    private Mascota mascota;

    private Date fecha;
    private String razonVisita;
    private String diagnostico;

    // Getter y Setter para idVisita
    public Long getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(Long idVisita) {
        this.idVisita = idVisita;
    }

    // Getter y Setter para mascota
    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    // Getters y Setters para los demás atributos
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


}
