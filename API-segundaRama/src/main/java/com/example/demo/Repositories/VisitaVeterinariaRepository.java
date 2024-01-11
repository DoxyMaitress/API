package com.example.demo.Repositories;

import com.example.demo.Models.VisitaVeterinaria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitaVeterinariaRepository extends JpaRepository<VisitaVeterinaria, Long> {
    List<VisitaVeterinaria> findAll();

    // Corregir el nombre del método para hacer referencia a idMascota en lugar de id
    List<VisitaVeterinaria> findByMascotaIdMascota(Long idMascota);
}
